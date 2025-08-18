
package com.fbol.ucic.service.wsdl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Sor complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Sor"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="PrcsrNme" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"&gt;
 *         &lt;element name="ApplNme" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Sor", propOrder = {
    "prcsrNme",
    "applNme"
})
public class Sor {

    @XmlElement(name = "PrcsrNme")
    protected String prcsrNme;
    @XmlElement(name = "ApplNme")
    protected String applNme;

    /**
     * Gets the value of the prcsrNme property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrcsrNme() {
        return prcsrNme;
    }

    /**
     * Sets the value of the prcsrNme property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrcsrNme(String value) {
        this.prcsrNme = value;
    }

    /**
     * Gets the value of the applNme property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApplNme() {
        return applNme;
    }

    /**
     * Sets the value of the applNme property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApplNme(String value) {
        this.applNme = value;
    }

}
