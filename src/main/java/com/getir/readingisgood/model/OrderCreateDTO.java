package com.getir.readingisgood.model;

import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * @Author Eyup Erhan KARAASLAN - eyuperhankaraaslan94@gmail.com
 * @Version 1.0
 */
public class OrderCreateDTO {
    private String customerId;
    @NotEmpty(message = "Please provide books")
    private List<OrderBook> books;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public List<OrderBook> getBooks() {
        return books;
    }

    public void setBooks(List<OrderBook> books) {
        this.books = books;
    }
}
