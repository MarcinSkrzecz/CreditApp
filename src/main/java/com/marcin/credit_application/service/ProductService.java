package com.marcin.credit_application.service;

import com.marcin.credit_application.domain.CreateObjectDto;
import com.marcin.credit_application.domain.Product.Product;
import com.marcin.credit_application.domain.Product.ProductDao;
import com.marcin.credit_application.mapper.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductDao repository;
    @Autowired
    private Mappers mapper;

    public Product getProductById(final Integer id) {

        if (repository.findById(id).isPresent()) {
            return repository.findById(id).get();
        } else throw new IllegalArgumentException("Product not found");
    }

    public void creatProduct(final CreateObjectDto create, Integer creditId) {
        Product product = mapper.mapToProduct(create);
        product.setId(creditId);
        repository.save(product);
        System.out.println(product.toString());
    }

}
