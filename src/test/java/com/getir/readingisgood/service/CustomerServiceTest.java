package com.getir.readingisgood.service;

import com.getir.readingisgood.entity.Customer;
import com.getir.readingisgood.exception.GlobalApiException;
import com.getir.readingisgood.mapper.CustomerMapper;
import com.getir.readingisgood.model.CustomerCreateDTO;
import com.getir.readingisgood.model.CustomerResponseDTO;
import com.getir.readingisgood.repository.CustomerRepository;
import com.getir.readingisgood.service.impl.CustomerServiceImpl;
import com.getir.readingisgood.util.Utils;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

/** @Author Eyup Erhan KARAASLAN - eyuperhankaraaslan94@gmail.com @Version 1.0 */
@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceTest {

  @InjectMocks private CustomerServiceImpl customerService;

  @Mock CustomerRepository customerRepository;

  @Mock CustomerMapper customerMapper;

  @Rule public ExpectedException expectedException = ExpectedException.none();

  @Test
  public void createCustomer_shouldBeSuccess() {
    Customer customer = Utils.createCustomer();
    when(customerMapper.customerCreateToCustomerEntity(any(CustomerCreateDTO.class)))
        .thenReturn(customer);
    when(customerRepository.save(any(Customer.class))).thenReturn(customer);
    when(customerMapper.customerEntityToCustomerResponse(any(Customer.class)))
        .thenReturn(Utils.createCustomerResponseDTO());
    CustomerResponseDTO result = customerService.createCustomer(Utils.createCustomerCreateDTO());
    Assert.assertNotNull(result);
  }

  @Test
  public void createCustomer_shouldBeError_customerIsNull() {
    expectedException.expect(NullPointerException.class);
    customerService.createCustomer(null);
  }

  @Test
  public void getCustomerById_shouldBeSuccess() {
    Customer customer = Utils.createCustomer();
    when(customerRepository.findById(customer.getId())).thenReturn(java.util.Optional.of(customer));
    Customer result = customerService.getCustomerById(Utils.createCustomer().getId());
    Assert.assertNotNull(result);
  }

  @Test
  public void getCustomerById_shouldBeError_customerNotFound() {
    Customer customer = Utils.createCustomer();
    expectedException.expect(GlobalApiException.class);
    customerService.getCustomerById(customer.getId());
  }
}
