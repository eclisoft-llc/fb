package com.fbol.ssoremit.service.model.request;

import com.fbol.ssoremit.service.model.Authentication;

import javax.xml.bind.annotation.*;

@XmlRootElement(name="RMRequest")
@XmlAccessorType(XmlAccessType.FIELD)
public class RMRequest {

    @XmlElement(name = "Authentication")
    protected Authentication Authentication;
    @XmlElement(name = "Action")
    protected Action Action;


    public void setAuthentication(Authentication value){

        this.Authentication=value;
    }

    public Authentication getAuthentication(){

        return Authentication;
    }

    public void setAction(Action value){

        this.Action = value;
    }

    public Action getAction(){

        return Action;
    }



}
