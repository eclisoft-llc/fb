package com.fbol.ucic.service.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="UsernameToken")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UsernameToken", namespace = "http://www.testing.com/UsernameToken", propOrder = {
        "Username"
})
public class UsernameToken {

    public UsernameToken(){

    }
    public void setUsername(String Username){

        this.Username=Username;
    }
    private String Username;

    public String getUsername(){

        return this.Username;
    }
}
