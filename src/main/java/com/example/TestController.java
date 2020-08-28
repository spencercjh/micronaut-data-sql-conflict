package com.example;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import org.jooq.Record;

import javax.inject.Inject;
import java.util.List;

/**
 * @author spencercjh
 */
@Controller
public class TestController {
  @Inject
  private TestRepository testRepository;

  @Get("/delete/123456")
  public List<Record> test() {
    testRepository.deleteByVin("123456");
    return testRepository.selectByVin("123456");
  }

  @Get("/create/5")
  public int create() {
    testRepository.beforeSameVinData(5);
    return testRepository.selectByVin("123456").size();
  }
}
