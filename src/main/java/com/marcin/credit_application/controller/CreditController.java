package com.marcin.credit_application.controller;

import com.marcin.credit_application.domain.CreateObjectDto;
import com.marcin.credit_application.domain.GetObjectsDto;
import com.marcin.credit_application.domain.exceptions.ValidationInputException;
import com.marcin.credit_application.service.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api")
public class CreditController {

    @Autowired
    private Services service;

    @RequestMapping(method = RequestMethod.GET, value = "/get")
    public List<GetObjectsDto> getAllCredits() {
        return service.getAllCredits();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/create", consumes = APPLICATION_JSON_VALUE)
    public Integer createCredit(@RequestBody CreateObjectDto create) throws Exception {
        try {
            return service.creatCredit(create);
        } catch (Exception e) {
            throw new ValidationInputException("Observed issue: " + e.getMessage());
        }
    }
}
