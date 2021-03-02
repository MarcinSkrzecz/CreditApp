package com.marcin.credit_application.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class GetObjectsDto {

    private Integer creditId;
    private String creditName;
    private String productName;
    private Integer value;
    private String firstName;
    private String surname;
    private String pesel;

}
