
package com.fbol.ucic.service.wsdl;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AccessType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AccessType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Admin User"&gt;
 *     &lt;enumeration value="Customer"&gt;
 *     &lt;enumeration value="System"&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "AccessType")
@XmlEnum
public enum AccessType {

    @XmlEnumValue("Admin User")
    ADMIN_USER("Admin User"),
    @XmlEnumValue("Customer")
    CUSTOMER("Customer"),
    @XmlEnumValue("System")
    SYSTEM("System");
    private final String value;

    AccessType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AccessType fromValue(String v) {
        for (AccessType c: AccessType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
