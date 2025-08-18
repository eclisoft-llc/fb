package com.fbol.ssoremit.service.model;

public class SsoToken {

    private String Token;


    public void setToken(String Token){

        this.Token=Token;
    }

    public String getToken(){

        return this.Token;
    }

    public void setRedirectUrl(String RedirectUrl){

        this.RedirectUrl=RedirectUrl;
    }
    private String RedirectUrl;

    public String getRedirectUrl(){

        return this.RedirectUrl;
    }

    public void setMessage(String Message){

        this.Message=Message;
    }
    private String Message;

    public String getMessage(){

        return this.Message;
    }
}
