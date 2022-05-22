package com.getir.readingisgood.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The type Order response dto. @Author Eyup Erhan KARAASLAN -
 * eyuperhankaraaslan94@gmail.com @Version 1.0
 */
public class OrderResponseDTO {
  private String id;
  private Date createdAt;
  private String customerId;
  private Double totalPrice;
  private List<OrderBook> orderBooks = new ArrayList<>();

  /**
   * Gets ıd.
   *
   * @return the ıd
   */
public String getId() {
    return id;
  }

  /**
   * Sets ıd.
   *
   * @param id the id
   */
public void setId(String id) {
    this.id = id;
  }

  /**
   * Gets created at.
   *
   * @return the created at
   */
public Date getCreatedAt() {
    return createdAt;
  }

  /**
   * Sets created at.
   *
   * @param createdAt the created at
   */
public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  /**
   * Gets customer ıd.
   *
   * @return the customer ıd
   */
public String getCustomerId() {
    return customerId;
  }

  /**
   * Sets customer ıd.
   *
   * @param customerId the customer ıd
   */
public void setCustomerId(String customerId) {
    this.customerId = customerId;
  }

  /**
   * Gets total price.
   *
   * @return the total price
   */
public Double getTotalPrice() {
    return totalPrice;
  }

  /**
   * Sets total price.
   *
   * @param totalPrice the total price
   */
public void setTotalPrice(Double totalPrice) {
    this.totalPrice = totalPrice;
  }

  /**
   * Gets order books.
   *
   * @return the order books
   */
public List<OrderBook> getOrderBooks() {
    return orderBooks;
  }

  /**
   * Sets order books.
   *
   * @param orderBooks the order books
   */
public void setOrderBooks(List<OrderBook> orderBooks) {
    this.orderBooks = orderBooks;
  }

  @Override
  public String toString() {
    return "OrderResponseDTO{"
        + "id='"
        + id
        + '\''
        + ", createdAt="
        + createdAt
        + ", customerId='"
        + customerId
        + '\''
        + ", totalPrice="
        + totalPrice
        + ", orderBooks="
        + orderBooks
        + '}';
  }
}
