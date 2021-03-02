package com.marcin.credit_application.domain;

import com.marcin.credit_application.domain.Customer.Customer;
import com.marcin.credit_application.domain.Customer.CustomerDao;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CustomerTests {

    @Autowired
    private CustomerDao repository;

    @Test
    public void testCreateUpdateDeleteCustomer() {
        //Given
        Customer customer = new Customer(1, "test", "test", "test");
        //When
        repository.save(customer);
        //Then
        assertTrue(repository.findById(customer.getId()).isPresent());
        //Update
        customer.setFirstName("update");
        repository.save(customer);
        //Then
        assertTrue(repository.findById(customer.getId()).isPresent());
        assertEquals(customer.getFirstName(), "update");
        //CleanUp
        repository.deleteById(customer.getId());
        assertFalse(repository.findById(customer.getId()).isPresent());
    }
}
