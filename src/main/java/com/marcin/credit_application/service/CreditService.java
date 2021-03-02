package com.marcin.credit_application.service;

import com.marcin.credit_application.domain.CreateObjectDto;
import com.marcin.credit_application.domain.Credit.Credit;
import com.marcin.credit_application.domain.Credit.CreditDao;
import com.marcin.credit_application.mapper.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreditService {

    @Autowired
    private CreditDao repository;
    @Autowired
    private Mappers mapper;

    public Integer getCreditsCount() {
        return repository.findAll().size();
    }

    public Credit getCreditById(final Integer id) {

        if (repository.findById(id).isPresent()) {
            return repository.findById(id).get();
        } else throw new IllegalArgumentException("Credit not found");
    }

    public Integer creatCredit(final CreateObjectDto create) {
        Credit credit = mapper.mapToCredit(create);
        repository.save(credit);
        System.out.println(credit.toString());
        return credit.getId();
    }

}