package com.fbol.ucic.service.controller;


import com.fbol.ucic.service.model.Ucic;
import com.fbol.ucic.service.wsdl.client.UcicClient;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
class UcicController {

  @Autowired
  private UcicClient uc;

  @GetMapping("/getucic/{cis}")
  public ResponseEntity<Ucic> getUcic(@PathVariable String cis) {

    try {
      Ucic res = uc.getUcic(cis);

     return new ResponseEntity<Ucic>(res, HttpStatus.OK);
    } catch(Exception e) {

      throw new ResponseStatusException(
              HttpStatus.NOT_FOUND,
              e.getMessage() + " At: " + ExceptionUtils.getStackTrace(e)
);


    }

  }

}