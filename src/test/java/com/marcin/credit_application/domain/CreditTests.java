package com.marcin.credit_application.domain;
import com.marcin.credit_application.domain.Credit.Credit;
import com.marcin.credit_application.domain.Credit.CreditDao;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CreditTests {

    @Autowired
    private CreditDao repository;

    @Test
    public void testCreateUpdateDeleteCredit() {
        //Given
        Credit credit = new Credit("test");
        //When
        repository.save(credit);
        //Then
        assertTrue(repository.findById(credit.getId()).isPresent());
        //Update
        credit.setCreditName("update");
        repository.save(credit);
        //Then
        assertTrue(repository.findById(credit.getId()).isPresent());
        assertEquals(credit.getCreditName(), "update");
        //CleanUp
        repository.deleteById(credit.getId());
        assertFalse(repository.findById(credit.getId()).isPresent());
    }
}
