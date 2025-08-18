
package com.fbol.ucic.service.wsdl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Business Name: Analytics Marketing Offer<br>Valid Values:<br>Business Description:Contains the analytics marketing offers for an Involved Party based on analytics engine.<br>Comments:</p>
 * 
 * <p>Java class for AnalyticsMarketingOffer complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AnalyticsMarketingOffer"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="OfrId" type="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *         &lt;element name="OfrTyp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"&gt;
 *         &lt;element name="Nme" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"&gt;
 *         &lt;element name="ImgMedia" type="{ResourceItem}ImageMedia" minOccurs="0"&gt;
 *         &lt;element name="TxtMedia" type="{ResourceItem}TextMedia" minOccurs="0"&gt;
 *         &lt;element name="ProdId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AnalyticsMarketingOffer", namespace = "https://www.firstbankonline.com/Communication", propOrder = {
    "ofrId",
    "ofrTyp",
    "nme",
    "imgMedia",
    "txtMedia",
    "prodId"
})
public class AnalyticsMarketingOffer {

    @XmlElement(name = "OfrId", required = true)
    protected String ofrId;
    @XmlElement(name = "OfrTyp")
    protected String ofrTyp;
    @XmlElement(name = "Nme")
    protected String nme;
    @XmlElement(name = "ImgMedia")
    protected ImageMedia imgMedia;
    @XmlElement(name = "TxtMedia")
    protected TextMedia txtMedia;
    @XmlElement(name = "ProdId")
    protected String prodId;

    /**
     * Gets the value of the ofrId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOfrId() {
        return ofrId;
    }

    /**
     * Sets the value of the ofrId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOfrId(String value) {
        this.ofrId = value;
    }

    /**
     * Gets the value of the ofrTyp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOfrTyp() {
        return ofrTyp;
    }

    /**
     * Sets the value of the ofrTyp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOfrTyp(String value) {
        this.ofrTyp = value;
    }

    /**
     * Gets the value of the nme property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNme() {
        return nme;
    }

    /**
     * Sets the value of the nme property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNme(String value) {
        this.nme = value;
    }

    /**
     * Gets the value of the imgMedia property.
     * 
     * @return
     *     possible object is
     *     {@link ImageMedia }
     *     
     */
    public ImageMedia getImgMedia() {
        return imgMedia;
    }

    /**
     * Sets the value of the imgMedia property.
     * 
     * @param value
     *     allowed object is
     *     {@link ImageMedia }
     *     
     */
    public void setImgMedia(ImageMedia value) {
        this.imgMedia = value;
    }

    /**
     * Gets the value of the txtMedia property.
     * 
     * @return
     *     possible object is
     *     {@link TextMedia }
     *     
     */
    public TextMedia getTxtMedia() {
        return txtMedia;
    }

    /**
     * Sets the value of the txtMedia property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextMedia }
     *     
     */
    public void setTxtMedia(TextMedia value) {
        this.txtMedia = value;
    }

    /**
     * Gets the value of the prodId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProdId() {
        return prodId;
    }

    /**
     * Sets the value of the prodId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProdId(String value) {
        this.prodId = value;
    }

}
