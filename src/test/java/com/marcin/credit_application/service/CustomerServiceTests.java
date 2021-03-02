package com.marcin.credit_application.service;

import com.marcin.credit_application.domain.Customer.Customer;
import com.marcin.credit_application.domain.Customer.CustomerDao;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
public class CustomerServiceTests {

    @InjectMocks
    private CustomerService service;
    @Mock
    private CustomerDao repository;

    @Test
    public void testFindCustomerById() {
        //Given
        Customer customer = new Customer(1, "test","test","test");

        when(repository.findById(any())).thenReturn(Optional.of(customer));

        //When
        Customer searchedCustomer = service.getCustomerById(1);

        //Then
        assertEquals("test", searchedCustomer.getFirstName());

        verify(repository, times(2)).findById(1);
    }
}
