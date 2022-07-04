package com.beanstalk.core.bigtable.entities;

import com.beanstalk.core.bigtable.BeanstalkDataType;
import com.beanstalk.core.bigtable.Family;
import org.apache.beam.sdk.coders.AvroCoder;
import org.apache.beam.sdk.coders.DefaultCoder;
import org.joda.time.Instant;

import java.io.Serializable;

@DefaultCoder(AvroCoder.class)
public class OrderBookPrice extends BeanstalkDataType implements Serializable {

    public static OrderBookPrice create(Integer price, Integer volume, Integer type) {
        OrderBookPrice orderBookPrice = new OrderBookPrice();
        orderBookPrice.setPrice(price);
        orderBookPrice.setVolume(volume);
        orderBookPrice.setType(type);
        return orderBookPrice;
    }

    @Family("Price")
    private Integer price;

    @Family("Price")
    private Integer volume;

    @Family("Price")
    private Integer type;

    @Family("Time")
    private Instant processTime;


    // ======================================= GETTERS AND SETTERS ====================================================


    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Instant getProcessTime() {
        return processTime;
    }

    public void setProcessTime(Instant processTime) {
        this.processTime = processTime;
    }
}
