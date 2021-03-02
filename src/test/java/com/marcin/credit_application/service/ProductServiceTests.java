package com.marcin.credit_application.service;

import com.marcin.credit_application.domain.Product.Product;
import com.marcin.credit_application.domain.Product.ProductDao;
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
public class ProductServiceTests {

    @InjectMocks
    private ProductService service;
    @Mock
    private ProductDao repository;

    @Test
    public void testFindProductById() {
        //Given
        Product product = new Product(1, "test",123);

        when(repository.findById(any())).thenReturn(Optional.of(product));

        //When
        Product searchedProduct = service.getProductById(1);

        //Then
        assertEquals("test", searchedProduct.getProductName());

        verify(repository, times(2)).findById(1);
    }
}
