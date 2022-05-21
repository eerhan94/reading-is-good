package com.getir.readingisgood.mapper;

import com.getir.readingisgood.entity.Customer;
import com.getir.readingisgood.model.CustomerCreateDTO;
import com.getir.readingisgood.model.CustomerResponseDTO;
import org.springframework.stereotype.Component;

/**
 * @Author Eyup Erhan KARAASLAN - eyuperhankaraaslan94@gmail.com
 * @Version 1.0
 */
@Component
public class CustomerMapper {
    public Customer customerCreateToCustomerEntity(CustomerCreateDTO customerCreateDTO) {
        Customer customer = new Customer();
        customer.setName(customerCreateDTO.getName());
        customer.setSurname(customerCreateDTO.getSurname());
        customer.setEmail(customerCreateDTO.getEmail());
        customer.setPhone(customerCreateDTO.getPhone());
        customer.setAddress(customerCreateDTO.getAddress());
        return customer;
    }

    public CustomerResponseDTO customerEntityToCustomerResponse(Customer customer) {
        CustomerResponseDTO customerResponseDTO = new CustomerResponseDTO();
        customerResponseDTO.setId(customer.getId());
        customerResponseDTO.setName(customer.getName());
        customerResponseDTO.setSurname(customer.getSurname());
        customerResponseDTO.setEmail(customer.getEmail());
        customerResponseDTO.setPhone(customer.getPhone());
        customerResponseDTO.setAddress(customer.getAddress());
        return customerResponseDTO;
    }
}
