
package com.fbol.ucic.service.wsdl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Business Name:AnalyticsMarketingDetail<br>Valid Values:<br>Business Description: Contains the analytics marketing details of an Involved Party.<br>Comments:</p>
 * 
 * <p>Java class for AnalyticsMarketingDetail complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AnalyticsMarketingDetail"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Ucic" type="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *         &lt;element name="MktSlctPrefInd" type="{http://www.w3.org/2001/XMLSchema}boolean"&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AnalyticsMarketingDetail", namespace = "Communication", propOrder = {
    "ucic",
    "mktSlctPrefInd"
})
public class AnalyticsMarketingDetail {

    @XmlElement(name = "Ucic", required = true)
    protected String ucic;
    @XmlElement(name = "MktSlctPrefInd")
    protected boolean mktSlctPrefInd;

    /**
     * Gets the value of the ucic property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUcic() {
        return ucic;
    }

    /**
     * Sets the value of the ucic property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUcic(String value) {
        this.ucic = value;
    }

    /**
     * Gets the value of the mktSlctPrefInd property.
     * 
     */
    public boolean isMktSlctPrefInd() {
        return mktSlctPrefInd;
    }

    /**
     * Sets the value of the mktSlctPrefInd property.
     * 
     */
    public void setMktSlctPrefInd(boolean value) {
        this.mktSlctPrefInd = value;
    }

}
