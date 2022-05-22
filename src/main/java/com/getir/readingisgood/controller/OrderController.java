package com.getir.readingisgood.controller;

import com.getir.readingisgood.model.OrderCreateDTO;
import com.getir.readingisgood.model.OrderResponseDTO;
import com.getir.readingisgood.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * The type Order controller. @Author Eyup Erhan KARAASLAN - eyuperhankaraaslan94@gmail.com @Version
 * 1.0
 */
@RestController
@RequestMapping(path = "/order")
public class OrderController {
  private final OrderService orderService;
  private final DateFormat dateFormat;

  /**
   * Instantiates a new Order controller.
   *
   * @param orderService the order service
   */
  public OrderController(OrderService orderService) {
    this.orderService = orderService;
    this.dateFormat = new SimpleDateFormat("yyyy-MM-dd");
  }

  /**
   * Create order response entity.
   *
   * @param orderCreateDTO the order create dto
   * @return the response entity
   */
  @PostMapping
  public ResponseEntity<OrderResponseDTO> createOrder(
      @Valid @RequestBody OrderCreateDTO orderCreateDTO) {
    return ResponseEntity.ok(orderService.createOrder(orderCreateDTO));
  }

  /**
   * Gets orders by customer ıd.
   *
   * @param id the id
   * @return the orders by customer ıd
   */
  @GetMapping("/{id}")
  public ResponseEntity<OrderResponseDTO> getOrdersByCustomerId(@PathVariable String id) {
    return ResponseEntity.ok(orderService.getOrderById(id));
  }

  /**
   * Gets orders by date ınterval.
   *
   * @param endDate the end date
   * @param startDate the start date
   * @return the orders by date ınterval
   * @throws ParseException the parse exception
   */
  @GetMapping
  public ResponseEntity<List<OrderResponseDTO>> getOrdersByDateInterval(
      @RequestHeader(value = "startDate") String endDate,
      @RequestHeader(value = "endDate") String startDate)
      throws ParseException {
    return ResponseEntity.ok(
        orderService.getOrdersByDateInterval(
            dateFormat.parse(endDate), dateFormat.parse(startDate)));
  }
}
