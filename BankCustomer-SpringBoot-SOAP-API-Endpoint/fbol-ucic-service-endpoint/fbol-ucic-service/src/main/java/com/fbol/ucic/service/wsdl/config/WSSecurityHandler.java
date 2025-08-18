package com.fbol.ucic.service.wsdl.config;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPMessage;

import org.apache.wss4j.common.WSS4JConstants;
import org.apache.wss4j.common.crypto.Crypto;
import org.apache.wss4j.common.crypto.CryptoFactory;
import org.apache.wss4j.common.ext.WSSecurityException;
import org.apache.wss4j.dom.WSConstants;
import org.apache.wss4j.dom.message.WSSecHeader;
import org.apache.wss4j.dom.message.WSSecSignature;
import org.w3c.dom.Document;
/*
import org.apache.ws.security.WSConstants;
import org.apache.ws.security.WSSecurityException;
import org.apache.ws.security.components.crypto.Crypto;
import org.apache.ws.security.components.crypto.CryptoFactory;
import org.apache.ws.security.components.crypto.Merlin;
import org.apache.ws.security.message.WSSecHeader;
import org.apache.ws.security.message.WSSecSignature;
*/
import org.apache.wss4j.dom.engine.WSSConfig;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.ws.soap.security.wss4j2.support.CryptoFactoryBean;
import org.w3c.dom.Document;

import javax.xml.crypto.dsig.DigestMethod;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import java.io.IOException;
import java.util.Properties;


/**
 * Created by sidney.oliveira on 11/11/2015.
 */
public class WSSecurityHandler {

    private Properties properties;
    private static final Resource KEYSTORE_LOCATION = new ClassPathResource("client-app2.jks");
    private static final String KEYSTORE_PASSWORD = "ucicfbol";
    private static final String KEY_ALIAS = "firstbank";

    public WSSecurityHandler(Properties properties) {
        this.properties = properties;
    }

    public String handleMessage(SOAPMessage message) {
        String ret;
        try {
            Document doc = message.getSOAPBody().getOwnerDocument();



            //message.writeTo(System.out);

            System.out.println(signMessage(message.getSOAPPart()));

            //Crypto crypto = CryptoFactory.getInstance(properties); //File
            //Merlin crypto = (Merlin)CryptoFactory.getInstance(properties);
           // Crypto crypto = CryptoFactory.getInstance("org.apache.ws.security.components.crypto.BouncyCastle", properties);

            /*
            CryptoFactoryBean cryptoFactory = new CryptoFactoryBean();
            cryptoFactory.setKeyStoreLocation(new ClassPathResource("client-app2.jks"));
            cryptoFactory.setKeyStorePassword("ucicfbol");
            cryptoFactory.afterPropertiesSet();
            Merlin crypto = (Merlin)cryptoFactory.getObject();
*/
            /*
            WSSecSignature sign = new WSSecSignature();

            sign.setUserInfo(properties.getProperty("org.apache.ws.security.crypto.merlin.keystore.alias"), properties.getProperty("privatekeypassword"));
            sign.setKeyIdentifierType(WSConstants.BST_DIRECT_REFERENCE); // Binary Security Token - SecurityTokenReference
            sign.setUseSingleCertificate(true);
            sign.setSignatureAlgorithm(DigestMethod.SHA256);

            WSSecHeader secHeader = new WSSecHeader();
            //secHeader.insertSecurityHeader(doc);
            //Document signedDoc = sign.build(doc, crypto, secHeader);

            ret = org.apache.ws.security.util.XMLUtils.PrettyDocumentToString(signedDoc);

             */

        } catch (WSSecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SOAPException e) {
            e.printStackTrace();
        }
        return "";
    }

    private static String signMessage(Document message) throws WSSecurityException, IOException {
        WSSecHeader secHeader = new WSSecHeader(message);
        secHeader.setMustUnderstand(false);
        secHeader.insertSecurityHeader();
        return generateSignature(secHeader);
    }

    private static String generateSignature(WSSecHeader secHeader) throws IOException, WSSecurityException {
        WSSecSignature builder = new WSSecSignature(secHeader);
        //builder.setSigCanonicalization(WSS4JConstants.C14N_EXCL_OMIT_COMMENTS);
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