package com.beanstalk.core.bigtable;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import com.google.cloud.bigtable.data.v2.models.Row;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class BeanstalkData {

    public static <T> T parse(String value, Class<T> cls) {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JodaModule());

        T object = null;

        try {
            object = objectMapper.readValue(value, cls);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return object;
    }

    public static <T> T parse(Row row, Class<T> cls) {

        if (row == null) return null;

        T object = null;

        try {
            object = cls.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }

        if (object == null) return null;

        if (!(object instanceof BeanstalkDataType)) {
            try {
                throw new Exception("Data type not of type BeanstalkDataType");
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        BeanstalkDataType beanstalkObject = (BeanstalkDataType) object;


        for (Field field : cls.getDeclaredFields()) {
            if (field.isAnnotationPresent(Family.class)) {

                try {
                    Object data = toObject(field.getType(), field, field.getAnnotation(Family.class).value(), row);

                    Method method = null;

                    try {
                        method = cls.getDeclaredMethod("set" + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1), field.getType());
                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    }

                    if (method != null) {
                        try {
                            method.invoke(object, data);
                        } catch (IllegalAccessException | InvocationTargetException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
                    e.printStackTrace();
                }

            }
        }

        ((BeanstalkDataType) object).setKey(row.getKey().toString());

        return object;
    }

    private static Object toObject( Class<?> clazz, Field field, String family, Row row ) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        if( BeanstalkDataType.class.isAssignableFrom(clazz)) return BeanstalkData.parse(row, clazz);

        if (row.getCells(family, field.getName()).isEmpty()) return null;

        String value = row.getCells(family, field.getName()).get(0).getValue().toStringUtf8();

        if( Boolean.class == clazz ) return Boolean.parseBoolean( value );
        if( Byte.class == clazz ) return Byte.parseByte( value );
        if( Short.class == clazz ) return Short.parseShort( value );
        if( Integer.class == clazz ) return Integer.parseInt( value );
        if( Long.class == clazz ) return Long.parseLong( value );
        if( Float.class == clazz ) return Float.parseFloat( value );
        if( Double.class == clazz ) return Double.parseDouble( value );
        if( LocalDate.class == clazz) return LocalDate.parse( value );
        if( LocalDateTime.class == clazz ) return LocalDateTime.parse( value );
        if( org.joda.time.Instant.class == clazz) return org.joda.time.Instant.parse( value );
        return value;
    }

}
