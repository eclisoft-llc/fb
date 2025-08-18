package com.fbol.ssoremit.service.controller;


import com.fbol.ssoremit.service.model.SsoToken;
import com.fbol.ssoremit.service.wsdl.client.RestClient;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

@org.springframework.web.bind.annotation.RestController
class SsoController {

    @Autowired
    private RestClient rs;

  @GetMapping("/authtoken/{userid}")
  public ResponseEntity<SsoToken> getAuthToken(@PathVariable String userid) {

    try {
      SsoToken res = rs.getAuthToken(userid);

     return new ResponseEntity<SsoToken>(res, HttpStatus.OK);
    } catch(Exception e) {

      throw new ResponseStatusException(
              HttpStatus.NOT_FOUND,
              e.getMessage() + " At: " + ExceptionUtils.getStackTrace(e)
);


    }

  }

}