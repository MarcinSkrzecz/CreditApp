package com.marcin.credit_application.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CreateObjectDto {

    @NotNull(message = "Credit Name can't be empty")
    @Size(min = 5, max = 200, message = "Credit Name must be between 5 and 200 characters")
    private String creditName;

    @NotNull(message = "Product Name can't be empty")
    @Size(min = 5, max = 200, message = "Product Name must be between 5 and 200 characters")
    private String productName;

    @NotNull(message = "Value can't be empty")
    @Min(value = 1, message = "Value must be greater than 0")
    private Integer value;

    @NotNull(message = "First Name can't be empty")
    @Size(min = 5, max = 200, message = "First Name must be between 5 and 200 characters")
    private String firstName;

    @NotNull(message = "Surname can't be empty")
    @Size(min = 5, max = 200, message = "Surname must be between 5 and 200 characters")
    private String surname;

    @NotNull(message = "Pesel can't be empty")
    @Size(min = 11, max = 11, message = "Pesel must have 11 numbers from 0-9 range")
    private String pesel;

}
