package com.getir.readingisgood.util;

import com.getir.readingisgood.entity.Book;
import com.getir.readingisgood.entity.Customer;
import com.getir.readingisgood.entity.Order;
import com.getir.readingisgood.model.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.Collections;
import java.util.Date;
import java.util.UUID;

/** @Author Eyup Erhan KARAASLAN - eyuperhankaraaslan94@gmail.com @Version 1.0 */
public class Utils {

  public static final int QUANTITY = 10;
  public static final double PRICE = 10.0;

  public static String generateRandomString() {
    return UUID.randomUUID().toString();
  }

  public static Customer createCustomer() {
    Customer customer = new Customer();
    customer.setAddress(generateRandomString());
    customer.setEmail(generateRandomString());
    customer.setName(generateRandomString());
    return customer;
  }

  public static CustomerCreateDTO createCustomerCreateDTO() {
    CustomerCreateDTO customerCreateDTO = new CustomerCreateDTO();
    customerCreateDTO.setAddress(generateRandomString());
    customerCreateDTO.setEmail(generateRandomString());
    customerCreateDTO.setName(generateRandomString());
    return customerCreateDTO;
  }

  public static CustomerResponseDTO createCustomerResponseDTO() {
    CustomerResponseDTO customerResponseDTO = new CustomerResponseDTO();
    customerResponseDTO.setAddress(generateRandomString());
    customerResponseDTO.setEmail(generateRandomString());
    customerResponseDTO.setName(generateRandomString());
    return customerResponseDTO;
  }

  public static OrderCreateDTO orderCreateDTO() {
    OrderCreateDTO orderCreateDTO = new OrderCreateDTO();
    orderCreateDTO.setCustomerId(generateRandomString());
    orderCreateDTO.setBooks(Collections.singletonList(orderBook()));
    return orderCreateDTO;
  }

  private static OrderBook orderBook() {
    OrderBook orderBook = new OrderBook();
    orderBook.setBookId(generateRandomString());
    orderBook.setQuantity(QUANTITY);
    return orderBook;
  }

  public static Book createBook() {
    Book book = new Book();
    book.setName(generateRandomString());
    book.setQuantity(QUANTITY);
    book.setPrice(PRICE);
    return book;
  }

  public static BookCreateDTO bookCreateDTO() {
    BookCreateDTO bookCreateDTO = new BookCreateDTO();
    bookCreateDTO.setName(generateRandomString());
    bookCreateDTO.setQuantity(QUANTITY);
    bookCreateDTO.setPrice(PRICE);
    return bookCreateDTO;
  }

  public static BookResponseDTO bookResponseDTO() {
    BookResponseDTO bookResponseDTO = new BookResponseDTO();
    bookResponseDTO.setName(generateRandomString());
    bookResponseDTO.setQuantity(QUANTITY);
    bookResponseDTO.setPrice(PRICE);
    return bookResponseDTO;
  }

  public static Order order() {
    Order order = new Order();
    order.setCustomerId(generateRandomString());
    order.setOrderBooks(Collections.singletonList(orderBook()));
    order.setCreatedAt(new Date(System.currentTimeMillis()));
    order.setTotalPrice(PRICE);
    return order;
  }

  public static Page<Order> pageOrder() {
    Order order = new Order();
    order.setCustomerId(generateRandomString());
    order.setOrderBooks(Collections.singletonList(orderBook()));
    return new PageImpl(Collections.singletonList(order));
  }

  public static OrderResponseDTO orderResponseDTO() {
    OrderResponseDTO orderResponseDTO = new OrderResponseDTO();
    orderResponseDTO.setCustomerId(generateRandomString());
    orderResponseDTO.setOrderBooks(Collections.singletonList(orderBook()));
    return orderResponseDTO;
  }
}
