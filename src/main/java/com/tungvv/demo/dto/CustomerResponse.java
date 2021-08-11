package com.tungvv.demo.dto;

import com.tungvv.demo.model.Customer;

public class CustomerResponse {

    private final Long id;
    private final String name;

    private final String address;

    public CustomerResponse(Customer customer) {
        this.id = customer.getId();
        this.name = customer.getName();
        this.address = customer.getAddress();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
}