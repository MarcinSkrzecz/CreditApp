package com.marcin.credit_application.domain;
import com.marcin.credit_application.domain.Product.Product;
import com.marcin.credit_application.domain.Product.ProductDao;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ProductTests {

    @Autowired
    private ProductDao repository;

    @Test
    public void testCreateUpdateDeleteMessage() {
        //Given
        Product product = new Product(1, "test", 123);
        //When
        repository.save(product);
        //Then
        assertTrue(repository.findById(product.getId()).isPresent());
        //Update
        product.setProductName("update");
        repository.save(product);
        //Then
        assertTrue(repository.findById(product.getId()).isPresent());
        assertEquals(product.getProductName(), "update");
        //CleanUp
        repository.deleteById(product.getId());
        assertFalse(repository.findById(product.getId()).isPresent());
    }
}
