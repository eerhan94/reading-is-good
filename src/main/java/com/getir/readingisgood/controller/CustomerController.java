package com.getir.readingisgood.controller;

import com.getir.readingisgood.entity.Order;
import com.getir.readingisgood.model.CustomerCreateDTO;
import com.getir.readingisgood.model.CustomerResponseDTO;
import com.getir.readingisgood.service.CustomerService;
import com.getir.readingisgood.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * The type Customer controller. @Author Eyup Erhan KARAASLAN -
 * eyuperhankaraaslan94@gmail.com @Version 1.0
 */
@RestController
@RequestMapping(path = "/customer")
public class CustomerController {
  /** The Logger. */
  Logger logger = LoggerFactory.getLogger(CustomerController.class);

  private final CustomerService customerService;
  private final OrderService orderService;

  /**
   * Instantiates a new Customer controller.
   *
   * @param customerService the customer service
   * @param orderService the order service
   */
  @Autowired
  public CustomerController(CustomerService customerService, OrderService orderService) {
    this.customerService = customerService;
    this.orderService = orderService;
  }

  /**
   * Create customer response entity.
   *
   * @param customerCreateDTO the customer create dto
   * @return the response entity
   */
  @PostMapping
  public ResponseEntity<CustomerResponseDTO> createCustomer(
      @Valid @RequestBody CustomerCreateDTO customerCreateDTO) {
    logger.info("createCustomer starting -> bookCreateDTO:{}", customerCreateDTO);
    return ResponseEntity.ok(customerService.createCustomer(customerCreateDTO));
  }

  /**
   * Gets orders by customer ıd.
   *
   * @param id the id
   * @param pageIndex the page ındex
   * @param pageSize the page size
   * @return the orders by customer ıd
   */
  @GetMapping("/orders")
  public ResponseEntity<Page<Order>> getOrdersByCustomerId(
      @RequestParam String id, @RequestParam int pageIndex, @RequestParam int pageSize) {
    logger.info(
        "getOrdersByCustomerId starting -> id:{}, pageIndex:{}, pageSize:{}",
        id,
        pageIndex,
        pageSize);
    return ResponseEntity.ok(orderService.getCustomerOrders(id, pageIndex, pageSize));
  }
}
