package com.tungvv.demo.dto;

import com.tungvv.demo.model.Customer;

public class CustomerSearchRequest {

    private Long id;
    private String name;
    private String address;

    public Customer toCustomer() {
        Customer customer = new Customer();

        customer.setName(this.name);
        customer.setAddress(this.address);

        if(this.id != null) {
            customer.setId(this.id);
        }

        return customer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}