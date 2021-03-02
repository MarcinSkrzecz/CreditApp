package com.marcin.credit_application.service;

import com.marcin.credit_application.domain.CreateObjectDto;
import com.marcin.credit_application.domain.GetObjectsDto;
import com.marcin.credit_application.domain.Validation.InputValidation;
import com.marcin.credit_application.domain.exceptions.ValidationInputException;
import com.marcin.credit_application.mapper.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Services {

    private static final Logger LOGGER = LoggerFactory.getLogger(Services.class);

    @Autowired
    private CreditService creditService;
    @Autowired
    private ProductService productService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private InputValidation validator;
    @Autowired
    private Mappers mapper;

    public Integer creatCredit(CreateObjectDto create) throws Exception {
        if (validator.validate(create)) {

            Integer creditId = creditService.creatCredit(create);

            productService.creatProduct(create, creditId);

            customerService.creatCustomer(create, creditId);

            LOGGER.info("Credit created");

            return creditId;
        } else {
            throw new ValidationInputException("Validation failed, check input file correctness");
        }

    }

    public List<GetObjectsDto> getAllCredits() {

        List<GetObjectsDto> allCredits = new ArrayList<>();


        for (int id = 1; id <= creditService.getCreditsCount(); id++) {


            allCredits.add(mapper.mapToGetObject(id));

        }

        return allCredits;
    }

}
