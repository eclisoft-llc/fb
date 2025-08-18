package com.fbol.ucic.service.wsdl.client;

import com.fbol.ucic.service.model.Ucic;
import com.fbol.ucic.service.model.UsernameToken;
import com.fbol.ucic.service.wsdl.*;
//import com.fbol.ucic.service.wsdl.config.SoapConfiguration;
import com.fbol.ucic.service.wsdl.config.SignSOAPRequest;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import java.io.StringReader;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.FileHandler;
import java.util.logging.Level;
//import java.util.logging.Logger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPMessage;
import java.util.ResourceBundle;
import java.util.UUID;


public class UcicClient extends WebServiceGatewaySupport {

    private static final Logger LOGGER = LogManager.getLogger(UcicClient.class.getName());
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
    @Value("${logfile}")
    private String logfile;
    @Value("${endpoint}")
    private String endpoint;

    public Ucic getUcic(String cis) {

        try {
            //FileHandler fh = new FileHandler(logfile);
            //LOGGER.addHandler(fh);
            //LOGGER.setLevel(Level.ALL);
            XPRetrieveIpAnlytcsMktDtlRqst request = new XPRetrieveIpAnlytcsMktDtlRqst();
            String guid = UUID.randomUUID().toString();

            msgid = "MsgUUID: " + guid + "; CIS Number: " + cis + " ";

            //start of <fis:RqstHdr>
            LOGGER.info(msgid + "setting request headers....");
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
            LOGGER.info(msgid + "Request headers are set....");
            //</fis:RqstHdr>

            //creating request body <xpr:XPRtrvIpAnlytcsMktDtlOsi>
            LOGGER.info(msgid + "Creating request body....");
            XPRetrieveIpAnlytcsMktDtlOsi req = new XPRetrieveIpAnlytcsMktDtlOsi();

            // <xpr:FeRqstKey>
            LOGGER.info(msgid + "Creating request key....");
            FeRequestKey rkey = new FeRequestKey();
            FeRequest r = new FeRequest();
            r.setFeId(bankid);
            rkey.setFeRqst(r);
            LOGGER.info(msgid + "Created request key....");
            //</xpr:FeRqstKey>

            //<xpr:IpArKey>
            LOGGER.info(msgid + "Creating IpArkey using CIS number....");
            IpArKey custid = new IpArKey();
            IpKey ikey = new IpKey();
            ikey.setIpId(cis);

            Sor sor = new Sor();
            //sor.setApplNme("");
            //sor.setPrcsrNme("");
            ikey.setSor(sor);
            custid.setIpKey(ikey);
            LOGGER.info(msgid + "Created IpArkey using CIS number....");
            //</xpr:IpArKey>

            //<xpr:LstCntl>
            LOGGER.info(msgid + "Configuring list control....");
            ListControl lst = new ListControl();
            lst.setLstEntryVal(listentryval);
            lst.setNbrOfEnty(nbrofenty);
            lst.setRqstSetSize(rqstsetsize);
            LOGGER.info(msgid + "List control configured....");
            //</xpr:LstCntl>


            req.setFeRqstKey(rkey);
            req.setIpArKey(custid);
            req.setLstCntl(lst);
            request.setXPRtrvIpAnlytcsMktDtlOsi(req);

            request.setRqstHdr(reqh);
            LOGGER.info(msgid + "Created request body....");
            //</xpr:XPRtrvIpAnlytcsMktDtlOsi>

            LOGGER.info(msgid + "Calling SOAP endpoint....");

            /**
             *
             * testing with xml string
             *
             */
            /*
            Path filePath = Path.of("sample.xml");
            String content = Files.readString(filePath);
            StringReader sr = new StringReader(content);
            JAXBContext jaxbContext = JAXBContext.newInstance(XPRetrieveIpAnlytcsMktDtlRqst.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            XPRetrieveIpAnlytcsMktDtlRqst re = (XPRetrieveIpAnlytcsMktDtlRqst) unmarshaller.unmarshal(sr);


            MessageFactory mf = MessageFactory.newInstance();
            SOAPMessage message = mf.createMessage();
            SOAPBody body = message.getSOAPBody();

            JAXBContext jc = JAXBContext.newInstance(XPRetrieveIpAnlytcsMktDtlRqst.class);
            Marshaller marshaller = jc.createMarshaller();
            marshaller.marshal(request, body);



            message.saveChanges();
            //message.writeTo(System.out);
            SignSOAPRequest sign = new SignSOAPRequest();
            String str = sign.sign(message);
            System.out.println(str);
            System.out.println(str.replace("namespace = \"https://www.firstbankonline.com/\"", "namespace = \""));
*/
            EndPoint ep = new EndPoint<XPRetrieveIpAnlytcsMktDtlRqst,XPRetrieveIpAnlytcsMktDtlRsp>();
            System.out.println(lclpref);
            XPRetrieveIpAnlytcsMktDtlRsp response = (XPRetrieveIpAnlytcsMktDtlRsp)ep.callSoapendpoint(endpoint,request,new XPRetrieveIpAnlytcsMktDtlRsp());

            System.out.println(response);

            /*
            XPRetrieveIpAnlytcsMktDtlRsp response = (XPRetrieveIpAnlytcsMktDtlRsp) getWebServiceTemplate()
                    .marshalSendAndReceive(endpoint,request);
*/

            //String ucicstr =  response.getXPRtrvIpAnlytcsMktDtlOso().getIpAnlytcsMktDtl().get(0).getAnlytcsMktDtl().getUcic();

            Ucic ucic = new Ucic();
            //ucic.setUcicstr(ucicstr);

            return ucic;
        } catch(Exception e) {
            String stacktrace = ExceptionUtils.getStackTrace(e);
            System.out.println(stacktrace);
            //LOGGER.log(Level.SEVERE,"");
            LOGGER.error(msgid + "; Exception occurred: " + e.getMessage() + " At: " + stacktrace);

        }

        return null;

    }


}