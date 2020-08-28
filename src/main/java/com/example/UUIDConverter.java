package com.example;

import io.micronaut.core.util.StringUtils;
import org.jooq.Converter;
import org.jooq.DataType;
import org.jooq.impl.SQLDataType;

import javax.inject.Singleton;
import java.util.UUID;

/**
 * @author Jihao cai
 */
@Singleton
public class UUIDConverter implements Converter<String, UUID> {
  public static final DataType<UUID> UUID_DATA_TYPE = SQLDataType.VARCHAR.asConvertedDataType(new UUIDConverter());

  @Override
  public UUID from(String uuidString) {
    if (StringUtils.isEmpty(uuidString)) {
      return null;
    }
    return UUID.fromString(uuidString);
  }

  @Override
  public String to(UUID uuid) {
    if (uuid == null) {
      return "";
    }
    return uuid.toString();
  }

  @Override
  public Class<String> fromType() {
    return String.class;
  }

  @Override
  public Class<UUID> toType() {
    return UUID.class;
  }
}
