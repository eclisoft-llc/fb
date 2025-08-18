package com.fbol.ucic.service.wsdl.client;

import com.fbol.ucic.service.wsdl.XPRetrieveIpAnlytcsMktDtlRqst;
import com.fbol.ucic.service.wsdl.config.SignSOAPRequest;
import org.apache.wss4j.common.crypto.Crypto;
import org.apache.wss4j.common.crypto.CryptoFactory;
import org.apache.wss4j.common.ext.WSSecurityException;
import org.apache.wss4j.dom.WSConstants;
import org.apache.wss4j.dom.message.WSSecHeader;
import org.apache.wss4j.dom.message.WSSecSignature;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.w3c.dom.Document;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.xml.bind.*;
import javax.xml.soap.*;
import java.io.StringReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Properties;


public class EndPoint<T,R> {

    private static final Resource KEYSTORE_LOCATION = new ClassPathResource("client-app2.jks");

    public R callSoapendpoint(String endpointURL, T request, R res) throws IOException, SOAPException, JAXBException, WSSecurityException {

        MessageFactory mf = MessageFactory.newInstance();
        SOAPMessage message = mf.createMessage();
        SOAPBody body = message.getSOAPBody();

        JAXBContext jc = JAXBContext.newInstance(request.getClass());
        Marshaller marshaller = jc.createMarshaller();
        marshaller.marshal(request, body);

        System.setProperty("java.net.useSystemProxies", "true");
        System.setProperty("javax.net.ssl.keyStore",KEYSTORE_LOCATION.getFile().getPath());
        System.setProperty("javax.net.ssl.keyStorePassword","ucicfbol");

        String str = signMessage(message.getSOAPPart());
        str = str.replace("https://www.firstbankonline.com/", "");
        System.out.println(str);
        SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
        SOAPConnection connection = soapConnectionFactory.createConnection();

        java.net.URL endpoint = new URL(endpointURL);
        SOAPMessage signedmessage = getSoapMessageFromString(str);
        SOAPMessage response = connection.call(signedmessage, endpoint);

        response.writeTo(System.out);

        System.out.println();
        /*
        StringReader sr = new StringReader(response.toString());
        JAXBContext jaxbContext = JAXBContext.newInstance(res.getClass());
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        R re = (R) unmarshaller.unmarshal(sr);

         */

        return null;
    }

    private SOAPMessage getSoapMessageFromString(String xml) throws SOAPException, IOException {
        MessageFactory factory = MessageFactory.newInstance();
        SOAPMessage message = factory.createMessage(new MimeHeaders(), new ByteArrayInputStream(xml.getBytes(Charset.forName("UTF-8"))));
        return message;
    }

    private static String signMessage(Document message) throws WSSecurityException, IOException {
        WSSecHeader secHeader = new WSSecHeader(message);
        secHeader.setMustUnderstand(false);
        secHeader.insertSecurityHeader();
        return generateSignature(secHeader);
    }

    private static String generateSignature(WSSecHeader secHeader) throws IOException, WSSecurityException {
        WSSecSignature builder = new WSSecSignature(secHeader);

        builder.setKeyIdentifierType(WSConstants.BST_DIRECT_REFERENCE);
        builder.setUserInfo("firstbank", "ucicfbol");
        Document doc = builder.build(createCrypto());

        return org.apache.ws.security.util.XMLUtils.PrettyDocumentToString(doc);
    }

    private static Crypto createCrypto() throws IOException, WSSecurityException {
        Properties properties = new Properties();
        properties.setProperty("org.apache.wss4j.crypto.merlin.keystore.file", KEYSTORE_LOCATION.getFile().getPath());
        properties.setProperty("org.apache.wss4j.crypto.merlin.keystore.password", "ucicfbol");
        return CryptoFactory.getInstance(properties);
    }
}
