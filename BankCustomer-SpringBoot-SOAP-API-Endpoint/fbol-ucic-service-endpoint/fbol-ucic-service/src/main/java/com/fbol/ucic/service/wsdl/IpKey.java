
package com.fbol.ucic.service.wsdl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IpKey complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IpKey"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{InvolvedParty}IpIdentifier"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Sor" type="{Common}Sor" minOccurs="0"&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IpKey", namespace = "https://www.firstbankonline.com/InvolvedParty", propOrder = {
    "sor"
})
public class IpKey
    extends IpIdentifier
{

    @XmlElement(name = "Sor")
    protected Sor sor;

    /**
     * Gets the value of the sor property.
     * 
     * @return
     *     possible object is
     *     {@link Sor }
     *     
     */
    public Sor getSor() {
        return sor;
    }

    /**
     * Sets the value of the sor property.
     * 
     * @param value
     *     allowed object is
     *     {@link Sor }
     *     
     */
    public void setSor(Sor value) {
        this.sor = value;
    }

}
