package com.marcin.credit_application.domain.Customer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CustomerDto {

    private Integer id;
    private String firstName;
    private String surname;
    private String pesel;

}
