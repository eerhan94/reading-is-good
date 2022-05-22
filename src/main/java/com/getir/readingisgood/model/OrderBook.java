package com.getir.readingisgood.model;

/**
 * The type Order book. @Author Eyup Erhan KARAASLAN - eyuperhankaraaslan94@gmail.com @Version 1.0
 */
public class OrderBook {
  private String bookId;
  private Integer quantity;

  /**
   * Gets book ıd.
   *
   * @return the book ıd
   */
public String getBookId() {
    return bookId;
  }

  /**
   * Sets book ıd.
   *
   * @param bookId the book ıd
   */
public void setBookId(String bookId) {
    this.bookId = bookId;
  }

  /**
   * Gets quantity.
   *
   * @return the quantity
   */
public Integer getQuantity() {
    return quantity;
  }

  /**
   * Sets quantity.
   *
   * @param quantity the quantity
   */
public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  @Override
  public String toString() {
    return "OrderBook{" + "bookId='" + bookId + '\'' + ", quantity=" + quantity + '}';
  }
}
