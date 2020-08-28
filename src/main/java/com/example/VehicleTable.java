package com.example;

import org.jooq.Field;
import org.jooq.Record;
import org.jooq.Table;

import java.util.UUID;

import static com.example.UUIDConverter.UUID_DATA_TYPE;
import static org.jooq.impl.DSL.*;

/**
 * @author Jiahao Cai
 */
public final class VehicleTable {
  public final static Table<Record> TABLE_NAME = table("vehicles");

  public final static Field<UUID> FIELD_ID =
    field(name("id"), UUID_DATA_TYPE);
  public final static Field<String> FIELD_NAME =
    field(name("name"), String.class);
  public final static Field<String> FIELD_VIN =
    field(name("vin"), String.class);
}
