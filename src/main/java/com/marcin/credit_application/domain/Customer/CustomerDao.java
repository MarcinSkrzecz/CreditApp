package com.marcin.credit_application.domain.Customer;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface CustomerDao extends CrudRepository<Customer, Integer> {
    @Override
    List<Customer> findAll();

    @Override
    Optional<Customer> findById(Integer id);

    @Override
    Customer save(Customer customer);

    @Override
    void deleteById(Integer id);
}