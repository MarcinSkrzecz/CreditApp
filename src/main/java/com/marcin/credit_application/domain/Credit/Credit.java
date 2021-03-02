package com.marcin.credit_application.domain.Credit;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity(name = "Credit")
public class Credit {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue
    @Column(name = "CREDIT_ID")
    private Integer id;

    @Column(name = "CREDIT_NAME")
    private String creditName;

    public Credit(String creditName) {
        this.creditName = creditName;
    }

    @Override
    public String toString() {
        return "Credit{" +
                "id=" + id +
                ", creditName='" + creditName + '\'' +
                '}';
    }
}
