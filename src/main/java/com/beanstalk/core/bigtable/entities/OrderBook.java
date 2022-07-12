package com.beanstalk.core.bigtable.entities;

import com.beanstalk.core.bigtable.BeanstalkDataType;
import com.beanstalk.core.bigtable.Family;
import com.beanstalk.core.values.OrderBookValue;
import com.beanstalk.core.values.OrderType;
import org.apache.avro.reflect.Nullable;
import org.apache.beam.sdk.coders.AvroCoder;
import org.apache.beam.sdk.coders.DefaultCoder;
import org.joda.time.Instant;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Objects;

@DefaultCoder(AvroCoder.class)
public class OrderBook extends BeanstalkDataType implements Serializable {

    public OrderBook() {
        price = new Price();
        price.setBack(OrderBookValue.InitialBack);
        price.setLay(OrderBookValue.InitialLay);
        price.setPrice(0);
        price.setMatched(0);

        book = new HashMap<>();

        matchedOrders = new ArrayList<>();
        state = OrderType.IN_PROGRESS;
        timestamp = Instant.EPOCH;

    }

    @Family("Identifier")
    private Identifier identifier;                      // used as the key for the market

    @Family("Price")
    private Price price;                            // the lowest back bet price

    @Family("Book")
    private HashMap<Integer, LinkedList<Order>> book;     // Stores all bets waiting to be matched

    @Family("Time")
    private Instant timestamp;                          // timestamp when orderbook was last updated

    @Nullable
    private Boolean winner;

    @Nullable
    private MessageOrder messageOrder;

    @Nullable
    private Integer state;// state of the orderbook

    @Nullable
    private ArrayList<MatchedOrder> matchedOrders;     // stores all matched orders for order processing


    // ======================================= GETTERS AND SETTERS ====================================================


    @Override
    public String toString() {
        return "OrderBook{" +
                "identifier=" + identifier +
                ", backBook=" + book +
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

    public HashMap<Integer, LinkedList<Order>> getBook() {
        return book;
    }

    public void setBook(HashMap<Integer, LinkedList<Order>> book) {
        this.book = book;
    }

    public ArrayList<MatchedOrder> getMatchedOrders() {
        return matchedOrders;
    }

    public void setMatchedOrders(ArrayList<MatchedOrder> matchedOrders) {
        this.matchedOrders = matchedOrders;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public MessageOrder getMessageOrder() {
        return messageOrder;
    }

    public void setMessageOrder(MessageOrder messageOrder) {
        this.messageOrder = messageOrder;
    }

    public Boolean getWinner() {
        return winner;
    }

    public void setWinner(Boolean winner) {
        this.winner = winner;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderBook orderBook = (OrderBook) o;
        return Objects.equals(identifier, orderBook.identifier) && Objects.equals(price, orderBook.price) && Objects.equals(book, orderBook.book) && Objects.equals(timestamp, orderBook.timestamp) && Objects.equals(winner, orderBook.winner) && Objects.equals(messageOrder, orderBook.messageOrder) && Objects.equals(state, orderBook.state) && Objects.equals(matchedOrders, orderBook.matchedOrders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identifier, price, book, timestamp, messageOrder, state, matchedOrders);
    }
}
