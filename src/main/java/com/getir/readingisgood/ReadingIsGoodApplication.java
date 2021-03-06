package com.getir.readingisgood;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/** The type Reading ıs good application. */
@SpringBootApplication
@EnableMongoRepositories
@EnableMongoAuditing
@EnableSwagger2
public class ReadingIsGoodApplication {

  /**
   * The entry point of application.
   *
   * @param args the input arguments
   */
  public static void main(String[] args) {
    SpringApplication.run(ReadingIsGoodApplication.class, args);
  }
}
