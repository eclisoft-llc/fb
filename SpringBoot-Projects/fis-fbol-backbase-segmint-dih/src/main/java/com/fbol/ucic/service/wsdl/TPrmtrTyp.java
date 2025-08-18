
package com.fbol.ucic.service.wsdl;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tPrmtrTyp.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="tPrmtrTyp"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Code"&gt;
 *     &lt;enumeration value="Value"&gt;
 *     &lt;enumeration value="Value Code"&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "tPrmtrTyp", namespace = "FisCommonRspHdr")
@XmlEnum
public enum TPrmtrTyp {

    @XmlEnumValue("Code")
    CODE("Code"),
    @XmlEnumValue("Value")
    VALUE("Value"),
    @XmlEnumValue("Value Code")
    VALUE_CODE("Value Code");
    private final String value;

    TPrmtrTyp(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TPrmtrTyp fromValue(String v) {
        for (TPrmtrTyp c: TPrmtrTyp.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
