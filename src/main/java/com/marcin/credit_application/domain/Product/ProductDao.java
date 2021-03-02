package com.marcin.credit_application.domain.Product;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface ProductDao extends CrudRepository<Product, Integer> {
    @Override
    List<Product> findAll();

    @Override
    Optional<Product> findById(Integer id);

    @Override
    Product save(Product product);

    @Override
    void deleteById(Integer id);
}