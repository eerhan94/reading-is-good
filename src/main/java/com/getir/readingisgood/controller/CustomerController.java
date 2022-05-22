package com.getir.readingisgood.controller;

import com.getir.readingisgood.entity.Order;
import com.getir.readingisgood.model.CustomerCreateDTO;
import com.getir.readingisgood.model.CustomerResponseDTO;
import com.getir.readingisgood.service.CustomerService;
import com.getir.readingisgood.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @Author Eyup Erhan KARAASLAN - eyuperhankaraaslan94@gmail.com
 * @Version 1.0
 */
@RestController
@RequestMapping(path = "/customer")
public class CustomerController {
    private final CustomerService customerService;
    private final OrderService orderService;

    @Autowired
    public CustomerController(CustomerService customerService, OrderService orderService) {
        this.customerService = customerService;
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<CustomerResponseDTO> createCustomer(@Valid @RequestBody CustomerCreateDTO customerCreateDTO) {
        return ResponseEntity.ok(customerService.createCustomer(customerCreateDTO));
    }

    @GetMapping("/orders")
    public ResponseEntity<Page<Order>> getOrdersByCustomerId(@RequestParam String id, @RequestParam int pageIndex, @RequestParam int pageSize) {
        return ResponseEntity.ok(orderService.getCustomerOrders(id, pageIndex, pageSize));
    }
}