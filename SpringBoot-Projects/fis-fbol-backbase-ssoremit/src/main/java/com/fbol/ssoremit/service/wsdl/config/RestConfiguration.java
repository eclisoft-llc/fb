package com.fbol.ssoremit.service.wsdl.config;

import com.fbol.ssoremit.service.wsdl.client.RestClient;
import org.springframework.context.annotation.Bean;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.web.filter.CommonsRequestLoggingFilter;
import org.springframework.ws.client.support.interceptor.ClientInterceptor;


@org.springframework.context.annotation.Configuration
class RestConfiguration {


    @Bean
    Jaxb2Marshaller marshaller(){
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.fbol.ssoremit.service.wsdl");
        return marshaller;
    }

    @Bean
    RestClient restClient(
            Jaxb2Marshaller marshaller
    ) {
        RestClient restClient = new RestClient();
        restClient.setMarshaller(marshaller);
        restClient.setUnmarshaller(marshaller);
        restClient.setInterceptors(new ClientInterceptor[]{new SecurityInterceptor()});
        return restClient;
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
