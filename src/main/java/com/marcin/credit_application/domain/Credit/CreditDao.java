package com.marcin.credit_application.domain.Credit;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface CreditDao extends CrudRepository<Credit, Integer> {
    @Override
    List<Credit> findAll();

    @Override
    Optional<Credit> findById(Integer id);

    @Override
    Credit save(Credit credit);

    @Override
    void deleteById(Integer id);
}