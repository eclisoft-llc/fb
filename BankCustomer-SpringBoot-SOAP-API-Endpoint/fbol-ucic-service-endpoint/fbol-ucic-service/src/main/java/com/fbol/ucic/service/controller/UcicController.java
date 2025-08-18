package com.fbol.ucic.service.controller;

import java.util.List;

import com.fbol.ucic.service.model.Ucic;
import com.fbol.ucic.service.wsdl.XPRetrieveIpAnlytcsMktDtlRsp;
import com.fbol.ucic.service.wsdl.client.UcicClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class UcicController {

  @Autowired
  private UcicClient uc;

  @GetMapping("/getucic/{cis}")
  public ResponseEntity<Ucic> getUcic(@PathVariable String cis) {

    //UcicClient uc = new UcicClient();
    Ucic res = uc.getUcic(cis);// ucicClient.getUcic(cis);

    if(res==null)
      return new ResponseEntity(HttpStatus.NOT_FOUND);
    else
      return new ResponseEntity<Ucic>(res, HttpStatus.OK);

  }

}