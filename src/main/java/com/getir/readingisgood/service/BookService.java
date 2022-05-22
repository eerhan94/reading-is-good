package com.getir.readingisgood.service;

import com.getir.readingisgood.entity.Book;
import com.getir.readingisgood.model.BookCreateDTO;
import com.getir.readingisgood.model.BookResponseDTO;
import com.getir.readingisgood.model.BookStockUpdateDTO;

/**
 * The interface Book service. @Author Eyup Erhan KARAASLAN -
 * eyuperhankaraaslan94@gmail.com @Version 1.0
 */
public interface BookService {
  /**
   * Create book book response dto.
   *
   * @param bookCreateDTO the book create dto
   * @return the book response dto
   */
  BookResponseDTO createBook(BookCreateDTO bookCreateDTO);

  /**
   * Book stock update book response dto.
   *
   * @param bookStockUpdateDTO the book stock update dto
   * @return the book response dto
   */
  BookResponseDTO bookStockUpdate(BookStockUpdateDTO bookStockUpdateDTO);

  /**
   * Gets book by ıd.
   *
   * @param bookId the book ıd
   * @return the book by ıd
   */
  Book getBookById(String bookId);
}
