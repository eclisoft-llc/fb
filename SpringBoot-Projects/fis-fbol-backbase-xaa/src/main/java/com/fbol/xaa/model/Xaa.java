package com.fbol.xaa.model;


import lombok.Getter;
import lombok.Setter;
import org.springframework.core.io.Resource;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

@Getter
@Setter
public class Xaa {


   private String accountnumber;
   private String fullstatementnumber;
   private LocalDateTime statementdate;


}

