package com.getir.readingisgood.repository;

import com.getir.readingisgood.entity.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * The interface Book repository. @Author Eyup Erhan KARAASLAN -
 * eyuperhankaraaslan94@gmail.com @Version 1.0
 */
public interface BookRepository extends MongoRepository<Book, String> {
  /**
   * Find by name book.
   *
   * @param name the name
   * @return the book
   */
  Book findByName(String name);
}
