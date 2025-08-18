package com.fbol.ssoremit.service.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="Authentication")

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Authentication",propOrder = {
        "UserID",
        "ClientID",
        "Token"
})


public class Authentication {

    public Authentication(){

    }
    public void setUserid(String UserID){

        this.UserID=UserID;
    }
    private String UserID;

    public String getUserid(){

        return this.UserID;
    }

    public void setClientid(String ClientID){

        this.ClientID=ClientID;
    }
    private String ClientID;

    public String getClientid(){

        return this.ClientID;
    }

    public void setToken(String Token){

        this.Token=Token;
    }
    private String Token;

    public String getToken(){

        return this.Token;
    }
}
