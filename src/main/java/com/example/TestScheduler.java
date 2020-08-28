package com.example;

import io.micronaut.scheduling.annotation.Scheduled;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * @author spencercjh
 */
@Singleton
@Slf4j
public class TestScheduler {
  @Inject
  private TestRepository testRepository;

  @Scheduled(fixedDelay = "PT15S")
  public void testScheduler() {
    log.debug(testRepository.selectByVin("123456").toString());
  }
}
