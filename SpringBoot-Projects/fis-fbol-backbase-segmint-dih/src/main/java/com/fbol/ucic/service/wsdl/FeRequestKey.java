
package com.fbol.ucic.service.wsdl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Business Name: Financial Entity Request Key<br>Valid Values:<br>Business Description: Contains the specific financial entity key request information.<br>Comments:</p>
 * 
 * <p>Java class for FeRequestKey complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FeRequestKey"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="FeRqst" type="{Common}FeRequest"&gt;
 *         &lt;element name="OuId" type="{Common}OrgUnitId" minOccurs="0"&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FeRequestKey", propOrder = {
    "feRqst",
    "ouId"
})
public class FeRequestKey {

    @XmlElement(name = "FeRqst", required = true)
    protected FeRequest feRqst;
    @XmlElement(name = "OuId")
    protected String ouId;

    /**
     * Gets the value of the feRqst property.
     * 
     * @return
     *     possible object is
     *     {@link FeRequest }
     *     
     */
    public FeRequest getFeRqst() {
        return feRqst;
    }

    /**
     * Sets the value of the feRqst property.
     * 
     * @param value
     *     allowed object is
     *     {@link FeRequest }
     *     
     */
    public void setFeRqst(FeRequest value) {
        this.feRqst = value;
    }

    /**
     * Gets the value of the ouId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOuId() {
        return ouId;
    }

    /**
     * Sets the value of the ouId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOuId(String value) {
        this.ouId = value;
    }

}
