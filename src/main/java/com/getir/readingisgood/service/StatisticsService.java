package com.getir.readingisgood.service;

import com.getir.readingisgood.model.StatisticResponseDTO;

/**
 * @Author Eyup Erhan KARAASLAN - eyuperhankaraaslan94@gmail.com
 * @Version 1.0
 */
public interface StatisticsService {
    StatisticResponseDTO getStatistics(String customerId);
}
