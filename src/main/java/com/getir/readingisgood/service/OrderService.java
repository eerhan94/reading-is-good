package com.getir.readingisgood.service;

import com.getir.readingisgood.entity.Order;
import com.getir.readingisgood.model.OrderCreateDTO;
import com.getir.readingisgood.model.OrderResponseDTO;
import org.springframework.data.domain.Page;

import java.util.Date;
import java.util.List;

/**
 * The interface Order service. @Author Eyup Erhan KARAASLAN -
 * eyuperhankaraaslan94@gmail.com @Version 1.0
 */
public interface OrderService {
  /**
   * Create order order response dto.
   *
   * @param orderCreateDTO the order create dto
   * @return the order response dto
   */
OrderResponseDTO createOrder(OrderCreateDTO orderCreateDTO);

  /**
   * Gets customer orders.
   *
   * @param id the id
   * @param pageIndex the page ındex
   * @param pageSize the page size
   * @return the customer orders
   */
Page<Order> getCustomerOrders(String id, int pageIndex, int pageSize);

  /**
   * Gets order by ıd.
   *
   * @param id the id
   * @return the order by ıd
   */
OrderResponseDTO getOrderById(String id);

  /**
   * Gets orders by date ınterval.
   *
   * @param endDate the end date
   * @param startDate the start date
   * @return the orders by date ınterval
   */
List<OrderResponseDTO> getOrdersByDateInterval(Date endDate, Date startDate);
}
