package com.beanstalk.core.bigtable.entities;

import com.beanstalk.core.bigtable.BeanstalkDataType;
import com.beanstalk.core.bigtable.Family;
import com.beanstalk.core.values.OrderType;
import org.apache.beam.sdk.coders.AvroCoder;
import org.apache.beam.sdk.coders.DefaultCoder;
import org.joda.time.Instant;

import java.io.Serializable;
import java.util.HashMap;

@DefaultCoder(AvroCoder.class)
public class OrderBookSafe extends BeanstalkDataType implements Serializable {

    public OrderBookSafe() {
        book = new HashMap<>();
        state = OrderType.IN_PROGRESS;
    }

    @Family("Identifier")
    private Identifier identifier;                      // used as the key for the market

    @Family("Price")
    private Price price;

    @Family("Order")
    private HashMap<Integer, Integer> book;             // Stores all bets waiting to be matched

    @Family("Time")
    private Instant timestamp;                          // timestamp when orderbook was last updated

    @Family("Order")
    private Integer state;// state of the orderbook


    // ======================================= GETTERS AND SETTERS ====================================================


    @Override
    public String toString() {
        return "OrderBook{" +
                "identifier=" + identifier +
                ", timestamp=" + timestamp +
                '}';
    }

    public Identifier getIdentifier() {
        return identifier;
    }

    public void setIdentifier(Identifier identifier) {
        this.identifier = identifier;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public HashMap<Integer, Integer> getBook() {
        return book;
    }

    public void setBook(HashMap<Integer, Integer> book) {
        this.book = book;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }
}
