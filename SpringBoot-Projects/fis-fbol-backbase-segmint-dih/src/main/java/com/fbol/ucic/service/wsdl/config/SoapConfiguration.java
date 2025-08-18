package com.fbol.ucic.service.wsdl.config;

import com.fbol.ucic.service.wsdl.client.UcicClient;
import org.apache.wss4j.common.WSS4JConstants;
import org.apache.wss4j.dom.handler.WSHandlerConstants;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.web.filter.CommonsRequestLoggingFilter;
import org.springframework.ws.client.support.interceptor.ClientInterceptor;
import org.springframework.ws.soap.security.support.KeyManagersFactoryBean;
import org.springframework.ws.soap.security.support.KeyStoreFactoryBean;
import org.springframework.ws.soap.security.support.TrustManagersFactoryBean;
import org.springframework.ws.soap.security.wss4j2.Wss4jSecurityInterceptor;
import org.springframework.ws.soap.security.wss4j2.support.CryptoFactoryBean;
import org.springframework.ws.transport.http.HttpsUrlConnectionMessageSender;

import java.io.IOException;
import java.math.BigInteger;

@Configuration
class SoapConfiguration {

    private static final Resource KEYSTORE_LOCATION = new ClassPathResource("client-app2.jks");
    private static final String KEYSTORE_PASSWORD = "ucicfbol";
    private static final String KEY_ALIAS = "firstbank";

    @Bean
    Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.fbol.ucic.service.wsdl");
        return marshaller;
    }

   @Bean
    KeyStoreFactoryBean keyStore() {
        KeyStoreFactoryBean factoryBean = new KeyStoreFactoryBean();
        factoryBean.setLocation(KEYSTORE_LOCATION);
        factoryBean.setPassword(KEYSTORE_PASSWORD);
        return factoryBean;
    }

    @Bean
    TrustManagersFactoryBean trustManagers(KeyStoreFactoryBean keyStore) {
        TrustManagersFactoryBean factoryBean = new TrustManagersFactoryBean();
        factoryBean.setKeyStore(keyStore.getObject());
        return factoryBean;
    }

    @Bean
    HttpsUrlConnectionMessageSender messageSender(
            KeyStoreFactoryBean keyStore,
            TrustManagersFactoryBean trustManagers
    ) throws Exception {
        HttpsUrlConnectionMessageSender sender = new HttpsUrlConnectionMessageSender();

        KeyManagersFactoryBean keyManagersFactoryBean = new KeyManagersFactoryBean();
        keyManagersFactoryBean.setKeyStore(keyStore.getObject());
        keyManagersFactoryBean.setPassword(KEYSTORE_PASSWORD);
        keyManagersFactoryBean.afterPropertiesSet();

        sender.setKeyManagers(keyManagersFactoryBean.getObject());

        sender.setTrustManagers(trustManagers.getObject());
        return sender;
    }

    @Bean
    CryptoFactoryBean cryptoFactoryBean() throws IOException {
        CryptoFactoryBean cryptoFactoryBean = new CryptoFactoryBean();
        cryptoFactoryBean.setKeyStoreLocation(KEYSTORE_LOCATION);
        cryptoFactoryBean.setKeyStorePassword(KEYSTORE_PASSWORD);
        //org.apache.ws.security.components.crypto
        return cryptoFactoryBean;
    }

    @Bean
    Wss4jSecurityInterceptor securityInterceptor(CryptoFactoryBean cryptoFactoryBean) throws Exception {
        Wss4jSecurityInterceptor securityInterceptor = new Wss4jSecurityInterceptor();

        securityInterceptor.setSecurementActions(WSHandlerConstants.NO_SECURITY);
        securityInterceptor.setSecurementUsername(KEY_ALIAS);
        securityInterceptor.setSecurementPassword(KEYSTORE_PASSWORD);

        //securityInterceptor.setSecurementSignatureKeyIdentifier("DirectReference");
        securityInterceptor.setSecurementSignatureAlgorithm(WSS4JConstants.RSA_SHA1);
        securityInterceptor.setSecurementSignatureDigestAlgorithm(WSS4JConstants.SHA1);

        securityInterceptor.setSecurementSignatureCrypto(cryptoFactoryBean.getObject());

        return securityInterceptor;
    }


    //@Bean
    UcicClient ucicClient(
            Jaxb2Marshaller marshaller,
            HttpsUrlConnectionMessageSender messageSender
    ) {
        UcicClient ucicClient = new UcicClient();

        //ucicClient.setInterceptors(new ClientInterceptor[]{securityInterceptor});
        //ucicClient.setMessageSender(messageSender);

        ucicClient.setMarshaller(marshaller);
        ucicClient.setUnmarshaller(marshaller);

        return ucicClient;
    }

    @Bean
    UcicClient ucicClient(
            Jaxb2Marshaller marshaller,
            HttpsUrlConnectionMessageSender messageSender,
            Wss4jSecurityInterceptor securityInterceptor
    ) {
        UcicClient ucicClient = new UcicClient();

        ucicClient.setInterceptors(new ClientInterceptor[]{securityInterceptor});
        ucicClient.setMessageSender(messageSender);

        ucicClient.setMarshaller(marshaller);
        ucicClient.setUnmarshaller(marshaller);

        return ucicClient;
    }

    @Bean
    public CommonsRequestLoggingFilter requestLoggingFilter() {
        CommonsRequestLoggingFilter loggingFilter = new CommonsRequestLoggingFilter();
        loggingFilter.setIncludeClientInfo(true);
        loggingFilter.setIncludeQueryString(true);
        loggingFilter.setIncludePayload(true);
        loggingFilter.setMaxPayloadLength(64000);
        return loggingFilter;
    }
}
