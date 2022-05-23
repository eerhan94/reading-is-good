package com.getir.readingisgood.service;

import com.getir.readingisgood.entity.Customer;
import com.getir.readingisgood.model.CustomerCreateDTO;
import com.getir.readingisgood.model.CustomerResponseDTO;

/**
 * The interface Customer service. @Author Eyup Erhan KARAASLAN -
 * eyuperhankaraaslan94@gmail.com @Version 1.0
 */
public interface CustomerService {
  /**
   * Create customer customer response dto.
   *
   * @param customerCreateDTO the customer create dto
   * @return the customer response dto
   */
  CustomerResponseDTO createCustomer(CustomerCreateDTO customerCreateDTO);

  /**
   * Gets customer by ıd.
   *
   * @param id the id
   * @return the customer by ıd
   */
  Customer getCustomerById(String id);
}
