package com.getir.readingisgood.controller;

import com.getir.readingisgood.model.StatisticResponseDTO;
import com.getir.readingisgood.service.StatisticsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * The type Statistics controller. @Author Eyup Erhan KARAASLAN -
 * eyuperhankaraaslan94@gmail.com @Version 1.0
 */
@RestController
@RequestMapping(path = "/statistics")
public class StatisticsController {
  private final StatisticsService statisticsService;

  /**
   * Instantiates a new Statistics controller.
   *
   * @param statisticsService the statistics service
   */
  public StatisticsController(StatisticsService statisticsService) {
    this.statisticsService = statisticsService;
  }

  /**
   * Gets statistics.
   *
   * @param id the id
   * @return the statistics
   */
  @GetMapping
  public ResponseEntity<List<StatisticResponseDTO>> getStatistics(@RequestParam String id) {
    return ResponseEntity.ok(statisticsService.getStatistics(id));
  }
}
