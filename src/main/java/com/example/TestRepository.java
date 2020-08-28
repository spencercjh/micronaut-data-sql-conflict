package com.example;

import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.transaction.Transactional;
import java.util.UUID;

import static com.example.VehicleTable.*;

/**
 * @author spencercjh
 */
@Singleton
public class TestRepository {
  @Inject
  private DSLContext dslContext;

  @Transactional
  public void deleteByVin(String vin) {
    final int rows = dslContext.deleteFrom(TABLE_NAME).where(FIELD_VIN.eq(vin)).execute();
    if (rows > 1) {
      throw new RuntimeException("Delete more than one row by vin: " + vin);
    }
  }

  public void beforeSameVinData(int amount) {
    final String vin = "123456";
    for (int i = 0; i < amount; i++) {
      final UUID id = UUID.randomUUID();
      dslContext.insertInto(TABLE_NAME).set(FIELD_ID, id)
        .set(FIELD_VIN, vin)
        .set(FIELD_NAME, "vehicles/" + vin)
        .execute();
    }
  }

//  @ReadOnly
  public Result<Record> selectByVin(String vin) {
    return dslContext.selectFrom(TABLE_NAME).where(FIELD_VIN.eq(vin)).fetch();
  }
}
