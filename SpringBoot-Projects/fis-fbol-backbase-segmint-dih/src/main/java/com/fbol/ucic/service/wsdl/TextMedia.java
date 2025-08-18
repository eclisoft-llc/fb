
package com.fbol.ucic.service.wsdl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p >Business Name: Text Media</p><p >Valid Values:</p><p >Business Description: Contains attributes associated to a Text based media.</p><p >Comments:</p>
 * 
 * <p>Java class for TextMedia complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TextMedia"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="StrtDte" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"&gt;
 *         &lt;element name="EndDte" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"&gt;
 *         &lt;element name="Msg" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TextMedia", namespace = "ResourceItem", propOrder = {
    "strtDte",
    "endDte",
    "msg"
})
public class TextMedia {

    @XmlElement(name = "StrtDte")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar strtDte;
    @XmlElement(name = "EndDte")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar endDte;
    @XmlElement(name = "Msg")
    protected byte[] msg;

    /**
     * Gets the value of the strtDte property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getStrtDte() {
        return strtDte;
    }

    /**
     * Sets the value of the strtDte property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setStrtDte(XMLGregorianCalendar value) {
        this.strtDte = value;
    }

    /**
     * Gets the value of the endDte property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEndDte() {
        return endDte;
    }

    /**
     * Sets the value of the endDte property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEndDte(XMLGregorianCalendar value) {
        this.endDte = value;
    }

    /**
     * Gets the value of the msg property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getMsg() {
        return msg;
    }

    /**
     * Sets the value of the msg property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setMsg(byte[] value) {
        this.msg = value;
    }

}
