package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@RestController
@RequestMapping("/api/v1")
public class LeadsController {
    @Autowired
    private LeadsRepository leadsRepository;

    @PostMapping("/leads")
    public ResponseEntity<Object> saveLead(@Valid @RequestBody Lead lead) {

        Optional<Lead> lead2 = leadsRepository.findById(lead.getLeadId());
        if(lead2.isPresent()){

            ErrorResponse err=new ErrorResponse("E10010", Arrays.asList("Lead Already Exists in the database with the lead id"));
            return ResponseHandler.generateResponse(HttpStatus.BAD_REQUEST,err,"error");
        }
        leadsRepository.save(lead);
        return ResponseHandler.generateResponse(HttpStatus.OK,"Created Leads Successfully","success");
    }

    @GetMapping(value= "/leads/{mobileNumber}")
    public ResponseEntity<Object> Get(@PathVariable("mobileNumber") Long mobile) {

            List<Lead>leadList=leadsRepository.findByMobileNumber(String.valueOf(mobile));
            if(!leadList.isEmpty()) {
                return ResponseHandler.generateResponse(HttpStatus.OK,leadList,"success");
            }
        ErrorResponse err=new ErrorResponse("E10011", Arrays.asList("No Lead found with the Mobile Number"));
        return ResponseHandler.generateResponse(HttpStatus.BAD_REQUEST,err,"error");
        }
    }

