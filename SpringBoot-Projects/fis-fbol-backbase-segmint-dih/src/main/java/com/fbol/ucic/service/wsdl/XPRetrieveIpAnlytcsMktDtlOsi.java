
package com.fbol.ucic.service.wsdl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for XPRetrieveIpAnlytcsMktDtlOsi complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="XPRetrieveIpAnlytcsMktDtlOsi"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="FeRqstKey" type="{Common}FeRequestKey"&gt;
 *         &lt;element name="IpArKey" type="{XPRetrieveIpAnlytcsMktDtlRqst}IpArKey"&gt;
 *         &lt;element name="RqstAccTyp" type="{Common}RequestAccessType" minOccurs="0"&gt;
 *         &lt;element name="LstCntl" type="{Common}ListControl" minOccurs="0"&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XPRetrieveIpAnlytcsMktDtlOsi", namespace = "XPRetrieveIpAnlytcsMktDtlRqst", propOrder = {
    "feRqstKey",
    "ipArKey",
    "rqstAccTyp",
    "lstCntl"
})
public class XPRetrieveIpAnlytcsMktDtlOsi {

    @XmlElement(name = "FeRqstKey", required = true)
    protected FeRequestKey feRqstKey;
    @XmlElement(name = "IpArKey", required = true)
    protected IpArKey ipArKey;
    @XmlElement(name = "RqstAccTyp")
    protected RequestAccessType rqstAccTyp;
    @XmlElement(name = "LstCntl")
    protected ListControl lstCntl;

    /**
     * Gets the value of the feRqstKey property.
     * 
     * @return
     *     possible object is
     *     {@link FeRequestKey }
     *     
     */
    public FeRequestKey getFeRqstKey() {
        return feRqstKey;
    }

    /**
     * Sets the value of the feRqstKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link FeRequestKey }
     *     
     */
    public void setFeRqstKey(FeRequestKey value) {
        this.feRqstKey = value;
    }

    /**
     * Gets the value of the ipArKey property.
     * 
     * @return
     *     possible object is
     *     {@link IpArKey }
     *     
     */
    public IpArKey getIpArKey() {
        return ipArKey;
    }

    /**
     * Sets the value of the ipArKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link IpArKey }
     *     
     */
    public void setIpArKey(IpArKey value) {
        this.ipArKey = value;
    }

    /**
     * Gets the value of the rqstAccTyp property.
     * 
     * @return
     *     possible object is
     *     {@link RequestAccessType }
     *     
     */
    public RequestAccessType getRqstAccTyp() {
        return rqstAccTyp;
    }

    /**
     * Sets the value of the rqstAccTyp property.
     * 
     * @param value
     *     allowed object is
     *     {@link RequestAccessType }
     *     
     */
    public void setRqstAccTyp(RequestAccessType value) {
        this.rqstAccTyp = value;
    }

    /**
     * Gets the value of the lstCntl property.
     * 
     * @return
     *     possible object is
     *     {@link ListControl }
     *     
     */
    public ListControl getLstCntl() {
        return lstCntl;
    }

    /**
     * Sets the value of the lstCntl property.
     * 
     * @param value
     *     allowed object is
     *     {@link ListControl }
     *     
     */
    public void setLstCntl(ListControl value) {
        this.lstCntl = value;
    }

}
