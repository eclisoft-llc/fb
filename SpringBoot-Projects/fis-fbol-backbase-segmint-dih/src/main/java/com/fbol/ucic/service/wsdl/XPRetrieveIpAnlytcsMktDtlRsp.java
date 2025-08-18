
package com.fbol.ucic.service.wsdl;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for XPRetrieveIpAnlytcsMktDtlRsp complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="XPRetrieveIpAnlytcsMktDtlRsp"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{FisCommonRspHdr}RspHdr"&gt;
 *         &lt;element ref="{XPRetrieveIpAnlytcsMktDtlRsp}XPRtrvIpAnlytcsMktDtlOso" minOccurs="0"&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlRootElement(name="XPRtrvIpAnlytcsMktDtlRsp")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XPRetrieveIpAnlytcsMktDtlRsp", namespace = "XPRetrieveIpAnlytcsMktDtlRsp", propOrder = {
    "rspHdr",
    "xpRtrvIpAnlytcsMktDtlOso"
})
public class XPRetrieveIpAnlytcsMktDtlRsp {

    @XmlElement(name = "RspHdr", namespace = "FisCommonRspHdr", required = true)
    protected TRspHdr rspHdr;
    @XmlElement(name = "XPRtrvIpAnlytcsMktDtlOso")
    protected XPRetrieveIpAnlytcsMktDtlOso xpRtrvIpAnlytcsMktDtlOso;

    /**
     * Gets the value of the rspHdr property.
     * 
     * @return
     *     possible object is
     *     {@link TRspHdr }
     *     
     */
    public TRspHdr getRspHdr() {
        return rspHdr;
    }

    /**
     * Sets the value of the rspHdr property.
     * 
     * @param value
     *     allowed object is
     *     {@link TRspHdr }
     *     
     */
    public void setRspHdr(TRspHdr value) {
        this.rspHdr = value;
    }

    /**
     * Gets the value of the xpRtrvIpAnlytcsMktDtlOso property.
     * 
     * @return
     *     possible object is
     *     {@link XPRetrieveIpAnlytcsMktDtlOso }
     *     
     */
    public XPRetrieveIpAnlytcsMktDtlOso getXPRtrvIpAnlytcsMktDtlOso() {
        return xpRtrvIpAnlytcsMktDtlOso;
    }

    /**
     * Sets the value of the xpRtrvIpAnlytcsMktDtlOso property.
     * 
     * @param value
     *     allowed object is
     *     {@link XPRetrieveIpAnlytcsMktDtlOso }
     *     
     */
    public void setXPRtrvIpAnlytcsMktDtlOso(XPRetrieveIpAnlytcsMktDtlOso value) {
        this.xpRtrvIpAnlytcsMktDtlOso = value;
    }

}
