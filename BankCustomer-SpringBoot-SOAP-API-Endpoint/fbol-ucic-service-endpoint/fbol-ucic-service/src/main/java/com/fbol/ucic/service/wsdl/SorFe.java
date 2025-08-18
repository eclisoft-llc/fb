
package com.fbol.ucic.service.wsdl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SorFe complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SorFe"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="SorFeId" type="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *         &lt;element name="Sor" type="{Common}Sor" minOccurs="0"&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SorFe", propOrder = {
    "sorFeId",
    "sor"
})
public class SorFe {

    @XmlElement(name = "SorFeId", required = true)
    protected String sorFeId;
    @XmlElement(name = "Sor")
    protected Sor sor;

    /**
     * Gets the value of the sorFeId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSorFeId() {
        return sorFeId;
    }

    /**
     * Sets the value of the sorFeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSorFeId(String value) {
        this.sorFeId = value;
    }

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
