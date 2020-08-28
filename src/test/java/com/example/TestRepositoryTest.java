package com.example;

import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@MicronautTest
class TestRepositoryTest {
  private final int amount = 5;
  private final String vin = "123456";
  @Inject
  private TestRepository testRepository;

  @Inject
  private DataSource dataSource;

  @BeforeEach
  void setUp() {
    testRepository.beforeSameVinData(amount);
  }

  @Test
  void deleteByVin() {
    assertThrows(RuntimeException.class, () -> testRepository.deleteByVin(vin));
  }

  @AfterEach
  void tearDown() throws SQLException {
    assertEquals(amount, testRepository.selectByVin(vin).size());
    try (final Connection connection = dataSource.getConnection()) {
      connection.prepareStatement("truncate vehicles");
      connection.commit();
    }
  }
}