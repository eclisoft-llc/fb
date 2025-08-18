
package com.fbol.ucic.service.wsdl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tRspHdr complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tRspHdr"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="RspHdrVer"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;enumeration value="2.0.0"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="RtnCde" type="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *         &lt;element name="MsgUuid" type="{FisCommonRspHdr}tUuid"&gt;
 *         &lt;element name="ActyId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"&gt;
 *         &lt;element name="Lcl" type="{FisCommonRspHdr}tLocale"&gt;
 *         &lt;element name="ServPrmtrsLst" minOccurs="0"&gt;
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
 *         &lt;element name="MsgLst" type="{FisCommonRspHdr}tMsgLst" minOccurs="0"&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tRspHdr", namespace = "FisCommonRspHdr", propOrder = {
    "rspHdrVer",
    "rtnCde",
    "msgUuid",
    "actyId",
    "lcl",
    "servPrmtrsLst",
    "msgLst"
})
public class TRspHdr {

    @XmlElement(name = "RspHdrVer", required = true)
    protected String rspHdrVer;
    @XmlElement(name = "RtnCde", required = true)
    protected String rtnCde;
    @XmlElement(name = "MsgUuid", required = true)
    protected String msgUuid;
    @XmlElement(name = "ActyId")
    protected String actyId;
    @XmlElement(name = "Lcl", required = true)
    protected String lcl;
    @XmlElement(name = "ServPrmtrsLst")
    protected TRspHdr.ServPrmtrsLst servPrmtrsLst;
    @XmlElement(name = "MsgLst")
    protected TMsgLst msgLst;

    /**
     * Gets the value of the rspHdrVer property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRspHdrVer() {
        return rspHdrVer;
    }

    /**
     * Sets the value of the rspHdrVer property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRspHdrVer(String value) {
        this.rspHdrVer = value;
    }

    /**
     * Gets the value of the rtnCde property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRtnCde() {
        return rtnCde;
    }

    /**
     * Sets the value of the rtnCde property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRtnCde(String value) {
        this.rtnCde = value;
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
     * Gets the value of the lcl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLcl() {
        return lcl;
    }

    /**
     * Sets the value of the lcl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLcl(String value) {
        this.lcl = value;
    }

    /**
     * Gets the value of the servPrmtrsLst property.
     * 
     * @return
     *     possible object is
     *     {@link TRspHdr.ServPrmtrsLst }
     *     
     */
    public TRspHdr.ServPrmtrsLst getServPrmtrsLst() {
        return servPrmtrsLst;
    }

    /**
     * Sets the value of the servPrmtrsLst property.
     * 
     * @param value
     *     allowed object is
     *     {@link TRspHdr.ServPrmtrsLst }
     *     
     */
    public void setServPrmtrsLst(TRspHdr.ServPrmtrsLst value) {
        this.servPrmtrsLst = value;
    }

    /**
     * Gets the value of the msgLst property.
     * 
     * @return
     *     possible object is
     *     {@link TMsgLst }
     *     
     */
    public TMsgLst getMsgLst() {
        return msgLst;
    }

    /**
     * Sets the value of the msgLst property.
     * 
     * @param value
     *     allowed object is
     *     {@link TMsgLst }
     *     
     */
    public void setMsgLst(TMsgLst value) {
        this.msgLst = value;
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

        @XmlElement(name = "ServPrmtrs", namespace = "FisCommonRspHdr", required = true)
        protected List<TRspHdr.ServPrmtrsLst.ServPrmtrs> servPrmtrs;

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
         * {@link TRspHdr.ServPrmtrsLst.ServPrmtrs }
         * 
         * 
         */
        public List<TRspHdr.ServPrmtrsLst.ServPrmtrs> getServPrmtrs() {
            if (servPrmtrs == null) {
                servPrmtrs = new ArrayList<TRspHdr.ServPrmtrsLst.ServPrmtrs>();
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

            @XmlElement(name = "FeId", namespace = "FisCommonRspHdr", required = true)
            protected String feId;
            @XmlElement(name = "ServId", namespace = "FisCommonRspHdr", required = true)
            protected String servId;
            @XmlElement(name = "ServVer", namespace = "FisCommonRspHdr", required = true)
            protected String servVer;
            @XmlElement(name = "ApplId", namespace = "FisCommonRspHdr", required = true)
            protected String applId;
            @XmlElement(name = "DataLnkId", namespace = "FisCommonRspHdr")
            protected String dataLnkId;
            @XmlElement(name = "FldLst", namespace = "FisCommonRspHdr")
            protected TRspHdr.ServPrmtrsLst.ServPrmtrs.FldLst fldLst;

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
             *     {@link TRspHdr.ServPrmtrsLst.ServPrmtrs.FldLst }
             *     
             */
            public TRspHdr.ServPrmtrsLst.ServPrmtrs.FldLst getFldLst() {
                return fldLst;
            }

            /**
             * Sets the value of the fldLst property.
             * 
             * @param value
             *     allowed object is
             *     {@link TRspHdr.ServPrmtrsLst.ServPrmtrs.FldLst }
             *     
             */
            public void setFldLst(TRspHdr.ServPrmtrsLst.ServPrmtrs.FldLst value) {
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

                @XmlElement(name = "Fld", namespace = "FisCommonRspHdr", required = true)
                protected List<TRspHdr.ServPrmtrsLst.ServPrmtrs.FldLst.Fld> fld;

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
                 * {@link TRspHdr.ServPrmtrsLst.ServPrmtrs.FldLst.Fld }
                 * 
                 * 
                 */
                public List<TRspHdr.ServPrmtrsLst.ServPrmtrs.FldLst.Fld> getFld() {
                    if (fld == null) {
                        fld = new ArrayList<TRspHdr.ServPrmtrsLst.ServPrmtrs.FldLst.Fld>();
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

                    @XmlElement(name = "FldNme", namespace = "FisCommonRspHdr", required = true)
                    protected String fldNme;
                    @XmlElement(name = "FldVal", namespace = "FisCommonRspHdr", required = true)
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
