package com.getir.readingisgood.repository;

import com.getir.readingisgood.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @Author Eyup Erhan KARAASLAN - eyuperhankaraaslan94@gmail.com
 * @Version 1.0
 */
@Repository
public interface OrderRepository extends MongoRepository<Order, String> {
    Page<Order> findByCustomerId(String customerId, Pageable pageable);

    List<Order> findByCreatedAtBetween(Date endDate, Date startDate);
}