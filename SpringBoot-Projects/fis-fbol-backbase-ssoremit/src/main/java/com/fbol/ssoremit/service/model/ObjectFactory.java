
package com.fbol.ssoremit.service.model;

import com.fbol.ssoremit.service.model.request.RMRequest;
import com.fbol.ssoremit.service.model.response.RMResponse;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.fbol.ucic.service.wsdl package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _RMResonse_QNAME = new QName("RMResponse", "RMResponse");
    private final static QName _RMRequest_QNAME = new QName("RMRequest", "RMRequest");


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.fbol.ucic.service.wsdl
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Authentication }
     * 
     */
    public Authentication createAuthentication() {
        return new Authentication();
    }


    /**
     * Create an instance of {@link com.fbol.ssoremit.service.model.request.Action }
     * 
     */
    public com.fbol.ssoremit.service.model.request.Action  createRqsaction() {
        return new com.fbol.ssoremit.service.model.request.Action ();
    }

    /**
     * Create an instance of {@link com.fbol.ssoremit.service.model.response.Action }
     *
     */

    public com.fbol.ssoremit.service.model.response.Action  createResaction() {
        return new com.fbol.ssoremit.service.model.response.Action ();
    }


    /**
     * Create an instance of {@link RMResponse }
     * 
     */
    public RMResponse createRMResponse() {
        return new RMResponse();
    }



    /**
     * Create an instance of {@link RMRequest }
     * 
     */
    public RMRequest createRMRequest() {
        return new RMRequest();
    }


    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RMResponse }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RMResponse }{@code >}
     */
    @XmlElementDecl(namespace = "RMResponse", name = "RMResponse")
    public JAXBElement<RMResponse> createRMResponse(RMResponse value) {
        return new JAXBElement<RMResponse>(_RMResonse_QNAME, RMResponse.class, null, value);
    }


    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RMRequest }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RMRequest }{@code >}
     */
    @XmlElementDecl(namespace = "XPRetrieveIpAnlytcsMktDtlRqst", name = "XPRtrvIpAnlytcsMktDtlRqst")
    public JAXBElement<RMRequest> createXPRtrvIpAnlytcsMktDtlRqst(RMRequest value) {
        return new JAXBElement<RMRequest>(_RMRequest_QNAME, RMRequest.class, null, value);
    }



}
