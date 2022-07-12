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
public class Order extends BeanstalkDataType implements Serializable {

    @Nullable
    @Family("Order")
    private Long id;

    @Family("Order")
    private Integer price;

    @Family("Order")
    private Integer volume;

    @Family("Order")
    private String accountID;

    @Family("Order")
    private Integer type;

    @Family("Time")
    private Instant dateTime;

    @Family("Identifier")
    private Identifier identifier;

    @Nullable
    @Family("Payout")
    private Payout payout;

    @Nullable
    @Family("Order")
    private Boolean winner;

    // ======================================= GETTERS AND SETTERS ====================================================


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Instant getDateTime() {
        return dateTime;
    }

    public void setDateTime(Instant dateTime) {
        this.dateTime = dateTime;
    }

    public Identifier getIdentifier() {
        return identifier;
    }

    public void setIdentifier(Identifier identifier) {
        this.identifier = identifier;
    }

    public Payout getPayout() {
        return payout;
    }

    public void setPayout(Payout payout) {
        this.payout = payout;
    }

    public Boolean getWinner() {
        return winner;
    }

    public void setWinner(Boolean winner) {
        this.winner = winner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id) && Objects.equals(price, order.price) && Objects.equals(volume, order.volume) && Objects.equals(accountID, order.accountID) && Objects.equals(type, order.type) && Objects.equals(dateTime, order.dateTime) && Objects.equals(identifier, order.identifier) && Objects.equals(payout, order.payout) && Objects.equals(winner, order.winner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, volume, accountID, type, dateTime, identifier, payout, winner);
    }
}
