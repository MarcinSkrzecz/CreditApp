package com.marcin.credit_application.domain.Product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ProductDto {

    private Integer id;
    private String productName;
    private Integer value;

}
