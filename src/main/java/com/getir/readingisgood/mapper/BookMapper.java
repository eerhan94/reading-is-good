package com.getir.readingisgood.mapper;

import com.getir.readingisgood.entity.Book;
import com.getir.readingisgood.model.BookCreateDTO;
import com.getir.readingisgood.model.BookResponseDTO;
import org.springframework.stereotype.Component;

/**
 * @Author Eyup Erhan KARAASLAN - eyuperhankaraaslan94@gmail.com
 * @Version 1.0
 */
@Component
public class BookMapper {
    public Book booCreateToBookEntity(BookCreateDTO bookCreateDTO) {
        Book book = new Book();
        book.setName(bookCreateDTO.getName());
        book.setQuantity(bookCreateDTO.getQuantity());
        book.setPrice(bookCreateDTO.getPrice());
        return book;
    }

    public BookResponseDTO bookEntityToBookResponse(Book book) {
        BookResponseDTO bookResponseDTO = new BookResponseDTO();
        bookResponseDTO.setId(book.getId());
        bookResponseDTO.setName(book.getName());
        bookResponseDTO.setQuantity(book.getQuantity());
        bookResponseDTO.setPrice(book.getPrice());
        return bookResponseDTO;
    }
}
