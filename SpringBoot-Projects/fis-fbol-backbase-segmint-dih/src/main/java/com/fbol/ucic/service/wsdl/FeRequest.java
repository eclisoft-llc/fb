
package com.fbol.ucic.service.wsdl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FeRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FeRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice&gt;
 *         &lt;element name="FeId" type="{Common}FeIdentifier"&gt;
 *         &lt;element name="SorFe" type="{Common}SorFe"&gt;
 *       &lt;/choice&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FeRequest", propOrder = {
    "feId",
    "sorFe"
})
public class FeRequest {

    @XmlElement(name = "FeId")
    protected String feId;
    @XmlElement(name = "SorFe")
    protected SorFe sorFe;

    /**
     * Gets the value of the feId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeId() {
        return feId;
    }

    /**
     * Sets the value of the feId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeId(String value) {
        this.feId = value;
    }

    /**
     * Gets the value of the sorFe property.
     * 
     * @return
     *     possible object is
     *     {@link SorFe }
     *     
     */
    public SorFe getSorFe() {
        return sorFe;
    }

    /**
     * Sets the value of the sorFe property.
     * 
     * @param value
     *     allowed object is
     *     {@link SorFe }
     *     
     */
    public void setSorFe(SorFe value) {
        this.sorFe = value;
    }

}
