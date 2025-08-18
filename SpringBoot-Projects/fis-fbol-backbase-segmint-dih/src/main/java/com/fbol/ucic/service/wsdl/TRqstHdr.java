
package com.fbol.ucic.service.wsdl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;
import org.w3c.dom.Element;


/**
 * <p>Java class for tRqstHdr complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tRqstHdr"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="RqstHdrVer"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;enumeration value="2.0.0"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="MsgUuid"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{FisCommonRqstHdr}tUuid"&gt;
 *               &lt;length value="36"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="SrcId" type="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *         &lt;element name="ActyId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"&gt;
 *         &lt;element name="TstInd" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;enumeration value="Y"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="LclPref"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{FisCommonRqstHdr}tLocale"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="PrcsRules" type="{FisCommonRqstHdr}tPrcsRules" minOccurs="0"&gt;
 *         &lt;element name="Sec"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;choice&gt;
 *                   &lt;element name="Trusted"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                         &lt;enumeration value="Y"&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="BasicAuthen"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="UsrId" type="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                             &lt;element name="Pswrd" type="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="SessAuthen"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;choice&gt;
 *                             &lt;element name="SessId" type="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                             &lt;element name="HttpSessId" type="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                           &lt;/choice&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="TokenAuthen"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;any processContents='lax' maxOccurs="unbounded" minOccurs="0"&gt;
 *                           &lt;/sequence&gt;
 *                           &lt;anyAttribute processContents='lax'/&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="WsSec"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                         &lt;enumeration value="Y"&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/choice&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="ServPrmtrsLst"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="ServPrmtrs" maxOccurs="unbounded"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="FeId" type="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                             &lt;element name="ServId" type="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                             &lt;element name="ServVer" type="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                             &lt;element name="ApplId" type="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                             &lt;element name="DataLnkId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"&gt;
 *                             &lt;element name="FldLst" minOccurs="0"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;complexContent&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                     &lt;sequence&gt;
 *                                       &lt;element name="Fld" maxOccurs="unbounded"&gt;
 *                                         &lt;complexType&gt;
 *                                           &lt;complexContent&gt;
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                               &lt;sequence&gt;
 *                                                 &lt;element name="FldNme" type="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                                 &lt;element name="FldVal" type="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                               &lt;/sequence&gt;
 *                                             &lt;/restriction&gt;
 *                                           &lt;/complexContent&gt;
 *                                         &lt;/complexType&gt;
 *                                       &lt;/element&gt;
 *                                     &lt;/sequence&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/complexContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tRqstHdr", namespace = "FisCommonRqstHdr", propOrder = {
    "rqstHdrVer",
    "msgUuid",
    "srcId",
    "actyId",
    "tstInd",
    "lclPref",
    "prcsRules",
    "sec",
    "servPrmtrsLst"
})
public class TRqstHdr {

    @XmlElement(name = "RqstHdrVer", required = true)
    protected String rqstHdrVer;
    @XmlElement(name = "MsgUuid", required = true)
    protected String msgUuid;
    @XmlElement(name = "SrcId", required = true)
    protected String srcId;
    @XmlElement(name = "ActyId")
    protected String actyId;
    @XmlElement(name = "TstInd")
    protected String tstInd;
    @XmlElement(name = "LclPref", required = true)
    protected String lclPref;
    @XmlElement(name = "PrcsRules")
    protected TPrcsRules prcsRules;
    @XmlElement(name = "Sec", required = true)
    protected TRqstHdr.Sec sec;
    @XmlElement(name = "ServPrmtrsLst", required = true)
    protected TRqstHdr.ServPrmtrsLst servPrmtrsLst;

    /**
     * Gets the value of the rqstHdrVer property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRqstHdrVer() {
        return rqstHdrVer;
    }

    /**
     * Sets the value of the rqstHdrVer property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRqstHdrVer(String value) {
        this.rqstHdrVer = value;
    }

    /**
     * Gets the value of the msgUuid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMsgUuid() {
        return msgUuid;
    }

    /**
     * Sets the value of the msgUuid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMsgUuid(String value) {
        this.msgUuid = value;
    }

    /**
     * Gets the value of the srcId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSrcId() {
        return srcId;
    }

    /**
     * Sets the value of the srcId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSrcId(String value) {
        this.srcId = value;
    }

    /**
     * Gets the value of the actyId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActyId() {
        return actyId;
    }

    /**
     * Sets the value of the actyId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActyId(String value) {
        this.actyId = value;
    }

    /**
     * Gets the value of the tstInd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTstInd() {
        return tstInd;
    }

    /**
     * Sets the value of the tstInd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTstInd(String value) {
        this.tstInd = value;
    }

    /**
     * Gets the value of the lclPref property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLclPref() {
        return lclPref;
    }

    /**
     * Sets the value of the lclPref property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLclPref(String value) {
        this.lclPref = value;
    }

    /**
     * Gets the value of the prcsRules property.
     * 
     * @return
     *     possible object is
     *     {@link TPrcsRules }
     *     
     */
    public TPrcsRules getPrcsRules() {
        return prcsRules;
    }

    /**
     * Sets the value of the prcsRules property.
     * 
     * @param value
     *     allowed object is
     *     {@link TPrcsRules }
     *     
     */
    public void setPrcsRules(TPrcsRules value) {
        this.prcsRules = value;
    }

    /**
     * Gets the value of the sec property.
     * 
     * @return
     *     possible object is
     *     {@link TRqstHdr.Sec }
     *     
     */
    public TRqstHdr.Sec getSec() {
        return sec;
    }

    /**
     * Sets the value of the sec property.
     * 
     * @param value
     *     allowed object is
     *     {@link TRqstHdr.Sec }
     *     
     */
    public void setSec(TRqstHdr.Sec value) {
        this.sec = value;
    }

    /**
     * Gets the value of the servPrmtrsLst property.
     * 
     * @return
     *     possible object is
     *     {@link TRqstHdr.ServPrmtrsLst }
     *     
     */
    public TRqstHdr.ServPrmtrsLst getServPrmtrsLst() {
        return servPrmtrsLst;
    }

    /**
     * Sets the value of the servPrmtrsLst property.
     * 
     * @param value
     *     allowed object is
     *     {@link TRqstHdr.ServPrmtrsLst }
     *     
     */
    public void setServPrmtrsLst(TRqstHdr.ServPrmtrsLst value) {
        this.servPrmtrsLst = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;choice&gt;
     *         &lt;element name="Trusted"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *               &lt;enumeration value="Y"&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="BasicAuthen"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="UsrId" type="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                   &lt;element name="Pswrd" type="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="SessAuthen"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;choice&gt;
     *                   &lt;element name="SessId" type="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                   &lt;element name="HttpSessId" type="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                 &lt;/choice&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="TokenAuthen"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;any processContents='lax' maxOccurs="unbounded" minOccurs="0"&gt;
     *                 &lt;/sequence&gt;
     *                 &lt;anyAttribute processContents='lax'/&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="WsSec"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *               &lt;enumeration value="Y"&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *       &lt;/choice&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "trusted",
        "basicAuthen",
        "sessAuthen",
        "tokenAuthen",
        "wsSec"
    })
    public static class Sec {

        @XmlElement(name = "Trusted", namespace = "FisCommonRqstHdr")
        protected String trusted;
        @XmlElement(name = "BasicAuthen", namespace = "FisCommonRqstHdr")
        protected TRqstHdr.Sec.BasicAuthen basicAuthen;
        @XmlElement(name = "SessAuthen", namespace = "FisCommonRqstHdr")
        protected TRqstHdr.Sec.SessAuthen sessAuthen;
        @XmlElement(name = "TokenAuthen", namespace = "FisCommonRqstHdr")
        protected TRqstHdr.Sec.TokenAuthen tokenAuthen;
        @XmlElement(name = "WsSec", namespace = "FisCommonRqstHdr")
        protected String wsSec;

        /**
         * Gets the value of the trusted property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTrusted() {
            return trusted;
        }

        /**
         * Sets the value of the trusted property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTrusted(String value) {
            this.trusted = value;
        }

        /**
         * Gets the value of the basicAuthen property.
         * 
         * @return
         *     possible object is
         *     {@link TRqstHdr.Sec.BasicAuthen }
         *     
         */
        public TRqstHdr.Sec.BasicAuthen getBasicAuthen() {
            return basicAuthen;
        }

        /**
         * Sets the value of the basicAuthen property.
         * 
         * @param value
         *     allowed object is
         *     {@link TRqstHdr.Sec.BasicAuthen }
         *     
         */
        public void setBasicAuthen(TRqstHdr.Sec.BasicAuthen value) {
            this.basicAuthen = value;
        }

        /**
         * Gets the value of the sessAuthen property.
         * 
         * @return
         *     possible object is
         *     {@link TRqstHdr.Sec.SessAuthen }
         *     
         */
        public TRqstHdr.Sec.SessAuthen getSessAuthen() {
            return sessAuthen;
        }

        /**
         * Sets the value of the sessAuthen property.
         * 
         * @param value
         *     allowed object is
         *     {@link TRqstHdr.Sec.SessAuthen }
         *     
         */
        public void setSessAuthen(TRqstHdr.Sec.SessAuthen value) {
            this.sessAuthen = value;
        }

        /**
         * Gets the value of the tokenAuthen property.
         * 
         * @return
         *     possible object is
         *     {@link TRqstHdr.Sec.TokenAuthen }
         *     
         */
        public TRqstHdr.Sec.TokenAuthen getTokenAuthen() {
            return tokenAuthen;
        }

        /**
         * Sets the value of the tokenAuthen property.
         * 
         * @param value
         *     allowed object is
         *     {@link TRqstHdr.Sec.TokenAuthen }
         *     
         */
        public void setTokenAuthen(TRqstHdr.Sec.TokenAuthen value) {
            this.tokenAuthen = value;
        }

        /**
         * Gets the value of the wsSec property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getWsSec() {
            return wsSec;
        }

        /**
         * Sets the value of the wsSec property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setWsSec(String value) {
            this.wsSec = value;
        }


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
         *         &lt;element name="UsrId" type="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *         &lt;element name="Pswrd" type="{http://www.w3.org/2001/XMLSchema}string"&gt;
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
            "usrId",
            "pswrd"
        })
        public static class BasicAuthen {

            @XmlElement(name = "UsrId", namespace = "FisCommonRqstHdr", required = true)
            protected String usrId;
            @XmlElement(name = "Pswrd", namespace = "FisCommonRqstHdr", required = true)
            protected String pswrd;

            /**
             * Gets the value of the usrId property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getUsrId() {
                return usrId;
            }

            /**
             * Sets the value of the usrId property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setUsrId(String value) {
                this.usrId = value;
            }

            /**
             * Gets the value of the pswrd property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPswrd() {
                return pswrd;
            }

            /**
             * Sets the value of the pswrd property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPswrd(String value) {
                this.pswrd = value;
            }

        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType&gt;
         *   &lt;complexContent&gt;
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *       &lt;choice&gt;
         *         &lt;element name="SessId" type="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *         &lt;element name="HttpSessId" type="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *       &lt;/choice&gt;
         *     &lt;/restriction&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "sessId",
            "httpSessId"
        })
        public static class SessAuthen {

            @XmlElement(name = "SessId", namespace = "FisCommonRqstHdr")
            protected String sessId;
            @XmlElement(name = "HttpSessId", namespace = "FisCommonRqstHdr")
            protected String httpSessId;

            /**
             * Gets the value of the sessId property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getSessId() {
                return sessId;
            }

            /**
             * Sets the value of the sessId property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setSessId(String value) {
                this.sessId = value;
            }

            /**
             * Gets the value of the httpSessId property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getHttpSessId() {
                return httpSessId;
            }

            /**
             * Sets the value of the httpSessId property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setHttpSessId(String value) {
                this.httpSessId = value;
            }

        }


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
         *         &lt;any processContents='lax' maxOccurs="unbounded" minOccurs="0"&gt;
         *       &lt;/sequence&gt;
         *       &lt;anyAttribute processContents='lax'/&gt;
         *     &lt;/restriction&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "any"
        })
        public static class TokenAuthen {

            @XmlAnyElement(lax = true)
            protected List<Object> any;
            @XmlAnyAttribute
            private Map<QName, String> otherAttributes = new HashMap<QName, String>();

            /**
             * Gets the value of the any property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the any property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getAny().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link Element }
             * {@link Object }
             * 
             * 
             */
            public List<Object> getAny() {
                if (any == null) {
                    any = new ArrayList<Object>();
                }
                return this.any;
            }

            /**
             * Gets a map that contains attributes that aren't bound to any typed property on this class.
             * 
             * <p>
             * the map is keyed by the name of the attribute and 
             * the value is the string value of the attribute.
             * 
             * the map returned by this method is live, and you can add new attribute
             * by updating the map directly. Because of this design, there's no setter.
             * 
             * 
             * @return
             *     always non-null
             */
            public Map<QName, String> getOtherAttributes() {
                return otherAttributes;
            }

        }

    }


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
     *         &lt;element name="ServPrmtrs" maxOccurs="unbounded"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="FeId" type="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                   &lt;element name="ServId" type="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                   &lt;element name="ServVer" type="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                   &lt;element name="ApplId" type="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                   &lt;element name="DataLnkId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"&gt;
     *                   &lt;element name="FldLst" minOccurs="0"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;complexContent&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                           &lt;sequence&gt;
     *                             &lt;element name="Fld" maxOccurs="unbounded"&gt;
     *                               &lt;complexType&gt;
     *                                 &lt;complexContent&gt;
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                                     &lt;sequence&gt;
     *                                       &lt;element name="FldNme" type="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                       &lt;element name="FldVal" type="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                     &lt;/sequence&gt;
     *                                   &lt;/restriction&gt;
     *                                 &lt;/complexContent&gt;
     *                               &lt;/complexType&gt;
     *                             &lt;/element&gt;
     *                           &lt;/sequence&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/complexContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
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
        "servPrmtrs"
    })
    public static class ServPrmtrsLst {

        @XmlElement(name = "ServPrmtrs", namespace = "FisCommonRqstHdr", required = true)
        protected List<TRqstHdr.ServPrmtrsLst.ServPrmtrs> servPrmtrs;

        /**
         * Gets the value of the servPrmtrs property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the servPrmtrs property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getServPrmtrs().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link TRqstHdr.ServPrmtrsLst.ServPrmtrs }
         * 
         * 
         */
        public List<TRqstHdr.ServPrmtrsLst.ServPrmtrs> getServPrmtrs() {
            if (servPrmtrs == null) {
                servPrmtrs = new ArrayList<TRqstHdr.ServPrmtrsLst.ServPrmtrs>();
            }
            return this.servPrmtrs;
        }


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
         *         &lt;element name="FeId" type="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *         &lt;element name="ServId" type="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *         &lt;element name="ServVer" type="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *         &lt;element name="ApplId" type="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *         &lt;element name="DataLnkId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"&gt;
         *         &lt;element name="FldLst" minOccurs="0"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="Fld" maxOccurs="unbounded"&gt;
         *                     &lt;complexType&gt;
         *                       &lt;complexContent&gt;
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                           &lt;sequence&gt;
         *                             &lt;element name="FldNme" type="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                             &lt;element name="FldVal" type="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                           &lt;/sequence&gt;
         *                         &lt;/restriction&gt;
         *                       &lt;/complexContent&gt;
         *                     &lt;/complexType&gt;
         *                   &lt;/element&gt;
         *                 &lt;/sequence&gt;
         *               &lt;/restriction&gt;
         *             &lt;/complexContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
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
            "feId",
            "servId",
            "servVer",
            "applId",
            "dataLnkId",
            "fldLst"
        })
        public static class ServPrmtrs {

            @XmlElement(name = "FeId", namespace = "FisCommonRqstHdr", required = true)
            protected String feId;
            @XmlElement(name = "ServId", namespace = "FisCommonRqstHdr", required = true)
            protected String servId;
            @XmlElement(name = "ServVer", namespace = "FisCommonRqstHdr", required = true)
            protected String servVer;
            @XmlElement(name = "ApplId", namespace = "FisCommonRqstHdr", required = true)
            protected String applId;
            @XmlElement(name = "DataLnkId", namespace = "FisCommonRqstHdr")
            protected String dataLnkId;
            @XmlElement(name = "FldLst", namespace = "FisCommonRqstHdr")
            protected TRqstHdr.ServPrmtrsLst.ServPrmtrs.FldLst fldLst;

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
             * Gets the value of the servId property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getServId() {
                return servId;
            }

            /**
             * Sets the value of the servId property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setServId(String value) {
                this.servId = value;
            }

            /**
             * Gets the value of the servVer property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getServVer() {
                return servVer;
            }

            /**
             * Sets the value of the servVer property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setServVer(String value) {
                this.servVer = value;
            }

            /**
             * Gets the value of the applId property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getApplId() {
                return applId;
            }

            /**
             * Sets the value of the applId property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setApplId(String value) {
                this.applId = value;
            }

            /**
             * Gets the value of the dataLnkId property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDataLnkId() {
                return dataLnkId;
            }

            /**
             * Sets the value of the dataLnkId property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDataLnkId(String value) {
                this.dataLnkId = value;
            }

            /**
             * Gets the value of the fldLst property.
             * 
             * @return
             *     possible object is
             *     {@link TRqstHdr.ServPrmtrsLst.ServPrmtrs.FldLst }
             *     
             */
            public TRqstHdr.ServPrmtrsLst.ServPrmtrs.FldLst getFldLst() {
                return fldLst;
            }

            /**
             * Sets the value of the fldLst property.
             * 
             * @param value
             *     allowed object is
             *     {@link TRqstHdr.ServPrmtrsLst.ServPrmtrs.FldLst }
             *     
             */
            public void setFldLst(TRqstHdr.ServPrmtrsLst.ServPrmtrs.FldLst value) {
                this.fldLst = value;
            }


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
             *         &lt;element name="Fld" maxOccurs="unbounded"&gt;
             *           &lt;complexType&gt;
             *             &lt;complexContent&gt;
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *                 &lt;sequence&gt;
             *                   &lt;element name="FldNme" type="{http://www.w3.org/2001/XMLSchema}string"&gt;
             *                   &lt;element name="FldVal" type="{http://www.w3.org/2001/XMLSchema}string"&gt;
             *                 &lt;/sequence&gt;
             *               &lt;/restriction&gt;
             *             &lt;/complexContent&gt;
             *           &lt;/complexType&gt;
             *         &lt;/element&gt;
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
                "fld"
            })
            public static class FldLst {

                @XmlElement(name = "Fld", namespace = "FisCommonRqstHdr", required = true)
                protected List<TRqstHdr.ServPrmtrsLst.ServPrmtrs.FldLst.Fld> fld;

                /**
                 * Gets the value of the fld property.
                 * 
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the JAXB object.
                 * This is why there is not a <CODE>set</CODE> method for the fld property.
                 * 
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getFld().add(newItem);
                 * </pre>
                 * 
                 * 
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link TRqstHdr.ServPrmtrsLst.ServPrmtrs.FldLst.Fld }
                 * 
                 * 
                 */
                public List<TRqstHdr.ServPrmtrsLst.ServPrmtrs.FldLst.Fld> getFld() {
                    if (fld == null) {
                        fld = new ArrayList<TRqstHdr.ServPrmtrsLst.ServPrmtrs.FldLst.Fld>();
                    }
                    return this.fld;
                }


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
                 *         &lt;element name="FldNme" type="{http://www.w3.org/2001/XMLSchema}string"&gt;
                 *         &lt;element name="FldVal" type="{http://www.w3.org/2001/XMLSchema}string"&gt;
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
                    "fldNme",
                    "fldVal"
                })
                public static class Fld {

                    @XmlElement(name = "FldNme", namespace = "FisCommonRqstHdr", required = true)
                    protected String fldNme;
                    @XmlElement(name = "FldVal", namespace = "FisCommonRqstHdr", required = true)
                    protected String fldVal;

                    /**
                     * Gets the value of the fldNme property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getFldNme() {
                        return fldNme;
                    }

                    /**
                     * Sets the value of the fldNme property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setFldNme(String value) {
                        this.fldNme = value;
                    }

                    /**
                     * Gets the value of the fldVal property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getFldVal() {
                        return fldVal;
                    }

                    /**
                     * Sets the value of the fldVal property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setFldVal(String value) {
                        this.fldVal = value;
                    }

                }

            }

        }

    }

}
