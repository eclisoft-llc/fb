
package com.fbol.ucic.service.wsdl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Business Name: Financial Entity Response Key<br>Valid Values:<br>Business Description: Contains key information identifying the financial entity associated with the response.<br>Comments: Even though FeId and SorFe are both optional, one or both must be returned from the service</p>
 * 
 * <p>Java class for FeResponseKey complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FeResponseKey"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="FeId" type="{Common}FeIdentifier" minOccurs="0"&gt;
 *         &lt;element name="SorFe" type="{Common}SorFe" minOccurs="0"&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FeResponseKey", propOrder = {
    "feId",
    "sorFe"
})
public class FeResponseKey {

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
