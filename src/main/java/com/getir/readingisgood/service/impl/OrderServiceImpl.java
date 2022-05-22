package com.getir.readingisgood.service.impl;

import com.getir.readingisgood.entity.Book;
import com.getir.readingisgood.entity.Order;
import com.getir.readingisgood.exception.ErrorCodes;
import com.getir.readingisgood.exception.GlobalApiException;
import com.getir.readingisgood.mapper.OrderMapper;
import com.getir.readingisgood.model.BookStockUpdateDTO;
import com.getir.readingisgood.model.OrderBook;
import com.getir.readingisgood.model.OrderCreateDTO;
import com.getir.readingisgood.model.OrderResponseDTO;
import com.getir.readingisgood.repository.OrderRepository;
import com.getir.readingisgood.service.BookService;
import com.getir.readingisgood.service.CustomerService;
import com.getir.readingisgood.service.OrderService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @Author Eyup Erhan KARAASLAN - eyuperhankaraaslan94@gmail.com
 * @Version 1.0
 */
@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final CustomerService customerService;
    private final BookService bookService;

    public OrderServiceImpl(OrderRepository orderRepository, OrderMapper orderMapper, CustomerService customerService, BookService bookService) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
        this.customerService = customerService;
        this.bookService = bookService;
    }

    @Override
    public OrderResponseDTO createOrder(OrderCreateDTO orderCreateDTO) {
        Order order = new Order();
        List<OrderBook> orderBookList = new ArrayList<>();
        Double totalPrice = 0.0;
        customerValidate(orderCreateDTO.getCustomerId());
        for (OrderBook orderBook : orderCreateDTO.getBooks()) {
            Book book = bookService.getBookById(orderBook.getBookId());
            if (orderBook.getQuantity() > book.getQuantity()) {
                throw new GlobalApiException(ErrorCodes.BOOKS_NOT_ENOUGH);
            }
            updateStockRecords(orderBook, book);
            totalPrice += calculatePrice(orderBook, book.getPrice());
            orderBookList.add(orderBook);
        }
        order.setOrderBooks(orderBookList);
        order.setTotalPrice(totalPrice);
        order.setCustomerId(orderCreateDTO.getCustomerId());
        order = orderRepository.save(order);
        return orderMapper.orderEntityToOrderResponse(order);
    }

    @Override
    public Page<Order> getCustomerOrders(String id, int pageIndex, int pageSize) {
        customerValidate(id);
        Pageable paging = PageRequest.of(pageIndex, pageSize);
        return orderRepository.findByCustomerId(id, paging);
    }

    @Override
    public OrderResponseDTO getOrderById(String id) {
        Optional<Order> order = orderRepository.findById(id);
        if (order.isPresent()) {
            return orderMapper.orderEntityToOrderResponse(order.get());
        } else {
            throw new GlobalApiException(ErrorCodes.ORDER_NOT_FOUND);
        }
    }

    @Override
    public List<OrderResponseDTO> getOrdersByDateInterval(Date endDate, Date startDate) {
        List<Order> orderList = orderRepository.findByCreatedAtBetween(endDate, startDate);
        return orderList.stream().map(orderMapper::orderEntityToOrderResponse).collect(Collectors.toList());
    }

    public void customerValidate(String id) {
        customerService.getCustomerById(id);
    }

    private void updateStockRecords(OrderBook orderBook, Book book) {
        BookStockUpdateDTO bookStockUpdateDTO = new BookStockUpdateDTO();
        bookStockUpdateDTO.setId(book.getId());
        bookStockUpdateDTO.setQuantity(book.getQuantity() - orderBook.getQuantity());
        bookService.bookStockUpdate(bookStockUpdateDTO);
    }

    private Double calculatePrice(OrderBook orderBook, Double price) {
        return orderBook.getQuantity() * price;
    }
}