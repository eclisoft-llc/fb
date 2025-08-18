
package com.fbol.ucic.service.wsdl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArIdentifier complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArIdentifier"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="EntprsArTyp" type="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *         &lt;element name="ArPrfx" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"&gt;
 *         &lt;element name="ArId" type="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *         &lt;element name="SubArId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArIdentifier", namespace = "https://www.firstbankonline.com/Arrangements", propOrder = {
    "entprsArTyp",
    "arPrfx",
    "arId",
    "subArId"
})
@XmlSeeAlso({
    ArKey.class
})
public class ArIdentifier {

    @XmlElement(name = "EntprsArTyp", required = true)
    protected String entprsArTyp;
    @XmlElement(name = "ArPrfx")
    protected String arPrfx;
    @XmlElement(name = "ArId", required = true)
    protected String arId;
    @XmlElement(name = "SubArId")
    protected String subArId;

    /**
     * Gets the value of the entprsArTyp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEntprsArTyp() {
        return entprsArTyp;
    }

    /**
     * Sets the value of the entprsArTyp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEntprsArTyp(String value) {
        this.entprsArTyp = value;
    }

    /**
     * Gets the value of the arPrfx property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArPrfx() {
        return arPrfx;
    }

    /**
     * Sets the value of the arPrfx property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArPrfx(String value) {
        this.arPrfx = value;
    }

    /**
     * Gets the value of the arId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArId() {
        return arId;
    }

    /**
     * Sets the value of the arId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArId(String value) {
        this.arId = value;
    }

    /**
     * Gets the value of the subArId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubArId() {
        return subArId;
    }

    /**
     * Sets the value of the subArId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubArId(String value) {
        this.subArId = value;
    }

}
