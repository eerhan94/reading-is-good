package com.getir.readingisgood.service;

import com.getir.readingisgood.entity.Book;
import com.getir.readingisgood.exception.GlobalApiException;
import com.getir.readingisgood.mapper.BookMapper;
import com.getir.readingisgood.model.BookCreateDTO;
import com.getir.readingisgood.model.BookResponseDTO;
import com.getir.readingisgood.repository.BookRepository;
import com.getir.readingisgood.service.impl.BookServiceImpl;
import com.getir.readingisgood.util.Utils;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

/** @Author Eyup Erhan KARAASLAN - eyuperhankaraaslan94@gmail.com @Version 1.0 */
@RunWith(MockitoJUnitRunner.class)
public class BookServiceTest {

  @InjectMocks private BookServiceImpl bookService;

  @Mock BookRepository bookRepository;

  @Mock BookMapper bookMapper;

  @Rule public ExpectedException expectedException = ExpectedException.none();

  @Test
  public void createBook_shouldBeSuccess() {
    Book book = Utils.createBook();
    when(bookMapper.booCreateToBookEntity(any(BookCreateDTO.class))).thenReturn(book);
    when(bookRepository.findByName(any(String.class))).thenReturn(null);

    when(bookRepository.save(any(Book.class))).thenReturn(book);
    when(bookMapper.bookEntityToBookResponse(any(Book.class))).thenReturn(Utils.bookResponseDTO());
    BookResponseDTO result = bookService.createBook(Utils.bookCreateDTO());
    Assert.assertNotNull(result);
  }

  @Test
  public void createBook_shouldBeError_bookIsExist() {
    expectedException.expect(GlobalApiException.class);
    when(bookMapper.booCreateToBookEntity(any(BookCreateDTO.class))).thenReturn(Utils.createBook());
    when(bookRepository.findByName(any(String.class))).thenReturn(Utils.createBook());
    bookService.createBook(Utils.bookCreateDTO());
  }

  @Test
  public void getBookById_shouldBeSuccess() {
    when(bookRepository.findById(any(String.class)))
        .thenReturn(java.util.Optional.of(Utils.createBook()));
    Book result = bookService.getBookById(Utils.generateRandomString());
    Assert.assertNotNull(result);
  }

  @Test
  public void getBookById_shouldBeError_bookNotFound() {
    expectedException.expect(GlobalApiException.class);
    when(bookRepository.findById(any(String.class)))
        .thenReturn(java.util.Optional.ofNullable(null));
    bookService.getBookById(Utils.generateRandomString());
  }
}
