package com.marcin.credit_application.service;

import com.marcin.credit_application.domain.Credit.Credit;
import com.marcin.credit_application.domain.Credit.CreditDao;
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
public class CreditServiceTests {

    @InjectMocks
    private CreditService service;
    @Mock
    private CreditDao repository;

    @Test
    public void testFindCreditById() {
        //Given
        Credit credit = new Credit(1, "test");

        when(repository.findById(any())).thenReturn(Optional.of(credit));

        //When
        Credit searchedCredit = service.getCreditById(1);

        //Then
        assertEquals("test", searchedCredit.getCreditName());

        verify(repository, times(2)).findById(1);
    }
}
