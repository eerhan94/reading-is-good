package com.getir.readingisgood.entity;

import com.getir.readingisgood.model.OrderBook;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/** The type Order. @Author Eyup Erhan KARAASLAN - eyuperhankaraaslan94@gmail.com @Version 1.0 */
@Document(collection = "Orders")
public class Order {
  @Id private String id;
  private String customerId;
  private Double totalPrice;
  private List<OrderBook> orderBooks = new ArrayList<>();
  @CreatedDate private Date createdAt;
  @LastModifiedDate private Date updatedAt;

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

  /**
   * Gets created at.
   *
   * @return the created at
   */
  public Date getCreatedAt() {
    return createdAt;
  }

  /**
   * Gets updated at.
   *
   * @return the updated at
   */
  public Date getUpdatedAt() {
    return updatedAt;
  }
}
