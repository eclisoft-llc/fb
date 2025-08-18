
package com.fbol.ucic.service.wsdl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Business Name: Involved PartyAnalytics Marketing Detail<br>Valid Values:<br>Business Description: Contains the associated analytics marketing elements associated with the involved party.<br>Comments:</p>
 * 
 * <p>Java class for IpAnalyticsMarketingDetail complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IpAnalyticsMarketingDetail"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="IpKey" type="{InvolvedParty}IpKey"&gt;
 *         &lt;element name="IpPrmryNme" type="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *         &lt;element name="PrmyCustInd" type="{http://www.w3.org/2001/XMLSchema}boolean"&gt;
 *         &lt;element name="AnlytcsMktDtl" type="{Communication}AnalyticsMarketingDetail"&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IpAnalyticsMarketingDetail", namespace = "XPInvolvedParty", propOrder = {
    "ipKey",
    "ipPrmryNme",
    "prmyCustInd",
    "anlytcsMktDtl"
})
public class IpAnalyticsMarketingDetail {

    @XmlElement(name = "IpKey", required = true)
    protected IpKey ipKey;
    @XmlElement(name = "IpPrmryNme", required = true)
    protected String ipPrmryNme;
    @XmlElement(name = "PrmyCustInd")
    protected boolean prmyCustInd;
    @XmlElement(name = "AnlytcsMktDtl", required = true)
    protected AnalyticsMarketingDetail anlytcsMktDtl;

    /**
     * Gets the value of the ipKey property.
     * 
     * @return
     *     possible object is
     *     {@link IpKey }
     *     
     */
    public IpKey getIpKey() {
        return ipKey;
    }

    /**
     * Sets the value of the ipKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link IpKey }
     *     
     */
    public void setIpKey(IpKey value) {
        this.ipKey = value;
    }

    /**
     * Gets the value of the ipPrmryNme property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIpPrmryNme() {
        return ipPrmryNme;
    }

    /**
     * Sets the value of the ipPrmryNme property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIpPrmryNme(String value) {
        this.ipPrmryNme = value;
    }

    /**
     * Gets the value of the prmyCustInd property.
     * 
     */
    public boolean isPrmyCustInd() {
        return prmyCustInd;
    }

    /**
     * Sets the value of the prmyCustInd property.
     * 
     */
    public void setPrmyCustInd(boolean value) {
        this.prmyCustInd = value;
    }

    /**
     * Gets the value of the anlytcsMktDtl property.
     * 
     * @return
     *     possible object is
     *     {@link AnalyticsMarketingDetail }
     *     
     */
    public AnalyticsMarketingDetail getAnlytcsMktDtl() {
        return anlytcsMktDtl;
    }

    /**
     * Sets the value of the anlytcsMktDtl property.
     * 
     * @param value
     *     allowed object is
     *     {@link AnalyticsMarketingDetail }
     *     
     */
    public void setAnlytcsMktDtl(AnalyticsMarketingDetail value) {
        this.anlytcsMktDtl = value;
    }

}
