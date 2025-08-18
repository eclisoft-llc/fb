package com.fbol.xaa.controller;


import com.fbol.xaa.model.Input;
import com.fbol.xaa.model.Xaa;
import com.fbol.xaa.model.orm.Imapper;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Controller
public class XaaController {

    @Autowired
    private Imapper mapper;

    @PostMapping("/getxaa")
    public ResponseEntity<List<Xaa>> getxaa(@RequestBody Input input) throws Exception{

try{
    if(input.getType().equals(Input.RequestType.anum))
        return new ResponseEntity<List<Xaa>>(mapper.getbyaccnum(input.getAccountnumber().trim()), HttpStatus.OK);
    else if(input.getType().equals(Input.RequestType.anumdate))
            return new ResponseEntity<List<Xaa>>(mapper.getbyaccnumanddate(input.getAccountnumber().trim(),input.getStartdate()), HttpStatus.OK);
    else if(input.getType().equals(Input.RequestType.anumsdate))
        return new ResponseEntity<List<Xaa>>(mapper.getbyaccnumandsdate(input.getAccountnumber().trim(),input.getStartdate()), HttpStatus.OK);
    else if(input.getType().equals(Input.RequestType.anumedate))
        return new ResponseEntity<List<Xaa>>(mapper.getbyaccnumandedate(input.getAccountnumber().trim(),input.getEnddate()), HttpStatus.OK);
    else if(input.getType().equals(Input.RequestType.anumsdateedate))
        return new ResponseEntity<List<Xaa>>(mapper.getbyaccnumandsdateandedate(input.getAccountnumber().trim(),input.getStartdate()
                ,input.getEnddate()), HttpStatus.OK);

    else
        return new ResponseEntity<>(
            HttpStatus.NOT_FOUND);

} catch(Exception e) {

    throw new ResponseStatusException(
            HttpStatus.NOT_FOUND,
            e.getMessage() + " At: " + ExceptionUtils.getStackTrace(e)
    );


}

    }


}
