package com.getir.readingisgood.model;

/**
 * @Author Eyup Erhan KARAASLAN - eyuperhankaraaslan94@gmail.com
 * @Version 1.0
 */
public class OrderBook {
    private String bookId;
    private Integer quantity;

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
