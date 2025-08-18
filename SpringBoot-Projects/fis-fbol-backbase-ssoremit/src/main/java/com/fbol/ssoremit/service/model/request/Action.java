package com.fbol.ssoremit.service.model.request;


import javax.xml.bind.annotation.*;


@XmlRootElement(name="Action")
@XmlAccessorType(XmlAccessType.FIELD)

@XmlType(name = "Action", propOrder = {
        "userID",
        "CustomerCode"
})




public class Action {

    public Action(){

    }
    @XmlAttribute(name="Name")
    private String name;

    /** Getter.
     * @return the name
     */
    public String getName() {
        return name;
    }

    /** Setter.
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }


    public void setUserid(String userID){

        this.userID=userID;
    }
    private String userID;

    public String getUserid(){

        return this.userID;
    }

    public void setCustomerCode(String CustomerCode){

        this.CustomerCode=CustomerCode;
    }
    private String CustomerCode;

    public String getCustomerCode(){

        return this.CustomerCode;
    }
}
