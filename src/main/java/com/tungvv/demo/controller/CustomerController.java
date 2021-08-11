package com.tungvv.demo.controller;

import com.tungvv.demo.dao.CustomerRepository;
import com.tungvv.demo.dto.CustomerSearchRequest;
import com.tungvv.demo.model.Customer;
import com.tungvv.demo.specification.CustomerSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping
    public ResponseEntity searchCustomers(CustomerSearchRequest request) {

        CustomerSpecification spec = new CustomerSpecification(request.toCustomer());

        List<Customer> customers = customerRepository.findAll(spec);

        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

}
