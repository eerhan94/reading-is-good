package com.getir.readingisgood.service;

import com.getir.readingisgood.entity.Book;
import com.getir.readingisgood.model.BookCreateDTO;
import com.getir.readingisgood.model.BookResponseDTO;
import com.getir.readingisgood.model.BookStockUpdateDTO;

/**
 * @Author Eyup Erhan KARAASLAN - eyuperhankaraaslan94@gmail.com
 * @Version 1.0
 */
public interface BookService {
    BookResponseDTO createBook(BookCreateDTO bookCreateDTO);

    BookResponseDTO bookStockUpdate(BookStockUpdateDTO bookStockUpdateDTO);

    Book getBookById(String bookId);
}
