
package com.fbol.ucic.service.wsdl;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tMsgType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="tMsgType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="System Error"&gt;
 *     &lt;enumeration value="Application Error"&gt;
 *     &lt;enumeration value="Validation Error"&gt;
 *     &lt;enumeration value="Informational Message"&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "tMsgType", namespace = "https://www.firstbankonline.com/FisCommonRspHdr")
@XmlEnum
public enum TMsgType {

    @XmlEnumValue("System Error")
    SYSTEM_ERROR("System Error"),
    @XmlEnumValue("Application Error")
    APPLICATION_ERROR("Application Error"),
    @XmlEnumValue("Validation Error")
    VALIDATION_ERROR("Validation Error"),
    @XmlEnumValue("Informational Message")
    INFORMATIONAL_MESSAGE("Informational Message");
    private final String value;

    TMsgType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TMsgType fromValue(String v) {
        for (TMsgType c: TMsgType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
