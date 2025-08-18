package com.fbol.ucic.service.wsdl.config;

import javax.xml.soap.*;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class SignSOAPRequest
{
    protected String resourceNameConfig =
            "src/main/resources/signature.properties";
    private String originalMessage = "";

    public void setResourceNameConfig(String resourceNameConfig) {
        this.resourceNameConfig = resourceNameConfig;
    }

    public String sign(SOAPMessage soapMessage) throws Exception {

        /*SOAPPart soapPart = soapMessage.getSOAPPart();
        SOAPEnvelope soapEnvelope = soapPart.getEnvelope();

        Name nome = soapEnvelope.createName("id", "soapsec",
                "http://schemas.xmlsoap.org/soap/security/2000-12");

        SOAPBody soapBody = soapEnvelope.getBody();
        soapBody.addAttribute(nome, "Body");
*/
        WSSecurityHandler handler = new WSSecurityHandler(loadConfig());

        return handler.handleMessage(soapMessage);
    }

    protected Properties loadConfig() {
        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream(resourceNameConfig));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return prop;
    }
}