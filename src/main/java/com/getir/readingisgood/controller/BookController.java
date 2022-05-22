package com.getir.readingisgood.controller;

import com.getir.readingisgood.model.BookCreateDTO;
import com.getir.readingisgood.model.BookResponseDTO;
import com.getir.readingisgood.model.BookStockUpdateDTO;
import com.getir.readingisgood.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * The type Book controller. @Author Eyup Erhan KARAASLAN - eyuperhankaraaslan94@gmail.com @Version
 * 1.0
 */
@RestController
@RequestMapping(path = "/book")
public class BookController {
  private final BookService bookService;

  /**
   * Instantiates a new Book controller.
   *
   * @param bookService the book service
   */
  @Autowired
  public BookController(BookService bookService) {
    this.bookService = bookService;
  }

  /**
   * Book create response entity.
   *
   * @param bookCreateDTO the book create dto
   * @return the response entity
   */
  @PostMapping()
  public ResponseEntity<BookResponseDTO> bookCreate(
      @Valid @RequestBody BookCreateDTO bookCreateDTO) {
    return ResponseEntity.ok(bookService.createBook(bookCreateDTO));
  }

  /**
   * Book stock update response entity.
   *
   * @param bookStockUpdateDTO the book stock update dto
   * @return the response entity
   */
  @PutMapping
  public ResponseEntity<BookResponseDTO> bookStockUpdate(
      @Valid @RequestBody BookStockUpdateDTO bookStockUpdateDTO) {
    return ResponseEntity.ok(bookService.bookStockUpdate(bookStockUpdateDTO));
  }
}
