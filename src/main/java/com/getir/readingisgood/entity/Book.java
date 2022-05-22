package com.getir.readingisgood.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.Date;

/** The type Book. @Author Eyup Erhan KARAASLAN - eyuperhankaraaslan94@gmail.com @Version 1.0 */
@Document(collection = "Books")
public class Book {
  @Id private String id;
  private String name;
  private Integer quantity;
  private Double price;
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
