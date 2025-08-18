
package com.fbol.ucic.service.wsdl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Business Name: Involved Party Arrangement Key<br>Valid Values:<br>Business Description: Contains either involved party key or arrangement key details.<br>Comments:</p>
 * 
 * <p>Java class for IpArKey complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IpArKey"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice&gt;
 *         &lt;element name="IpKey" type="{InvolvedParty}IpKey"&gt;
 *         &lt;element name="ArKey" type="{Arrangements}ArKey"&gt;
 *       &lt;/choice&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IpArKey", namespace = "XPRetrieveIpAnlytcsMktDtlRqst", propOrder = {
    "ipKey",
    "arKey"
})
public class IpArKey {

    @XmlElement(name = "IpKey")
    protected IpKey ipKey;
    @XmlElement(name = "ArKey")
    protected ArKey arKey;

    /**
     * Gets the value of the ipKey property.
     * 
     * @return
     *     possible object is
     *     {@link IpKey }
     *     
     */
    public IpKey getIpKey() {
        return ipKey;
    }

    /**
     * Sets the value of the ipKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link IpKey }
     *     
     */
    public void setIpKey(IpKey value) {
        this.ipKey = value;
    }

    /**
     * Gets the value of the arKey property.
     * 
     * @return
     *     possible object is
     *     {@link ArKey }
     *     
     */
    public ArKey getArKey() {
        return arKey;
    }

    /**
     * Sets the value of the arKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArKey }
     *     
     */
    public void setArKey(ArKey value) {
        this.arKey = value;
    }

}
