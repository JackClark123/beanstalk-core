package com.beanstalk.core.bigtable.entities;


import com.beanstalk.core.bigtable.BeanstalkDataType;
import com.beanstalk.core.bigtable.Family;
import org.apache.avro.reflect.Nullable;
import org.apache.beam.sdk.coders.AvroCoder;
import org.apache.beam.sdk.coders.DefaultCoder;
import org.joda.time.Instant;

import java.io.Serializable;

@DefaultCoder(AvroCoder.class)
public class Price extends BeanstalkDataType implements Serializable {

    @Nullable
    @Family("Identifier")
    private Identifier identifier;

    @Family("Price")
    private Integer back;

    @Family("Price")
    private Integer lay;

    @Family("Price")
    private Integer price;

    @Family("Price")
    private Integer matched;

    @Nullable
    @Family("Time")
    private Instant processTime;


    // ======================================= GETTERS AND SETTERS ====================================================


    public Integer getBack() {
        return back;
    }

    public void setBack(Integer back) {
        this.back = back;
    }

    public Integer getLay() {
        return lay;
    }

    public void setLay(Integer lay) {
        this.lay = lay;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getMatched() {
        return matched;
    }

    public void setMatched(Integer matched) {
        this.matched = matched;
    }

    public Instant getProcessTime() {
        return processTime;
    }

    public void setProcessTime(Instant processTime) {
        this.processTime = processTime;
    }

    public Identifier getIdentifier() {
        return identifier;
    }

    public void setIdentifier(Identifier identifier) {
        this.identifier = identifier;
    }

}
