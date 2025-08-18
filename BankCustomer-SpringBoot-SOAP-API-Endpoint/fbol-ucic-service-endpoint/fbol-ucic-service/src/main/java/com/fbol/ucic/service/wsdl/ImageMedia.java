
package com.fbol.ucic.service.wsdl;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p >Business Name: Image Media</p><p >Valid Values:</p><p >Business Description: Contains attributes associated to an Image based media.</p><p >Comments:</p>
 * 
 * <p>Java class for ImageMedia complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ImageMedia"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="TrgtUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"&gt;
 *         &lt;element name="ImgUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"&gt;
 *         &lt;element name="ImgWdth" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"&gt;
 *         &lt;element name="ImgHeight" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ImageMedia", namespace = "https://www.firstbankonline.com/ResourceItem", propOrder = {
    "trgtUrl",
    "imgUrl",
    "imgWdth",
    "imgHeight"
})
public class ImageMedia {

    @XmlElement(name = "TrgtUrl")
    protected String trgtUrl;
    @XmlElement(name = "ImgUrl")
    protected String imgUrl;
    @XmlElement(name = "ImgWdth")
    protected BigInteger imgWdth;
    @XmlElement(name = "ImgHeight")
    protected BigInteger imgHeight;

    /**
     * Gets the value of the trgtUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTrgtUrl() {
        return trgtUrl;
    }

    /**
     * Sets the value of the trgtUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTrgtUrl(String value) {
        this.trgtUrl = value;
    }

    /**
     * Gets the value of the imgUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImgUrl() {
        return imgUrl;
    }

    /**
     * Sets the value of the imgUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImgUrl(String value) {
        this.imgUrl = value;
    }

    /**
     * Gets the value of the imgWdth property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getImgWdth() {
        return imgWdth;
    }

    /**
     * Sets the value of the imgWdth property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setImgWdth(BigInteger value) {
        this.imgWdth = value;
    }

    /**
     * Gets the value of the imgHeight property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getImgHeight() {
        return imgHeight;
    }

    /**
     * Sets the value of the imgHeight property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setImgHeight(BigInteger value) {
        this.imgHeight = value;
    }

}
