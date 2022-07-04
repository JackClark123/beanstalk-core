package com.beanstalk.core.bigtable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import com.google.bigtable.v2.Mutation;
import com.google.cloud.bigtable.data.v2.models.RowMutation;
import com.google.protobuf.ByteString;
import org.apache.beam.sdk.coders.AvroCoder;
import org.apache.beam.sdk.coders.DefaultCoder;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@DefaultCoder(AvroCoder.class)
public abstract class BeanstalkDataType {

    @JsonIgnore
    private String key;

    @JsonIgnore
    public String getKey() {
        return key;
    }

    @JsonIgnore
    public void setKey(String key) {
        this.key = key;
    }

    public String toJson() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setDateFormat(new StdDateFormat().withColonInTimeZone(true));
        objectMapper.registerModule(new JodaModule());
        objectMapper.enable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        try {
            return objectMapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public RowMutation toMutation(String table, String key, long timestamp) {

        RowMutation rowMutation =
                RowMutation.create(table, key);

        for (Field field : this.getClass().getDeclaredFields()) {

            if (field.isAnnotationPresent(Family.class)) {
                try {

                    if (isNestedObject(field)) {
                        nestedMutations(table, key, timestamp, field, rowMutation);
                    } else {
                        String value = fieldToString(field);

                        if (value != null) {
                            rowMutation
                                    .setCell(field.getAnnotation(Family.class).value(), field.getName(), timestamp, value);
                        }
                    }

                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }

        }

        return rowMutation;
    }

    public RowMutation toMutation(String table, String key, long timestamp, RowMutation rowMutation) {

        for (Field field : this.getClass().getDeclaredFields()) {

            if (field.isAnnotationPresent(Family.class)) {
                try {

                    if (isNestedObject(field)) {
                        nestedMutations(table, key, timestamp, field, rowMutation);
                    } else {
                        String value = fieldToString(field);

                        if (value != null) {
                            rowMutation
                                    .setCell(field.getAnnotation(Family.class).value(), field.getName(), timestamp, value);
                        }

                    }

                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }

        return rowMutation;
    }

    public RowMutation toMutation(String table, String key) {
        return toMutation(table, key, 0L);
    }

    private String methodNameToVariable(String name) {
        name = name.replace("get", "");
        return name.substring(0, 1).toLowerCase() + name.substring(1);
    }

    private boolean isNestedObject(Field field) throws InvocationTargetException, IllegalAccessException {
        field.setAccessible(true);
        Object object = field.get(this);

        if (object == null) {
            return false;
        }

        return object instanceof BeanstalkDataType;
    }

    private RowMutation nestedMutations(String table, String key, long timestamp, Field field, RowMutation rowMutation) throws InvocationTargetException, IllegalAccessException {
        BeanstalkDataType object = (BeanstalkDataType) field.get(this);
        return object.toMutation(table, key, timestamp, rowMutation);
    }

    private List<Mutation> nestedBeamMutations(Field field, long timestamp) throws InvocationTargetException, IllegalAccessException {
        BeanstalkDataType object = (BeanstalkDataType) field.get(this);
        return object.toBeamMutations(timestamp);
    }

    private String fieldToString(Field field) throws InvocationTargetException, IllegalAccessException {
        field.setAccessible(true);
        Object object = field.get(this);

        if (object == null) {
            return null;
        }

        if (Instant.class == field.getType()) return ((Instant) object).toString();
        return object.toString();
    }

    public List<Mutation> toBeamMutations(long timestamp) {
        List<Mutation> mutations = new ArrayList<>();

        for (Field field : this.getClass().getDeclaredFields()) {

            if (field.isAnnotationPresent(Family.class)) {
                try {

                    if (isNestedObject(field)) {
                        mutations.addAll(nestedBeamMutations(field, timestamp));
                    } else {
                        String value = fieldToString(field);

                        if (value != null) {

                            mutations.add(Mutation.newBuilder()
                                    .setSetCell(
                                            Mutation.SetCell.newBuilder()
                                                    .setFamilyName(field.getAnnotation(Family.class).value())
                                                    .setColumnQualifier(ByteString.copyFromUtf8(field.getName()))
                                                    .setValue(ByteString.copyFromUtf8(value))
                                                    .setTimestampMicros(timestamp)
                                    ).build());

                        }
                    }

                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }

        }

        return mutations;
    }

    public List<Mutation> toBeamMutations() {
        return toBeamMutations(0L);
    }

}
