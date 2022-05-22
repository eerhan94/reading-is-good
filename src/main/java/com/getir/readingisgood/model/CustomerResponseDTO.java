package com.getir.readingisgood.model;

/**
 * The type Customer response dto. @Author Eyup Erhan KARAASLAN -
 * eyuperhankaraaslan94@gmail.com @Version 1.0
 */
public class CustomerResponseDTO {
  private String id;
  private String name;
  private String surname;
  private String email;
  private String phone;
  private String address;

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
   * Gets surname.
   *
   * @return the surname
   */
  public String getSurname() {
    return surname;
  }

  /**
   * Sets surname.
   *
   * @param surname the surname
   */
  public void setSurname(String surname) {
    this.surname = surname;
  }

  /**
   * Gets email.
   *
   * @return the email
   */
  public String getEmail() {
    return email;
  }

  /**
   * Sets email.
   *
   * @param email the email
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * Gets phone.
   *
   * @return the phone
   */
  public String getPhone() {
    return phone;
  }

  /**
   * Sets phone.
   *
   * @param phone the phone
   */
  public void setPhone(String phone) {
    this.phone = phone;
  }

  /**
   * Gets address.
   *
   * @return the address
   */
  public String getAddress() {
    return address;
  }

  /**
   * Sets address.
   *
   * @param address the address
   */
  public void setAddress(String address) {
    this.address = address;
  }

  @Override
  public String toString() {
    return "CustomerResponseDTO{"
        + "id='"
        + id
        + '\''
        + ", name='"
        + name
        + '\''
        + ", surname='"
        + surname
        + '\''
        + ", email='"
        + email
        + '\''
        + ", phone='"
        + phone
        + '\''
        + ", address='"
        + address
        + '\''
        + '}';
  }
}
