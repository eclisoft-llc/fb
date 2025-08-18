package com.fbol.ssoremit.service.wsdl.client;

import com.fbol.ssoremit.service.model.SsoToken;
import com.fbol.ssoremit.service.model.Authentication;
import com.fbol.ssoremit.service.model.request.Action;
import com.fbol.ssoremit.service.model.request.RMRequest;
import com.fbol.ssoremit.service.model.response.RMResponse;
import com.fbol.ssoremit.service.security.Rfc2898DeriveBytes;
import com.fbol.ssoremit.service.wsdl.Execute;
import com.fbol.ssoremit.service.wsdl.ExecuteResponse;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.*;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPMessage;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import java.io.*;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;


public class RestClient extends WebServiceGatewaySupport {

    private static final Resource KEYSTORE_LOCATION = new ClassPathResource("client-app.jks");

    @Autowired
    private Environment env;
    @Autowired
    private WebClient.Builder webClientBuilder;

    private final String ENDPOINT = "https://test-portal.remitstreamreceivables.com/API/RemittanceManager/RemittanceManager.asmx";

    @Value("${customercode}")
    private String CustomerCode;
    @Value("${clientid}")
    private String ClientID;
    @Value("${endpoint}")
    private String endpoint;
    @Value("${encryptionkey}")
    private String Encryptionkey;


    public SsoToken getAuthToken(String userid) throws Exception {

            Authentication auth = new Authentication();
            auth.setUserid(userid);

            String token = encrypt(Encryptionkey,(userid+Encryptionkey+ClientID).trim());
            auth.setToken(token);
            auth.setClientid(this.ClientID);

            Action action = new Action();
            action.setCustomerCode(this.CustomerCode);
            action.setUserid(userid);
            action.setName("GetSSOToken");

            RMRequest request = new RMRequest();
            request.setAction(action);
            request.setAuthentication(auth);

        StringWriter sw = new StringWriter();

        JAXBContext jc = JAXBContext.newInstance(RMRequest.class);
        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
        marshaller.marshal(request, sw);

        String result = sw.toString();

        Execute req = new Execute();
        req.setXmlRequest(result);

        JAXBElement<ExecuteResponse> response = (JAXBElement<ExecuteResponse>) getWebServiceTemplate()
                .marshalSendAndReceive(endpoint,req);

        String XmlString=response.getValue().getExecuteResult().replaceAll("\\<\\?xml(.+?)\\?\\>", "").trim();
        RMResponse re = convertXMLToObject(XmlString);

        SsoToken sso = new SsoToken();

        sso.setToken(token);
        sso.setRedirectUrl(re.getAction().getRedirectUrl());
        sso.setMessage(re.getAction().getMessage());

        return sso;

    }

    public static String encrypt(String inkey, String value){


        try{

            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            byte[] salt = new byte[] { 1, 2, 3, 4, 5, 6, 7, 8 };
            char[] password = inkey.toCharArray();
            PBEKeySpec pbeKeySpec = new PBEKeySpec(password, salt, 1000, 384);
            Key secretKey = factory.generateSecret(pbeKeySpec);
            byte[] key = new byte[32];
            byte[] iv = new byte[16];
            System.arraycopy(secretKey.getEncoded(), 0, key, 0, 32);
            System.arraycopy(secretKey.getEncoded(), 32, iv, 0, 16);

            SecretKeySpec secret = new SecretKeySpec(key, "AES");
            AlgorithmParameterSpec ivSpec = new IvParameterSpec(iv);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secret, ivSpec);
            byte[] result = cipher.doFinal(value.getBytes("UTF-16LE"));

            return Base64.encodeBase64String(result);
        } catch(Exception e){

            e.printStackTrace();
        }

        return null;

    }

    public static RMResponse convertXMLToObject(String xml) throws XMLStreamException, UnsupportedEncodingException, JAXBException {
        InputStream xmlstream = new ByteArrayInputStream(xml.getBytes("UTF-8"));
        JAXBContext context = JAXBContext.newInstance(RMResponse.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        XMLInputFactory xmlfactory = XMLInputFactory.newInstance();
        XMLEventReader xmlsourcereader = xmlfactory.createXMLEventReader(xmlstream);
        JAXBElement<RMResponse> xmlelement = unmarshaller.unmarshal(xmlsourcereader, RMResponse.class);
        RMResponse convertedobject = xmlelement.getValue();
        return convertedobject;
    }


}