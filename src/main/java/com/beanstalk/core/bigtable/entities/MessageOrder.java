package com.beanstalk.core.bigtable.entities;

import com.beanstalk.core.bigtable.BeanstalkDataType;
import com.beanstalk.core.bigtable.Family;
import org.apache.beam.sdk.coders.AvroCoder;
import org.apache.beam.sdk.coders.DefaultCoder;

import java.io.Serializable;
import java.util.Objects;

@DefaultCoder(AvroCoder.class)
public class MessageOrder extends BeanstalkDataType implements Serializable {

    public MessageOrder() {

    }

    public MessageOrder(Order order, String message) {
        this.order = order;
        this.message = message;
    }

    @Family("Order")
    private Order order;

    @Family("Message")
    private String message;

    // ======================================= GETTERS AND SETTERS ====================================================

    public Order getOrder() {
        return order;
    }

    public String getMessage() {
        return message;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageOrder that = (MessageOrder) o;
        return Objects.equals(order, that.order) && Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(order, message);
    }

}
