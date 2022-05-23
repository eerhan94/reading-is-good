package com.getir.readingisgood.service.impl;

import com.getir.readingisgood.entity.Customer;
import com.getir.readingisgood.exception.ErrorCodes;
import com.getir.readingisgood.exception.GlobalApiException;
import com.getir.readingisgood.mapper.CustomerMapper;
import com.getir.readingisgood.model.CustomerCreateDTO;
import com.getir.readingisgood.model.CustomerResponseDTO;
import com.getir.readingisgood.repository.CustomerRepository;
import com.getir.readingisgood.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;

/**
 * The type Customer service. @Author Eyup Erhan KARAASLAN - eyuperhankaraaslan94@gmail.com @Version
 * 1.0
 */
@Service
public class CustomerServiceImpl implements CustomerService {
  /** The Logger. */
  Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

  private final CustomerRepository customerRepository;
  private final CustomerMapper customerMapper;

  /**
   * Instantiates a new Customer service.
   *
   * @param customerRepository the customer repository
   * @param customerMapper the customer mapper
   */
  @Autowired
  public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
    this.customerRepository = customerRepository;
    this.customerMapper = customerMapper;
  }

  @Transactional
  @Override
  public CustomerResponseDTO createCustomer(CustomerCreateDTO customerCreateDTO) {
    logger.info(
        "CustomerServiceImpl-createCustomer starting -> customerCreateDTO:{}", customerCreateDTO);
    Customer customer = customerMapper.customerCreateToCustomerEntity(customerCreateDTO);
    uniqueValidation(customerCreateDTO);
    return customerMapper.customerEntityToCustomerResponse(customerRepository.save(customer));
  }

  private void uniqueValidation(CustomerCreateDTO customerCreateDTO) {
    logger.info("CustomerServiceImpl-uniqueValidation starting");
    Customer customer = customerRepository.findByEmail(customerCreateDTO.getEmail());
    if (Objects.nonNull(customer)) {
      logger.info(
          "CustomerServiceImpl-uniqueValidation -> Error message:{}",
          ErrorCodes.EMAIL_ALREADY_USING.getMessage());
      throw new GlobalApiException(ErrorCodes.EMAIL_ALREADY_USING);
    }
    customer = customerRepository.findByPhone(customerCreateDTO.getPhone());
    if (Objects.nonNull(customer)) {
      logger.info(
          "CustomerServiceImpl-uniqueValidation -> Error message:{}",
          ErrorCodes.PHONE_ALREADY_USING.getMessage());
      throw new GlobalApiException(ErrorCodes.PHONE_ALREADY_USING);
    }
  }

  @Override
  public Customer getCustomerById(String id) {
    logger.info("CustomerServiceImpl-getCustomerById starting -> id:{}", id);
    Optional<Customer> customer = customerRepository.findById(id);
    if (customer.isPresent()) {
      return customer.get();
    } else {
      logger.info(
          "CustomerServiceImpl-getCustomerById -> Error message:{}",
          ErrorCodes.CUSTOMER_NOT_FOUND.getMessage());
      throw new GlobalApiException(ErrorCodes.CUSTOMER_NOT_FOUND);
    }
  }
}
