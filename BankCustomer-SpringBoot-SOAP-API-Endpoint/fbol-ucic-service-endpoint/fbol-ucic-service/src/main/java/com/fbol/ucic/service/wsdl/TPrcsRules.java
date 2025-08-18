
package com.fbol.ucic.service.wsdl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tPrcsRules complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tPrcsRules"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="PrcsRule"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;enumeration value="PrcsAsTxn"&gt;
 *               &lt;enumeration value="PrcsAsTranStpOnFrstErr"&gt;
 *               &lt;enumeration value="PrcsAsMultiServ"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="RunAs" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"&gt;
 *         &lt;element name="FeId" type="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *         &lt;element name="ServId" type="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *         &lt;element name="ServVer" type="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *         &lt;element name="ApplId" type="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tPrcsRules", namespace = "https://www.firstbankonline.com/FisCommonRqstHdr", propOrder = {
    "prcsRule",
    "runAs",
    "feId",
    "servId",
    "servVer",
    "applId"
})
public class TPrcsRules {

    @XmlElement(name = "PrcsRule", required = true)
    protected String prcsRule;
    @XmlElement(name = "RunAs")
    protected String runAs;
    @XmlElement(name = "FeId", required = true)
    protected String feId;
    @XmlElement(name = "ServId", required = true)
    protected String servId;
    @XmlElement(name = "ServVer", required = true)
    protected String servVer;
    @XmlElement(name = "ApplId", required = true)
    protected String applId;

    /**
     * Gets the value of the prcsRule property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrcsRule() {
        return prcsRule;
    }

    /**
     * Sets the value of the prcsRule property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrcsRule(String value) {
        this.prcsRule = value;
    }

    /**
     * Gets the value of the runAs property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRunAs() {
        return runAs;
    }

    /**
     * Sets the value of the runAs property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRunAs(String value) {
        this.runAs = value;
    }

    /**
     * Gets the value of the feId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeId() {
        return feId;
    }

    /**
     * Sets the value of the feId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeId(String value) {
        this.feId = value;
    }

    /**
     * Gets the value of the servId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServId() {
        return servId;
    }

    /**
     * Sets the value of the servId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServId(String value) {
        this.servId = value;
    }

    /**
     * Gets the value of the servVer property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServVer() {
        return servVer;
    }

    /**
     * Sets the value of the servVer property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServVer(String value) {
        this.servVer = value;
    }

    /**
     * Gets the value of the applId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApplId() {
        return applId;
    }

    /**
     * Sets the value of the applId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApplId(String value) {
        this.applId = value;
    }

}
