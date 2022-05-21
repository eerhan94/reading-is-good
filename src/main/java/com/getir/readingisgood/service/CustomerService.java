package com.getir.readingisgood.service;

import com.getir.readingisgood.entity.Customer;
import com.getir.readingisgood.model.CustomerCreateDTO;
import com.getir.readingisgood.model.CustomerResponseDTO;

/**
 * @Author Eyup Erhan KARAASLAN - eyuperhankaraaslan94@gmail.com
 * @Version 1.0
 */
public interface CustomerService {
    CustomerResponseDTO createCustomer(CustomerCreateDTO customerCreateDTO);

    Customer getCustomerById(String id);
}
