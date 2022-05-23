package com.getir.readingisgood.service;

import com.getir.readingisgood.model.StatisticResponseDTO;
import com.getir.readingisgood.repository.OrderRepository;
import com.getir.readingisgood.service.impl.StatisticsServiceImpl;
import com.getir.readingisgood.util.Utils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

/** @Author Eyup Erhan KARAASLAN - eyuperhankaraaslan94@gmail.com @Version 1.0 */
@RunWith(MockitoJUnitRunner.class)
public class StatisticServiceTest {
  @InjectMocks private StatisticsServiceImpl statisticsService;

  @Mock OrderRepository orderRepository;

  @Test
  public void getStatistics_shouldBeSuccess() {
    when(orderRepository.findAllByCustomerId(any(String.class)))
        .thenReturn(Collections.singletonList(Utils.order()));
    List<StatisticResponseDTO> result =
        statisticsService.getStatistics(Utils.generateRandomString());
    Assert.assertNotNull(result);
  }
}
