package com.beanstalk.core.bigtable.entities;

import com.beanstalk.core.bigtable.BeanstalkDataType;
import com.beanstalk.core.bigtable.Family;
import org.apache.beam.sdk.coders.AvroCoder;
import org.apache.beam.sdk.coders.DefaultCoder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@DefaultCoder(AvroCoder.class)
public class MatchedBook extends BeanstalkDataType {

    public MatchedBook() {
        book = new HashMap<>();
        paidOrders = new ArrayList<>();
    }

    @Family("Book")
    private HashMap<String, LinkedList<Order>> book;

    private List<Order> paidOrders;

    // ======================================= GETTERS AND SETTERS ====================================================

    public HashMap<String, LinkedList<Order>> getBook() {
        return book;
    }

    public void setBook(HashMap<String, LinkedList<Order>> book) {
        this.book = book;
    }

    public List<Order> getPaidOrders() {
        return paidOrders;
    }

    public void setPaidOrders(List<Order> paidOrders) {
        this.paidOrders = paidOrders;
    }
}
