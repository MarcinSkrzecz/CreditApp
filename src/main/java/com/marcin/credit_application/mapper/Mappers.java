package com.marcin.credit_application.mapper;

import com.marcin.credit_application.domain.CreateObjectDto;
import com.marcin.credit_application.domain.GetObjectsDto;
import com.marcin.credit_application.domain.Credit.Credit;
import com.marcin.credit_application.domain.Customer.Customer;
import com.marcin.credit_application.domain.Product.Product;
import com.marcin.credit_application.service.CreditService;
import com.marcin.credit_application.service.CustomerService;
import com.marcin.credit_application.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mappers {

    @Autowired
    private CreditService creditService;
    @Autowired
    private ProductService productService;
    @Autowired
    private CustomerService customerService;

    public Credit mapToCredit(final CreateObjectDto create) {
        return new Credit(
                create.getCreditName()
        );
    }

    public Product mapToProduct(final CreateObjectDto create) {
        return new Product(
                create.getProductName(),
                create.getValue()
        );
    }

    public Customer mapToCustomer(final CreateObjectDto create) {
        return new Customer(
                create.getFirstName(),
                create.getSurname(),
                create.getPesel()
        );
    }

    public GetObjectsDto mapToGetObject(final Integer id) {
        Credit credit = creditService.getCreditById(id);
        Product product = productService.getProductById(id);
        Customer customer = customerService.getCustomerById(id);

        return new GetObjectsDto(
                credit.getId(),
                credit.getCreditName(),
                product.getProductName(),
                product.getValue(),
                customer.getFirstName(),
                customer.getSurname(),
                customer.getPesel()
        );
    }
}
