package com.getir.readingisgood.service.impl;

import com.getir.readingisgood.entity.Order;
import com.getir.readingisgood.model.StatisticResponseDTO;
import com.getir.readingisgood.repository.OrderRepository;
import com.getir.readingisgood.service.StatisticsService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * The type Statistics service. @Author Eyup Erhan KARAASLAN -
 * eyuperhankaraaslan94@gmail.com @Version 1.0
 */
@Service
public class StatisticsServiceImpl implements StatisticsService {
  private final OrderRepository orderRepository;

  /**
   * Instantiates a new Statistics service.
   *
   * @param orderRepository the order repository
   */
  public StatisticsServiceImpl(OrderRepository orderRepository) {
    this.orderRepository = orderRepository;
  }

  @Override
  public List<StatisticResponseDTO> getStatistics(String customerId) {

    List<Order> customerOrders = orderRepository.findAllByCustomerId(customerId);
    Map<Integer, List<Order>> result =
        customerOrders.stream()
            .collect(
                Collectors.groupingBy(
                    order -> {
                      LocalDate localDate =
                          order
                              .getCreatedAt()
                              .toInstant()
                              .atZone(ZoneId.systemDefault())
                              .toLocalDate();
                      return localDate.getMonthValue();
                    }));
    return result.entrySet().stream()
        .map(entry -> createCustomerMonthlyStatics(entry.getKey(), entry.getValue()))
        .collect(Collectors.toList());
  }

  private StatisticResponseDTO createCustomerMonthlyStatics(Integer month, List<Order> orderList) {
    int totalBookCount = 0;
    double totalPurchasedAmount = 0;
    for (Order order : orderList) {
      totalBookCount += order.getOrderBooks().size();
      totalPurchasedAmount += order.getTotalPrice();
    }
    return new StatisticResponseDTO(
        Month.of(month).name(), orderList.size(), totalBookCount, totalPurchasedAmount);
  }
}
