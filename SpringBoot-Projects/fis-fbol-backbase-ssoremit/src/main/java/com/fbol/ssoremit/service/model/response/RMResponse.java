package com.fbol.ssoremit.service.model.response;

import javax.xml.bind.annotation.*;

@XmlRootElement(name="RMResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class RMResponse {

    @XmlElement(name = "Action")
    protected Action action;

    public void setAction(Action value){

        this.action = value;
    }

    public Action getAction(){

        return action;
    }


}
