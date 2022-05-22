package com.getir.readingisgood.mapper;

import com.getir.readingisgood.entity.Book;
import com.getir.readingisgood.model.BookCreateDTO;
import com.getir.readingisgood.model.BookResponseDTO;
import org.springframework.stereotype.Component;

/**
 * The type Book mapper. @Author Eyup Erhan KARAASLAN - eyuperhankaraaslan94@gmail.com @Version 1.0
 */
@Component
public class BookMapper {
  /**
   * Boo create to book entity book.
   *
   * @param bookCreateDTO the book create dto
   * @return the book
   */
public Book booCreateToBookEntity(BookCreateDTO bookCreateDTO) {
    Book book = new Book();
    book.setName(bookCreateDTO.getName());
    book.setQuantity(bookCreateDTO.getQuantity());
    book.setPrice(bookCreateDTO.getPrice());
    return book;
  }

  /**
   * Book entity to book response book response dto.
   *
   * @param book the book
   * @return the book response dto
   */
public BookResponseDTO bookEntityToBookResponse(Book book) {
    BookResponseDTO bookResponseDTO = new BookResponseDTO();
    bookResponseDTO.setId(book.getId());
    bookResponseDTO.setName(book.getName());
    bookResponseDTO.setQuantity(book.getQuantity());
    bookResponseDTO.setPrice(book.getPrice());
    return bookResponseDTO;
  }
}
