package com.getir.readingisgood.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * The type Book stock update dto. @Author Eyup Erhan KARAASLAN -
 * eyuperhankaraaslan94@gmail.com @Version 1.0
 */
public class BookStockUpdateDTO {
  @NotEmpty(message = "Please provide a id")
  private String id;

  @NotNull(message = "Please provide a quantity")
  private Integer quantity;

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
    return "BookStockUpdateDTO{" + "id='" + id + '\'' + ", quantity=" + quantity + '}';
  }
}
