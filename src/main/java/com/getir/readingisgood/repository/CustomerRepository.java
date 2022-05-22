package com.getir.readingisgood.repository;

import com.getir.readingisgood.entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Customer repository. @Author Eyup Erhan KARAASLAN -
 * eyuperhankaraaslan94@gmail.com @Version 1.0
 */
@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {
  /**
   * Find by email customer.
   *
   * @param email the email
   * @return the customer
   */
Customer findByEmail(String email);

  /**
   * Find by phone customer.
   *
   * @param phone the phone
   * @return the customer
   */
Customer findByPhone(String phone);
}
