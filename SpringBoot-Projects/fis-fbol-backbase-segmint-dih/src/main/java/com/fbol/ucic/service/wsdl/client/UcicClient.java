package com.fbol.ucic.service.wsdl.client;

import com.fbol.ucic.service.model.Ucic;
import com.fbol.ucic.service.model.UsernameToken;
import com.fbol.ucic.service.wsdl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import java.math.BigInteger;
import javax.xml.bind.JAXBElement;
import java.util.UUID;


public class UcicClient extends WebServiceGatewaySupport {

    private static final Resource KEYSTORE_LOCATION = new ClassPathResource("client-app.jks");

    @Autowired
    private Environment env;
    private String msgid;

    @Value("${uname}")
    private String username;
    @Value("${bankid}")
    private String bankid;
    @Value("${servicetobecalled}")
    private String servicetobecalled;
    @Value("${serverversion}")
    private String serverversion;
    @Value("${appid}")
    private String appid;
    @Value("${listentryval}")
    private String listentryval;
    @Value("${nbrofenty}")
    private BigInteger nbrofenty;
    @Value("${rqstsetsize}")
    private BigInteger rqstsetsize;
    @Value("${lclpref}")
    private String lclpref;
    @Value("${srcid}")
    private String srcid;
    @Value("${rqsthdrver}")
    private String rqsthdrver;
    @Value("${endpoint}")
    private String endpoint;

    public Ucic getUcic(String cis) throws Exception {


            XPRetrieveIpAnlytcsMktDtlRqst request = new XPRetrieveIpAnlytcsMktDtlRqst();
            //XPRtrvIpAnlytcsMktDtlRqst r = new XPRtrvIpAnlytcsMktDtlRqst();
            String guid = UUID.randomUUID().toString();

            //start of <fis:RqstHdr>
            //LOGGER.info(msgid + "setting request headers....");
            TRqstHdr reqh = new TRqstHdr();
            TRqstHdr.Sec sec = new TRqstHdr.Sec();
            TRqstHdr.Sec.TokenAuthen tk = new TRqstHdr.Sec.TokenAuthen();
            UsernameToken us = new UsernameToken();
            us.setUsername(username);
            tk.getAny().add(us);
            sec.setTokenAuthen(tk);
            TRqstHdr.ServPrmtrsLst.ServPrmtrs sp = new TRqstHdr.ServPrmtrsLst.ServPrmtrs();
            sp.setFeId(bankid);
            sp.setServId(servicetobecalled);
            sp.setServVer(serverversion);
            sp.setApplId(appid);
            TRqstHdr.ServPrmtrsLst ls = new TRqstHdr.ServPrmtrsLst();
            ls.getServPrmtrs().add(sp);
            reqh.setServPrmtrsLst(ls);
            reqh.setSec(sec);
            reqh.setRqstHdrVer(rqsthdrver);
            reqh.setMsgUuid(guid);
            reqh.setSrcId(srcid);
            reqh.setLclPref(lclpref);
            //</fis:RqstHdr>

            //creating request body <xpr:XPRtrvIpAnlytcsMktDtlOsi>
            XPRetrieveIpAnlytcsMktDtlOsi req = new XPRetrieveIpAnlytcsMktDtlOsi();

            // <xpr:FeRqstKey>
            FeRequestKey rkey = new FeRequestKey();
            FeRequest r = new FeRequest();
            r.setFeId(bankid);
            rkey.setFeRqst(r);
            //</xpr:FeRqstKey>

            //<xpr:IpArKey>
            IpArKey custid = new IpArKey();
            IpKey ikey = new IpKey();
            ikey.setIpId(cis);

            Sor sor = new Sor();
            sor.setApplNme("");
            sor.setPrcsrNme("");
            ikey.setSor(sor);
            custid.setIpKey(ikey);
            //</xpr:IpArKey>

            //<xpr:LstCntl>
            ListControl lst = new ListControl();
            lst.setLstEntryVal(listentryval);
            lst.setNbrOfEnty(nbrofenty);
            lst.setRqstSetSize(rqstsetsize);
            //</xpr:LstCntl>

            req.setFeRqstKey(rkey);
            req.setIpArKey(custid);
            req.setLstCntl(lst);
            request.setXPRtrvIpAnlytcsMktDtlOsi(req);

            request.setRqstHdr(reqh);
            //</xpr:XPRtrvIpAnlytcsMktDtlOsi>


            JAXBElement<XPRetrieveIpAnlytcsMktDtlRsp> response = (JAXBElement<XPRetrieveIpAnlytcsMktDtlRsp>) getWebServiceTemplate()
                    .marshalSendAndReceive(endpoint,request);

            String ucicstr =  response.getValue().getXPRtrvIpAnlytcsMktDtlOso().getIpAnlytcsMktDtl().get(0).getAnlytcsMktDtl().getUcic();

            Ucic ucic = new Ucic();
            ucic.setUcicstr(ucicstr);

            return ucic;

    }


}