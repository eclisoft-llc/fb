
package com.fbol.ucic.service.wsdl;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.fbol.ucic.service.wsdl package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _XPRtrvIpAnlytcsMktDtlOso_QNAME = new QName("XPRetrieveIpAnlytcsMktDtlRsp", "XPRtrvIpAnlytcsMktDtlOso");
    private final static QName _XPRtrvIpAnlytcsMktDtlRsp_QNAME = new QName("XPRetrieveIpAnlytcsMktDtlRsp", "XPRtrvIpAnlytcsMktDtlRsp");
    private final static QName _RspHdr_QNAME = new QName("FisCommonRspHdr", "RspHdr");
    private final static QName _XPRtrvIpAnlytcsMktDtlOsi_QNAME = new QName("XPRetrieveIpAnlytcsMktDtlRqst", "XPRtrvIpAnlytcsMktDtlOsi");
    private final static QName _XPRtrvIpAnlytcsMktDtlRqst_QNAME = new QName("XPRetrieveIpAnlytcsMktDtlRqst", "XPRtrvIpAnlytcsMktDtlRqst");
    private final static QName _RqstHdr_QNAME = new QName("FisCommonRqstHdr", "RqstHdr");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.fbol.ucic.service.wsdl
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TRqstHdr }
     * 
     */
    public TRqstHdr createTRqstHdr() {
        return new TRqstHdr();
    }

    /**
     * Create an instance of {@link TRqstHdr.ServPrmtrsLst }
     * 
     */
    public TRqstHdr.ServPrmtrsLst createTRqstHdrServPrmtrsLst() {
        return new TRqstHdr.ServPrmtrsLst();
    }

    /**
     * Create an instance of {@link TRqstHdr.ServPrmtrsLst.ServPrmtrs }
     * 
     */
    public TRqstHdr.ServPrmtrsLst.ServPrmtrs createTRqstHdrServPrmtrsLstServPrmtrs() {
        return new TRqstHdr.ServPrmtrsLst.ServPrmtrs();
    }

    /**
     * Create an instance of {@link TRqstHdr.ServPrmtrsLst.ServPrmtrs.FldLst }
     * 
     */
    public TRqstHdr.ServPrmtrsLst.ServPrmtrs.FldLst createTRqstHdrServPrmtrsLstServPrmtrsFldLst() {
        return new TRqstHdr.ServPrmtrsLst.ServPrmtrs.FldLst();
    }

    /**
     * Create an instance of {@link TRqstHdr.Sec }
     * 
     */
    public TRqstHdr.Sec createTRqstHdrSec() {
        return new TRqstHdr.Sec();
    }

    /**
     * Create an instance of {@link TMsgLst }
     * 
     */
    public TMsgLst createTMsgLst() {
        return new TMsgLst();
    }

    /**
     * Create an instance of {@link TMsgLst.Msg }
     * 
     */
    public TMsgLst.Msg createTMsgLstMsg() {
        return new TMsgLst.Msg();
    }

    /**
     * Create an instance of {@link TMsgLst.Msg.PrmtrLst }
     * 
     */
    public TMsgLst.Msg.PrmtrLst createTMsgLstMsgPrmtrLst() {
        return new TMsgLst.Msg.PrmtrLst();
    }

    /**
     * Create an instance of {@link TRspHdr }
     * 
     */
    public TRspHdr createTRspHdr() {
        return new TRspHdr();
    }

    /**
     * Create an instance of {@link TRspHdr.ServPrmtrsLst }
     * 
     */
    public TRspHdr.ServPrmtrsLst createTRspHdrServPrmtrsLst() {
        return new TRspHdr.ServPrmtrsLst();
    }

    /**
     * Create an instance of {@link TRspHdr.ServPrmtrsLst.ServPrmtrs }
     * 
     */
    public TRspHdr.ServPrmtrsLst.ServPrmtrs createTRspHdrServPrmtrsLstServPrmtrs() {
        return new TRspHdr.ServPrmtrsLst.ServPrmtrs();
    }

    /**
     * Create an instance of {@link TRspHdr.ServPrmtrsLst.ServPrmtrs.FldLst }
     * 
     */
    public TRspHdr.ServPrmtrsLst.ServPrmtrs.FldLst createTRspHdrServPrmtrsLstServPrmtrsFldLst() {
        return new TRspHdr.ServPrmtrsLst.ServPrmtrs.FldLst();
    }

    /**
     * Create an instance of {@link XPRetrieveIpAnlytcsMktDtlOso }
     * 
     */
    public XPRetrieveIpAnlytcsMktDtlOso createXPRetrieveIpAnlytcsMktDtlOso() {
        return new XPRetrieveIpAnlytcsMktDtlOso();
    }

    /**
     * Create an instance of {@link XPRetrieveIpAnlytcsMktDtlRsp }
     * 
     */
    public XPRetrieveIpAnlytcsMktDtlRsp createXPRetrieveIpAnlytcsMktDtlRsp() {
        return new XPRetrieveIpAnlytcsMktDtlRsp();
    }

    /**
     * Create an instance of {@link IpAnalyticsMarketingDetail }
     * 
     */
    public IpAnalyticsMarketingDetail createIpAnalyticsMarketingDetail() {
        return new IpAnalyticsMarketingDetail();
    }

    /**
     * Create an instance of {@link AnalyticsMarketingDetail }
     * 
     */
    public AnalyticsMarketingDetail createAnalyticsMarketingDetail() {
        return new AnalyticsMarketingDetail();
    }

    /**
     * Create an instance of {@link AnalyticsMarketingOffer }
     * 
     */
    public AnalyticsMarketingOffer createAnalyticsMarketingOffer() {
        return new AnalyticsMarketingOffer();
    }

    /**
     * Create an instance of {@link TextMedia }
     * 
     */
    public TextMedia createTextMedia() {
        return new TextMedia();
    }

    /**
     * Create an instance of {@link ImageMedia }
     * 
     */
    public ImageMedia createImageMedia() {
        return new ImageMedia();
    }

    /**
     * Create an instance of {@link IpIdentifier }
     * 
     */
    public IpIdentifier createIpIdentifier() {
        return new IpIdentifier();
    }

    /**
     * Create an instance of {@link IpKey }
     * 
     */
    public IpKey createIpKey() {
        return new IpKey();
    }

    /**
     * Create an instance of {@link Sor }
     * 
     */
    public Sor createSor() {
        return new Sor();
    }

    /**
     * Create an instance of {@link SorFe }
     * 
     */
    public SorFe createSorFe() {
        return new SorFe();
    }

    /**
     * Create an instance of {@link FeRequest }
     * 
     */
    public FeRequest createFeRequest() {
        return new FeRequest();
    }

    /**
     * Create an instance of {@link FeRequestKey }
     * 
     */
    public FeRequestKey createFeRequestKey() {
        return new FeRequestKey();
    }

    /**
     * Create an instance of {@link RequestAccessType }
     * 
     */
    public RequestAccessType createRequestAccessType() {
        return new RequestAccessType();
    }

    /**
     * Create an instance of {@link ListControl }
     * 
     */
    public ListControl createListControl() {
        return new ListControl();
    }

    /**
     * Create an instance of {@link ListControlOutput }
     * 
     */
    public ListControlOutput createListControlOutput() {
        return new ListControlOutput();
    }

    /**
     * Create an instance of {@link FeResponseKey }
     * 
     */
    public FeResponseKey createFeResponseKey() {
        return new FeResponseKey();
    }

    /**
     * Create an instance of {@link XPRetrieveIpAnlytcsMktDtlOsi }
     * 
     */
    public XPRetrieveIpAnlytcsMktDtlOsi createXPRetrieveIpAnlytcsMktDtlOsi() {
        return new XPRetrieveIpAnlytcsMktDtlOsi();
    }

    /**
     * Create an instance of {@link XPRetrieveIpAnlytcsMktDtlRqst }
     * 
     */
    public XPRetrieveIpAnlytcsMktDtlRqst createXPRetrieveIpAnlytcsMktDtlRqst() {
        return new XPRetrieveIpAnlytcsMktDtlRqst();
    }

    /**
     * Create an instance of {@link IpArKey }
     * 
     */
    public IpArKey createIpArKey() {
        return new IpArKey();
    }

    /**
     * Create an instance of {@link TPrcsRules }
     * 
     */
    public TPrcsRules createTPrcsRules() {
        return new TPrcsRules();
    }

    /**
     * Create an instance of {@link ArIdentifier }
     * 
     */
    public ArIdentifier createArIdentifier() {
        return new ArIdentifier();
    }

    /**
     * Create an instance of {@link ArKey }
     * 
     */
    public ArKey createArKey() {
        return new ArKey();
    }

    /**
     * Create an instance of {@link TRqstHdr.ServPrmtrsLst.ServPrmtrs.FldLst.Fld }
     * 
     */
    public TRqstHdr.ServPrmtrsLst.ServPrmtrs.FldLst.Fld createTRqstHdrServPrmtrsLstServPrmtrsFldLstFld() {
        return new TRqstHdr.ServPrmtrsLst.ServPrmtrs.FldLst.Fld();
    }

    /**
     * Create an instance of {@link TRqstHdr.Sec.BasicAuthen }
     * 
     */
    public TRqstHdr.Sec.BasicAuthen createTRqstHdrSecBasicAuthen() {
        return new TRqstHdr.Sec.BasicAuthen();
    }

    /**
     * Create an instance of {@link TRqstHdr.Sec.SessAuthen }
     * 
     */
    public TRqstHdr.Sec.SessAuthen createTRqstHdrSecSessAuthen() {
        return new TRqstHdr.Sec.SessAuthen();
    }

    /**
     * Create an instance of {@link TRqstHdr.Sec.TokenAuthen }
     * 
     */
    public TRqstHdr.Sec.TokenAuthen createTRqstHdrSecTokenAuthen() {
        return new TRqstHdr.Sec.TokenAuthen();
    }

    /**
     * Create an instance of {@link TMsgLst.Msg.PrmtrLst.Prmtr }
     * 
     */
    public TMsgLst.Msg.PrmtrLst.Prmtr createTMsgLstMsgPrmtrLstPrmtr() {
        return new TMsgLst.Msg.PrmtrLst.Prmtr();
    }

    /**
     * Create an instance of {@link TRspHdr.ServPrmtrsLst.ServPrmtrs.FldLst.Fld }
     * 
     */
    public TRspHdr.ServPrmtrsLst.ServPrmtrs.FldLst.Fld createTRspHdrServPrmtrsLstServPrmtrsFldLstFld() {
        return new TRspHdr.ServPrmtrsLst.ServPrmtrs.FldLst.Fld();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XPRetrieveIpAnlytcsMktDtlOso }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link XPRetrieveIpAnlytcsMktDtlOso }{@code >}
     */
    @XmlElementDecl(namespace = "XPRetrieveIpAnlytcsMktDtlRsp", name = "XPRtrvIpAnlytcsMktDtlOso")
    public JAXBElement<XPRetrieveIpAnlytcsMktDtlOso> createXPRtrvIpAnlytcsMktDtlOso(XPRetrieveIpAnlytcsMktDtlOso value) {
        return new JAXBElement<XPRetrieveIpAnlytcsMktDtlOso>(_XPRtrvIpAnlytcsMktDtlOso_QNAME, XPRetrieveIpAnlytcsMktDtlOso.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XPRetrieveIpAnlytcsMktDtlRsp }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link XPRetrieveIpAnlytcsMktDtlRsp }{@code >}
     */
    @XmlElementDecl(namespace = "XPRetrieveIpAnlytcsMktDtlRsp", name = "XPRtrvIpAnlytcsMktDtlRsp")
    public JAXBElement<XPRetrieveIpAnlytcsMktDtlRsp> createXPRtrvIpAnlytcsMktDtlRsp(XPRetrieveIpAnlytcsMktDtlRsp value) {
        return new JAXBElement<XPRetrieveIpAnlytcsMktDtlRsp>(_XPRtrvIpAnlytcsMktDtlRsp_QNAME, XPRetrieveIpAnlytcsMktDtlRsp.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TRspHdr }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TRspHdr }{@code >}
     */
    @XmlElementDecl(namespace = "FisCommonRspHdr", name = "RspHdr")
    public JAXBElement<TRspHdr> createRspHdr(TRspHdr value) {
        return new JAXBElement<TRspHdr>(_RspHdr_QNAME, TRspHdr.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XPRetrieveIpAnlytcsMktDtlOsi }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link XPRetrieveIpAnlytcsMktDtlOsi }{@code >}
     */
    @XmlElementDecl(namespace = "XPRetrieveIpAnlytcsMktDtlRqst", name = "XPRtrvIpAnlytcsMktDtlOsi")
    public JAXBElement<XPRetrieveIpAnlytcsMktDtlOsi> createXPRtrvIpAnlytcsMktDtlOsi(XPRetrieveIpAnlytcsMktDtlOsi value) {
        return new JAXBElement<XPRetrieveIpAnlytcsMktDtlOsi>(_XPRtrvIpAnlytcsMktDtlOsi_QNAME, XPRetrieveIpAnlytcsMktDtlOsi.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XPRetrieveIpAnlytcsMktDtlRqst }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link XPRetrieveIpAnlytcsMktDtlRqst }{@code >}
     */
    @XmlElementDecl(namespace = "XPRetrieveIpAnlytcsMktDtlRqst", name = "XPRtrvIpAnlytcsMktDtlRqst")
    public JAXBElement<XPRetrieveIpAnlytcsMktDtlRqst> createXPRtrvIpAnlytcsMktDtlRqst(XPRetrieveIpAnlytcsMktDtlRqst value) {
        return new JAXBElement<XPRetrieveIpAnlytcsMktDtlRqst>(_XPRtrvIpAnlytcsMktDtlRqst_QNAME, XPRetrieveIpAnlytcsMktDtlRqst.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TRqstHdr }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TRqstHdr }{@code >}
     */
    @XmlElementDecl(namespace = "FisCommonRqstHdr", name = "RqstHdr")
    public JAXBElement<TRqstHdr> createRqstHdr(TRqstHdr value) {
        return new JAXBElement<TRqstHdr>(_RqstHdr_QNAME, TRqstHdr.class, null, value);
    }

}
