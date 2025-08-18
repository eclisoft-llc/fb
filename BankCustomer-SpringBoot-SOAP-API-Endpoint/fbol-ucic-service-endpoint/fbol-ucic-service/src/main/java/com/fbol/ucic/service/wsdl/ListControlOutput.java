
package com.fbol.ucic.service.wsdl;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ListControlOutput complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ListControlOutput"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="HasMore" type="{http://www.w3.org/2001/XMLSchema}boolean"&gt;
 *         &lt;element name="LstEntryVal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"&gt;
 *         &lt;element name="NbrOfEnty" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"&gt;
 *         &lt;element name="TotlRcrds" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" minOccurs="0"&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ListControlOutput", propOrder = {
    "hasMore",
    "lstEntryVal",
    "nbrOfEnty",
    "totlRcrds"
})
public class ListControlOutput {

    @XmlElement(name = "HasMore")
    protected boolean hasMore;
    @XmlElement(name = "LstEntryVal")
    protected String lstEntryVal;
    @XmlElement(name = "NbrOfEnty", required = true)
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger nbrOfEnty;
    @XmlElement(name = "TotlRcrds")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger totlRcrds;

    /**
     * Gets the value of the hasMore property.
     * 
     */
    public boolean isHasMore() {
        return hasMore;
    }

    /**
     * Sets the value of the hasMore property.
     * 
     */
    public void setHasMore(boolean value) {
        this.hasMore = value;
    }

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
     * Gets the value of the totlRcrds property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTotlRcrds() {
        return totlRcrds;
    }

    /**
     * Sets the value of the totlRcrds property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTotlRcrds(BigInteger value) {
        this.totlRcrds = value;
    }

}
