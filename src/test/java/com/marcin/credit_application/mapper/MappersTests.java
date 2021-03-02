package com.marcin.credit_application.mapper;

import com.marcin.credit_application.domain.CreateObjectDto;
import com.marcin.credit_application.domain.Credit.Credit;
import com.marcin.credit_application.domain.Customer.Customer;
import com.marcin.credit_application.domain.Product.Product;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class MappersTests {

    @InjectMocks
    private Mappers mapper;

    @Test
    public void mapToCreditTest() {
        //Given
        CreateObjectDto create = new CreateObjectDto("testCN", "testPN",
                123, "testFN", "testS", "123");
        //When
        Credit credit = mapper.mapToCredit(create);
        //Then
        assertEquals(create.getCreditName(), credit.getCreditName());
    }

    @Test
    public void mapToProductTest() {
        //Given
        CreateObjectDto create = new CreateObjectDto("testCN", "testPN",
                123, "testFN", "testS", "123");
        //When
        Product product = mapper.mapToProduct(create);
        //Then
        assertEquals(create.getProductName(), product.getProductName());
        assertEquals(create.getValue(), product.getValue());
    }

    @Test
    public void mapToCustomerTest() {
        //Given
        CreateObjectDto create = new CreateObjectDto("testCN", "testPN",
                123, "testFN", "testS", "123");
        //When
        Customer customer = mapper.mapToCustomer(create);
        //Then
        assertEquals(create.getFirstName(), customer.getFirstName());
        assertEquals(create.getSurname(), customer.getSurname());
        assertEquals(create.getPesel(), customer.getPesel());
    }
}
