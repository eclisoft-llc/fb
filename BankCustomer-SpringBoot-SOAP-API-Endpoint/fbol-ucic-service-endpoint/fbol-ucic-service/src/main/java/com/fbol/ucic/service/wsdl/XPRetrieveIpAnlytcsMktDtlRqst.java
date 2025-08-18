
package com.fbol.ucic.service.wsdl;

import com.fbol.ucic.service.model.UsernameToken;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for XPRetrieveIpAnlytcsMktDtlRqst complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="XPRetrieveIpAnlytcsMktDtlRqst"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{FisCommonRqstHdr}RqstHdr"&gt;
 *         &lt;element ref="{XPRetrieveIpAnlytcsMktDtlRqst}XPRtrvIpAnlytcsMktDtlOsi"&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlRootElement(name="XPRetrieveIpAnlytcsMktDtlRqst")
@XmlSeeAlso({UsernameToken.class})
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XPRetrieveIpAnlytcsMktDtlRqst", namespace = "https://www.firstbankonline.com/XPRetrieveIpAnlytcsMktDtlRqst", propOrder = {
    "rqstHdr",
    "xpRtrvIpAnlytcsMktDtlOsi"
})
public class XPRetrieveIpAnlytcsMktDtlRqst {

    @XmlElement(name = "RqstHdr", namespace = "https://www.firstbankonline.com/FisCommonRqstHdr", required = true)
    protected TRqstHdr rqstHdr;
    @XmlElement(name = "XPRtrvIpAnlytcsMktDtlOsi", required = true)
    protected XPRetrieveIpAnlytcsMktDtlOsi xpRtrvIpAnlytcsMktDtlOsi;

    /**
     * Gets the value of the rqstHdr property.
     * 
     * @return
     *     possible object is
     *     {@link TRqstHdr }
     *     
     */
    public TRqstHdr getRqstHdr() {
        return rqstHdr;
    }

    /**
     * Sets the value of the rqstHdr property.
     * 
     * @param value
     *     allowed object is
     *     {@link TRqstHdr }
     *     
     */
    public void setRqstHdr(TRqstHdr value) {
        this.rqstHdr = value;
    }

    /**
     * Gets the value of the xpRtrvIpAnlytcsMktDtlOsi property.
     * 
     * @return
     *     possible object is
     *     {@link XPRetrieveIpAnlytcsMktDtlOsi }
     *     
     */
    public XPRetrieveIpAnlytcsMktDtlOsi getXPRtrvIpAnlytcsMktDtlOsi() {
        return xpRtrvIpAnlytcsMktDtlOsi;
    }

    /**
     * Sets the value of the xpRtrvIpAnlytcsMktDtlOsi property.
     * 
     * @param value
     *     allowed object is
     *     {@link XPRetrieveIpAnlytcsMktDtlOsi }
     *     
     */
    public void setXPRtrvIpAnlytcsMktDtlOsi(XPRetrieveIpAnlytcsMktDtlOsi value) {
        this.xpRtrvIpAnlytcsMktDtlOsi = value;
    }

}
