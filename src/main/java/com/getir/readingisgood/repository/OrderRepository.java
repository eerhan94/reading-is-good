package com.getir.readingisgood.repository;

import com.getir.readingisgood.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * The interface Order repository. @Author Eyup Erhan KARAASLAN -
 * eyuperhankaraaslan94@gmail.com @Version 1.0
 */
@Repository
public interface OrderRepository extends MongoRepository<Order, String> {
  /**
   * Find by customer ıd page.
   *
   * @param customerId the customer ıd
   * @param pageable the pageable
   * @return the page
   */
  Page<Order> findByCustomerId(String customerId, Pageable pageable);

  /**
   * Find by customer ıd.
   *
   * @param customerId the customer ıd
   * @return list
   */
  List<Order> findAllByCustomerId(String customerId);

  /**
   * Find by created at between list.
   *
   * @param endDate the end date
   * @param startDate the start date
   * @return the list
   */
  List<Order> findByCreatedAtBetween(Date endDate, Date startDate);
}
