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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;

/**
 * The type Book service. @Author Eyup Erhan KARAASLAN - eyuperhankaraaslan94@gmail.com @Version 1.0
 */
@Service
public class BookServiceImpl implements BookService {
  Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);
  private final BookRepository bookRepository;
  private final BookMapper bookMapper;

  /**
   * Instantiates a new Book service.
   *
   * @param bookRepository the book repository
   * @param bookMapper the book mapper
   */
  @Autowired
  public BookServiceImpl(BookRepository bookRepository, BookMapper bookMapper) {
    this.bookRepository = bookRepository;
    this.bookMapper = bookMapper;
  }

  @Transactional
  @Override
  public BookResponseDTO createBook(BookCreateDTO bookCreateDTO) {
    logger.info("BookServiceImpl-createBook starting -> bookCreateDTO:{}", bookCreateDTO);
    Book book = bookMapper.booCreateToBookEntity(bookCreateDTO);
    if (Objects.nonNull(bookRepository.findByName(bookCreateDTO.getName()))) {
      logger.info(
          "BookServiceImpl-createBook -> Error message:{}",
          ErrorCodes.BOOK_NAME_ALREADY_EXIST.getMessage());
      throw new GlobalApiException(ErrorCodes.BOOK_NAME_ALREADY_EXIST);
    }
    return bookMapper.bookEntityToBookResponse(bookRepository.save(book));
  }

  @Transactional
  @Override
  public BookResponseDTO bookStockUpdate(BookStockUpdateDTO bookStockUpdateDTO) {
    logger.info(
        "BookServiceImpl-bookStockUpdate starting -> bookStockUpdateDTO:{}", bookStockUpdateDTO);
    Optional<Book> bookOptional = bookRepository.findById(bookStockUpdateDTO.getId());
    if (bookOptional.isPresent()) {
      Book book = bookOptional.get();
      book.setQuantity(bookStockUpdateDTO.getQuantity());
      return bookMapper.bookEntityToBookResponse(bookRepository.save(book));
    } else {
      logger.info(
          "BookServiceImpl-createBook -> Error message:{}", ErrorCodes.BOOK_NOT_FOUND.getMessage());
      throw new GlobalApiException(ErrorCodes.BOOK_NOT_FOUND);
    }
  }

  @Override
  public Book getBookById(String bookId) {
    logger.info("BookServiceImpl-getBookById starting -> bookId:{}", bookId);
    Optional<Book> book = bookRepository.findById(bookId);
    if (book.isPresent()) {
      return book.get();
    } else {
      logger.info(
          "BookServiceImpl-createBook -> Error message:{}", ErrorCodes.BOOK_NOT_FOUND.getMessage());
      throw new GlobalApiException(ErrorCodes.BOOK_NOT_FOUND);
    }
  }
}
