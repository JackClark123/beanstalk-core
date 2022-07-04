package com.beanstalk.core.bigtable.entities;

import com.beanstalk.core.bigtable.BeanstalkDataType;
import com.beanstalk.core.bigtable.Family;
import org.apache.avro.reflect.Nullable;
import org.apache.beam.sdk.coders.AvroCoder;
import org.apache.beam.sdk.coders.DefaultCoder;
import org.joda.time.Instant;

import java.io.Serializable;
import java.util.Objects;

@DefaultCoder(AvroCoder.class)
public class Payout extends BeanstalkDataType implements Serializable {

    @Nullable
    @Family("Payout")
    private Boolean paid = false;

    @Nullable
    @Family("Payout")
    private Boolean partial = false;

    @Nullable
    @Family("Payout")
    private Integer amount = 0;

    @Nullable
    @Family("Payout")
    private Instant dateTime;

    // ======================================= GETTERS AND SETTERS ====================================================


    public static Payout initValues() {
        Payout payout = new Payout();
        payout.setPaid(false);
        payout.setPartial(false);
        return payout;
    }

    public static Payout fullPayout() {
        Payout payout = new Payout();
        payout.setPaid(true);
        return payout;
    }

    public static Payout partialPayout(int amount) {
        Payout payout = new Payout();
        payout.setPartial(true);
        payout.setAmount(amount);
        return payout;
    }

    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }

    public Boolean getPartial() {
        return partial;
    }

    public void setPartial(Boolean partial) {
        this.partial = partial;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Instant getDateTime() {
        return dateTime;
    }

    public void setDateTime(Instant dateTime) {
        this.dateTime = dateTime;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payout payout = (Payout) o;
        return Objects.equals(paid, payout.paid) && Objects.equals(partial, payout.partial) && Objects.equals(amount, payout.amount) && Objects.equals(dateTime, payout.dateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paid, partial, amount, dateTime);
    }
}
