package com.getir.readingisgood.service.impl;

import com.getir.readingisgood.entity.Book;
import com.getir.readingisgood.exception.ErrorCodes;
import com.getir.readingisgood.exception.GlobalApiException;
import com.getir.readingisgood.mapper.BookMapper;
import com.getir.readingisgood.model.BookCreateDTO;
import com.getir.readingisgood.model.BookResponseDTO;
import com.getir.readingisgood.model.BookStockUpdateDTO;
import com.getir.readingisgood.repository.BookRepository;
import com.getir.readingisgood.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @Author Eyup Erhan KARAASLAN - eyuperhankaraaslan94@gmail.com
 * @Version 1.0
 */
@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    @Override
    public BookResponseDTO createBook(BookCreateDTO bookCreateDTO) {
        Book book = bookMapper.booCreateToBookEntity(bookCreateDTO);
        return bookMapper.bookEntityToBookResponse(bookRepository.save(book));
    }

    @Override
    public BookResponseDTO bookStockUpdate(BookStockUpdateDTO bookStockUpdateDTO) {
        Optional<Book> bookOptional = bookRepository.findById(bookStockUpdateDTO.getId());
        if (bookOptional.isPresent()) {
            Book book = bookOptional.get();
            book.setQuantity(bookStockUpdateDTO.getQuantity());
            return bookMapper.bookEntityToBookResponse(bookRepository.save(book));
        } else {
            throw new GlobalApiException(ErrorCodes.BOOK_NOT_FOUND);
        }
    }

    @Override
    public Book getBookById(String bookId) {
        Optional<Book> book = bookRepository.findById(bookId);
        if (book.isPresent()) {
            return book.get();
        } else {
            throw new GlobalApiException(ErrorCodes.BOOK_NOT_FOUND);
        }
    }
}
