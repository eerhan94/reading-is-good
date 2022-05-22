package com.getir.readingisgood.mapper;

import com.getir.readingisgood.entity.Customer;
import com.getir.readingisgood.model.CustomerCreateDTO;
import com.getir.readingisgood.model.CustomerResponseDTO;
import org.springframework.stereotype.Component;

/**
 * The type Customer mapper. @Author Eyup Erhan KARAASLAN - eyuperhankaraaslan94@gmail.com @Version
 * 1.0
 */
@Component
public class CustomerMapper {
  /**
   * Customer create to customer entity customer.
   *
   * @param customerCreateDTO the customer create dto
   * @return the customer
   */
  public Customer customerCreateToCustomerEntity(CustomerCreateDTO customerCreateDTO) {
    Customer customer = new Customer();
    customer.setName(customerCreateDTO.getName());
    customer.setSurname(customerCreateDTO.getSurname());
    customer.setEmail(customerCreateDTO.getEmail());
    customer.setPhone(customerCreateDTO.getPhone());
    customer.setAddress(customerCreateDTO.getAddress());
    return customer;
  }

  /**
   * Customer entity to customer response customer response dto.
   *
   * @param customer the customer
   * @return the customer response dto
   */
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
