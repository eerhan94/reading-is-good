package com.getir.readingisgood.model;

import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * The type Order create dto. @Author Eyup Erhan KARAASLAN - eyuperhankaraaslan94@gmail.com @Version
 * 1.0
 */
public class OrderCreateDTO {
  private String customerId;

  @NotEmpty(message = "Please provide books")
  private List<OrderBook> books;

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
   * Gets books.
   *
   * @return the books
   */
  public List<OrderBook> getBooks() {
    return books;
  }

  /**
   * Sets books.
   *
   * @param books the books
   */
  public void setBooks(List<OrderBook> books) {
    this.books = books;
  }
}
