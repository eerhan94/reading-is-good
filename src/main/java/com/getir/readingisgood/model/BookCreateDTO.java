package com.getir.readingisgood.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * The type Book create dto. @Author Eyup Erhan KARAASLAN - eyuperhankaraaslan94@gmail.com @Version
 * 1.0
 */
public class BookCreateDTO {
  @NotEmpty(message = "Please provide a name")
  private String name;

  @NotNull(message = "Please provide a quantity")
  private Integer quantity;

  @NotNull(message = "Please provide a price")
  private Double price;

  /**
   * Gets name.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Sets name.
   *
   * @param name the name
   */
  public void setName(String name) {
    this.name = name;
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

  /**
   * Gets price.
   *
   * @return the price
   */
  public Double getPrice() {
    return price;
  }

  /**
   * Sets price.
   *
   * @param price the price
   */
  public void setPrice(Double price) {
    this.price = price;
  }

  @Override
  public String toString() {
    return "BookCreateDTO{"
        + "name='"
        + name
        + '\''
        + ", quantity="
        + quantity
        + ", price="
        + price
        + '}';
  }
}
