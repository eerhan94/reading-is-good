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
 * @Author Eyup Erhan KARAASLAN - eyuperhankaraaslan94@gmail.com
 * @Version 1.0
 */
@RestController
@RequestMapping(path = "/book")
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping()
    public ResponseEntity<BookResponseDTO> bookCreate(@Valid @RequestBody BookCreateDTO bookCreateDTO) {
        return ResponseEntity.ok(bookService.createBook(bookCreateDTO));
    }

    @PutMapping
    public ResponseEntity<BookResponseDTO> bookStockUpdate(@Valid @RequestBody BookStockUpdateDTO bookStockUpdateDTO) {
        return ResponseEntity.ok(bookService.bookStockUpdate(bookStockUpdateDTO));
    }
}