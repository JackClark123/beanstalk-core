package com.beanstalk.core.bigtable.entities;

import com.beanstalk.core.bigtable.BeanstalkDataType;
import com.beanstalk.core.bigtable.Family;
import org.apache.beam.sdk.coders.AvroCoder;
import org.apache.beam.sdk.coders.DefaultCoder;

import java.io.Serializable;
import java.util.Objects;

@DefaultCoder(AvroCoder.class)
public class MatchedOrder extends BeanstalkDataType implements Serializable {

    @Family("Back")
    private Order backOrder;

    @Family("Lay")
    private Order layOrder;

    // ======================================= GETTERS AND SETTERS ====================================================

    public Order getBackOrder() {
        return backOrder;
    }

    public void setBackOrder(Order backOrder) {
        this.backOrder = backOrder;
    }

    public Order getLayOrder() {
        return layOrder;
    }

    public void setLayOrder(Order layOrder) {
        this.layOrder = layOrder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MatchedOrder that = (MatchedOrder) o;
        return Objects.equals(backOrder, that.backOrder) && Objects.equals(layOrder, that.layOrder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(backOrder, layOrder);
    }
}
