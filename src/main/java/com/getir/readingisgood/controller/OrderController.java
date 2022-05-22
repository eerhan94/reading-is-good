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
 * @Author Eyup Erhan KARAASLAN - eyuperhankaraaslan94@gmail.com
 * @Version 1.0
 */
@RestController
@RequestMapping(path = "/order")
public class OrderController {
    private final OrderService orderService;
    private final DateFormat dateFormat;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
        this.dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    }

    @PostMapping
    public ResponseEntity<OrderResponseDTO> createOrder(@Valid @RequestBody OrderCreateDTO orderCreateDTO) {
        return ResponseEntity.ok(orderService.createOrder(orderCreateDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponseDTO> getOrdersByCustomerId(@PathVariable String id) {
        return ResponseEntity.ok(orderService.getOrderById(id));
    }

    @GetMapping
    public ResponseEntity<List<OrderResponseDTO>> getOrdersByDateInterval(@RequestHeader(value = "startDate") String endDate, @RequestHeader(value = "endDate") String startDate) throws ParseException {
        return ResponseEntity.ok(orderService.getOrdersByDateInterval(dateFormat.parse(endDate), dateFormat.parse(startDate)));
    }
}
