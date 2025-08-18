package com.fbol.ssoremit.service.model.response;


import javax.xml.bind.annotation.*;

@XmlRootElement(name="Action")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Action", propOrder = {
        "userID",
        "StatusCode",
        "Message",
        "RedirectUrl"
})
public class Action {

    public Action(){

    }

    public void setUserid(String userID){

        this.userID=userID;
    }
    private String userID;

    public String getUserid(){

        return this.userID;
    }

    public void setStatusCode(String StatusCode){

        this.StatusCode=StatusCode;
    }
    private String StatusCode;

    public String getStatusCode(){

        return this.StatusCode;
    }

    public void setMessage(String Message){

        this.Message=Message;
    }
    private String Message;

    public String getMessage(){

        return this.Message;
    }

    public void setRedirectUrl(String RedirectUrl){

        this.RedirectUrl=RedirectUrl;
    }
    private String RedirectUrl;

    public String getRedirectUrl(){

        return this.RedirectUrl;
    }
}
