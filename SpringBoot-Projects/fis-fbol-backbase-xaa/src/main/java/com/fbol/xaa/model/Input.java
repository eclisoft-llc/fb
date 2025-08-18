package com.fbol.xaa.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Input {

    private String accountnumber;
    private LocalDateTime startdate;
    private LocalDateTime enddate;
    private RequestType type;


    public enum RequestType{

        anum,
        anumdate,
        anumsdate,
        anumedate,
        anumsdateedate
    }
}
