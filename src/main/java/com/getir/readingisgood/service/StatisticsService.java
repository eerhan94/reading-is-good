package com.getir.readingisgood.service;

import com.getir.readingisgood.model.StatisticResponseDTO;

import java.util.List;

/**
 * The interface Statistics service. @Author Eyup Erhan KARAASLAN -
 * eyuperhankaraaslan94@gmail.com @Version 1.0
 */
public interface StatisticsService {
  /**
   * Gets statistics.
   *
   * @param customerId the customer ıd
   * @return the statistics
   */
  List<StatisticResponseDTO> getStatistics(String customerId);
}
