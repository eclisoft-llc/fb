
package com.fbol.ucic.service.wsdl;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ListControl complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ListControl"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="LstEntryVal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"&gt;
 *         &lt;element name="NbrOfEnty" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" minOccurs="0"&gt;
 *         &lt;element name="RqstSetSize" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" minOccurs="0"&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ListControl", propOrder = {
    "lstEntryVal",
    "nbrOfEnty",
    "rqstSetSize"
})
public class ListControl {

    @XmlElement(name = "LstEntryVal")
    protected String lstEntryVal;
    @XmlElement(name = "NbrOfEnty")
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger nbrOfEnty;
    @XmlElement(name = "RqstSetSize")
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger rqstSetSize;

    /**
     * Gets the value of the lstEntryVal property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLstEntryVal() {
        return lstEntryVal;
    }

    /**
     * Sets the value of the lstEntryVal property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLstEntryVal(String value) {
        this.lstEntryVal = value;
    }

    /**
     * Gets the value of the nbrOfEnty property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNbrOfEnty() {
        return nbrOfEnty;
    }

    /**
     * Sets the value of the nbrOfEnty property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNbrOfEnty(BigInteger value) {
        this.nbrOfEnty = value;
    }

    /**
     * Gets the value of the rqstSetSize property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getRqstSetSize() {
        return rqstSetSize;
    }

    /**
     * Sets the value of the rqstSetSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setRqstSetSize(BigInteger value) {
        this.rqstSetSize = value;
    }

}
