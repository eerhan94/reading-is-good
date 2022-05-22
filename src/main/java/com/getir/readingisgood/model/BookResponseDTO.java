package com.getir.readingisgood.model;

/**
 * The type Book response dto. @Author Eyup Erhan KARAASLAN -
 * eyuperhankaraaslan94@gmail.com @Version 1.0
 */
public class BookResponseDTO {
  private String id;
  private String name;
  private Integer quantity;
  private Double price;

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
    return "BookResponseDTO{"
        + "id='"
        + id
        + '\''
        + ", name='"
        + name
        + '\''
        + ", quantity="
        + quantity
        + ", price="
        + price
        + '}';
  }
}
