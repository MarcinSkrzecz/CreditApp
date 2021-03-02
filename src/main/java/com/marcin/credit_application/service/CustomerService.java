package com.marcin.credit_application.service;

import com.marcin.credit_application.domain.CreateObjectDto;
import com.marcin.credit_application.domain.Customer.Customer;
import com.marcin.credit_application.domain.Customer.CustomerDao;
import com.marcin.credit_application.mapper.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerDao repository;
    @Autowired
    private Mappers mapper;

    public Customer getCustomerById(final Integer id) {

        if (repository.findById(id).isPresent()) {
            return repository.findById(id).get();
        } else throw new IllegalArgumentException("Customer not found");
    }

    public void creatCustomer(final CreateObjectDto create, Integer creditId) {
        Customer customer = mapper.mapToCustomer(create);
        customer.setId(creditId);
        repository.save(customer);
        System.out.println(customer.toString());
    }

}
