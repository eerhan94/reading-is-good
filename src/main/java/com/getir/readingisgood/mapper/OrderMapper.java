package com.getir.readingisgood.mapper;

import com.getir.readingisgood.entity.Order;
import com.getir.readingisgood.model.OrderResponseDTO;
import org.springframework.stereotype.Component;

/**
 * The type Order mapper. @Author Eyup Erhan KARAASLAN - eyuperhankaraaslan94@gmail.com @Version 1.0
 */
@Component
public class OrderMapper {
  /**
   * Order entity to order response order response dto.
   *
   * @param order the order
   * @return the order response dto
   */
  public OrderResponseDTO orderEntityToOrderResponse(Order order) {
    OrderResponseDTO orderResponseDTO = new OrderResponseDTO();
    orderResponseDTO.setId(order.getId());
    orderResponseDTO.setCreatedAt(order.getCreatedAt());
    orderResponseDTO.setCustomerId(order.getCustomerId());
    orderResponseDTO.setTotalPrice(order.getTotalPrice());
    orderResponseDTO.setOrderBooks(order.getOrderBooks());
    return orderResponseDTO;
  }
}
