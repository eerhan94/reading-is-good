package com.getir.readingisgood.service.impl;

import com.getir.readingisgood.model.StatisticResponseDTO;
import com.getir.readingisgood.repository.OrderRepository;
import com.getir.readingisgood.service.StatisticsService;
import org.springframework.stereotype.Service;

/**
 * @Author Eyup Erhan KARAASLAN - eyuperhankaraaslan94@gmail.com
 * @Version 1.0
 */
@Service
public class StatisticsServiceImpl implements StatisticsService {
    private final OrderRepository orderRepository;

    public StatisticsServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public StatisticResponseDTO getStatistics(String customerId) {
        return null;
    }
}