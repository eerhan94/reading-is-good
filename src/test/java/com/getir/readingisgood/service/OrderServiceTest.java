package com.getir.readingisgood.service;

import com.getir.readingisgood.entity.Book;
import com.getir.readingisgood.entity.Customer;
import com.getir.readingisgood.entity.Order;
import com.getir.readingisgood.exception.GlobalApiException;
import com.getir.readingisgood.mapper.OrderMapper;
import com.getir.readingisgood.model.OrderResponseDTO;
import com.getir.readingisgood.repository.OrderRepository;
import com.getir.readingisgood.service.impl.OrderServiceImpl;
import com.getir.readingisgood.util.Utils;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

/** @Author Eyup Erhan KARAASLAN - eyuperhankaraaslan94@gmail.com @Version 1.0 */
@RunWith(MockitoJUnitRunner.class)
public class OrderServiceTest {
  @InjectMocks private OrderServiceImpl orderService;

  @Mock OrderRepository orderRepository;

  @Mock OrderMapper orderMapper;

  @Mock CustomerService customerService;

  @Mock BookService bookService;

  @Rule public ExpectedException expectedException = ExpectedException.none();

  @Test
  public void createNewOrder_shouldBeSuccess() {
    when(customerService.getCustomerById(any(String.class))).thenReturn(Utils.createCustomer());
    when(bookService.getBookById(any(String.class))).thenReturn(Utils.createBook());
    when(orderRepository.save(any(Order.class))).thenReturn(Utils.order());
    when(orderMapper.orderEntityToOrderResponse(any(Order.class)))
        .thenReturn(Utils.orderResponseDTO());
    OrderResponseDTO result = orderService.createOrder(Utils.orderCreateDTO());
    Assert.assertNotNull(result);
  }

  @Test
  public void createNewOrder_shouldBeError_productEmpty() {
    expectedException.expect(GlobalApiException.class);
    when(customerService.getCustomerById(any(String.class))).thenReturn(Utils.createCustomer());
    Book book = Utils.createBook();
    book.setQuantity(0);
    when(bookService.getBookById(any(String.class))).thenReturn(book);
    orderService.createOrder(Utils.orderCreateDTO());
  }

  @Test
  public void getCustomerOrder_shouldBeSuccess() {
    Customer customer = Utils.createCustomer();
    Pageable paging = PageRequest.of(0, 5);
    when(orderRepository.findByCustomerId(customer.getId(), paging)).thenReturn(Utils.pageOrder());
    Page<Order> result = orderService.getCustomerOrders(customer.getId(), 0, 5);
    Assert.assertNotNull(result);
  }

  @Test
  public void getOrderById_shouldBeSuccess() {
    when(orderRepository.findById(any(String.class)))
        .thenReturn(java.util.Optional.of(Utils.order()));
    when(orderMapper.orderEntityToOrderResponse(any(Order.class)))
        .thenReturn(Utils.orderResponseDTO());
    OrderResponseDTO result = orderService.getOrderById(Utils.generateRandomString());
    Assert.assertNotNull(result);
  }
}
