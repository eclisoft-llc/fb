
package com.fbol.ucic.service.wsdl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for XPRetrieveIpAnlytcsMktDtlOso complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="XPRetrieveIpAnlytcsMktDtlOso"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="FeRspKey" type="{Common}FeResponseKey"&gt;
 *         &lt;element name="IpAnlytcsMktDtl" type="{XPInvolvedParty}IpAnalyticsMarketingDetail" maxOccurs="unbounded" minOccurs="0"&gt;
 *         &lt;element name="LstCntlOtpt" type="{Common}ListControlOutput" minOccurs="0"&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XPRetrieveIpAnlytcsMktDtlOso", namespace = "XPRetrieveIpAnlytcsMktDtlRsp", propOrder = {
    "feRspKey",
    "ipAnlytcsMktDtl",
    "lstCntlOtpt"
})
public class XPRetrieveIpAnlytcsMktDtlOso {

    @XmlElement(name = "FeRspKey", required = true)
    protected FeResponseKey feRspKey;
    @XmlElement(name = "IpAnlytcsMktDtl")
    protected List<IpAnalyticsMarketingDetail> ipAnlytcsMktDtl;
    @XmlElement(name = "LstCntlOtpt")
    protected ListControlOutput lstCntlOtpt;

    /**
     * Gets the value of the feRspKey property.
     * 
     * @return
     *     possible object is
     *     {@link FeResponseKey }
     *     
     */
    public FeResponseKey getFeRspKey() {
        return feRspKey;
    }

    /**
     * Sets the value of the feRspKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link FeResponseKey }
     *     
     */
    public void setFeRspKey(FeResponseKey value) {
        this.feRspKey = value;
    }

    /**
     * Gets the value of the ipAnlytcsMktDtl property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ipAnlytcsMktDtl property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIpAnlytcsMktDtl().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IpAnalyticsMarketingDetail }
     * 
     * 
     */
    public List<IpAnalyticsMarketingDetail> getIpAnlytcsMktDtl() {
        if (ipAnlytcsMktDtl == null) {
            ipAnlytcsMktDtl = new ArrayList<IpAnalyticsMarketingDetail>();
        }
        return this.ipAnlytcsMktDtl;
    }

    /**
     * Gets the value of the lstCntlOtpt property.
     * 
     * @return
     *     possible object is
     *     {@link ListControlOutput }
     *     
     */
    public ListControlOutput getLstCntlOtpt() {
        return lstCntlOtpt;
    }

    /**
     * Sets the value of the lstCntlOtpt property.
     * 
     * @param value
     *     allowed object is
     *     {@link ListControlOutput }
     *     
     */
    public void setLstCntlOtpt(ListControlOutput value) {
        this.lstCntlOtpt = value;
    }

}
