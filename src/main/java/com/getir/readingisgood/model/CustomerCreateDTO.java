package com.getir.readingisgood.model;

import javax.validation.constraints.NotEmpty;

/**
 * @Author Eyup Erhan KARAASLAN - eyuperhankaraaslan94@gmail.com
 * @Version 1.0
 */
public class CustomerCreateDTO {
    @NotEmpty(message = "Please provide a name")
    private String name;

    @NotEmpty(message = "Please provide a surname")
    private String surname;

    @NotEmpty(message = "Please provide a email")
    private String email;

    @NotEmpty(message = "Please provide a phone")
    private String phone;

    @NotEmpty(message = "Please provide a address")
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
