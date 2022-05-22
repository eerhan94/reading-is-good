package com.getir.readingisgood.service.impl;

import com.getir.readingisgood.entity.Customer;
import com.getir.readingisgood.exception.ErrorCodes;
import com.getir.readingisgood.exception.GlobalApiException;
import com.getir.readingisgood.mapper.CustomerMapper;
import com.getir.readingisgood.model.CustomerCreateDTO;
import com.getir.readingisgood.model.CustomerResponseDTO;
import com.getir.readingisgood.repository.CustomerRepository;
import com.getir.readingisgood.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

/**
 * @Author Eyup Erhan KARAASLAN - eyuperhankaraaslan94@gmail.com
 * @Version 1.0
 */
@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public CustomerResponseDTO createCustomer(CustomerCreateDTO customerCreateDTO) {
        Customer customer = customerMapper.customerCreateToCustomerEntity(customerCreateDTO);
        uniqueValidation(customerCreateDTO);
        return customerMapper.customerEntityToCustomerResponse(customerRepository.save(customer));
    }

    private void uniqueValidation(CustomerCreateDTO customerCreateDTO) {
        Customer customer = customerRepository.findByEmail(customerCreateDTO.getEmail());
        if (Objects.nonNull(customer)) {
            throw new GlobalApiException(ErrorCodes.EMAIL_ALREADY_USING);
        }
        customer = customerRepository.findByPhone(customerCreateDTO.getPhone());
        if (Objects.nonNull(customer)) {
            throw new GlobalApiException(ErrorCodes.PHONE_ALREADY_USING);
        }
    }

    @Override
    public Customer getCustomerById(String id) {
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isPresent()) {
            return customer.get();
        } else {
            throw new GlobalApiException(ErrorCodes.CUSTOMER_NOT_FOUND);
        }
    }
}
