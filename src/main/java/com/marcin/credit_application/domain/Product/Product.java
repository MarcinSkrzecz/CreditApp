package com.marcin.credit_application.domain.Product;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity(name = "Product")
public class Product {

    @Id
    @EqualsAndHashCode.Include
    @Column(name = "CREDIT_ID")
    private Integer id;

    @Column(name = "PRODUCT_NAME")
    private String productName;

    @Column(name = "VALUE")
    private Integer value;

    public Product(String productName, Integer value) {
        this.productName = productName;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", value=" + value +
                '}';
    }
}
