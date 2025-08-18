
package com.fbol.ssoremit.service.wsdl;

import com.fbol.ssoremit.service.model.response.RMResponse;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ExecuteResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "executeResult"
})
@XmlRootElement(name = "ExecuteResponse")
public class ExecuteResponse {

    @XmlElement(name = "ExecuteResult")
    protected String executeResult;

    /**
     * Gets the value of the executeResult property.
     * 
     * @return
     *     possible object is
     *     {@link ExecuteResult }
     *
     */
    public String getExecuteResult() {
        return executeResult;
    }

    /**
     * Sets the value of the executeResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExecuteResult }
     *     
     */
    public void setExecuteResult(String value) {
        this.executeResult = value;
    }

}
