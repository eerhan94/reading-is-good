package com.getir.readingisgood.service;

import com.getir.readingisgood.entity.Order;
import com.getir.readingisgood.model.OrderCreateDTO;
import com.getir.readingisgood.model.OrderResponseDTO;
import org.springframework.data.domain.Page;

/**
 * @Author Eyup Erhan KARAASLAN - eyuperhankaraaslan94@gmail.com
 * @Version 1.0
 */
public interface OrderService {
    OrderResponseDTO createOrder(OrderCreateDTO orderCreateDTO);

    Page<Order> getCustomerOrders(String id, int pageIndex, int pageSize);

    OrderResponseDTO getOrderById(String id);
}
