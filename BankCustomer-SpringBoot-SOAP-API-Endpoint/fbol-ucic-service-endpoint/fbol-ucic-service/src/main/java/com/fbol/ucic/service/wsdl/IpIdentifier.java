
package com.fbol.ucic.service.wsdl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IpIdentifier complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IpIdentifier"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="IpId" type="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IpIdentifier", namespace = "https://www.firstbankonline.com/InvolvedParty", propOrder = {
    "ipId"
})
@XmlSeeAlso({
    IpKey.class
})
public class IpIdentifier {

    @XmlElement(name = "IpId", required = true)
    protected String ipId;

    /**
     * Gets the value of the ipId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIpId() {
        return ipId;
    }

    /**
     * Sets the value of the ipId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIpId(String value) {
        this.ipId = value;
    }

}
