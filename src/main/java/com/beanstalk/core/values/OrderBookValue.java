package com.beanstalk.core.values;

public interface OrderBookValue {

    Integer MinPrice = 101;

    Integer MaxPrice = 100000;

    Integer InitialBack = OrderBookValue.MaxPrice;

    Integer InitialLay = OrderBookValue.MinPrice;

    Integer MinVolume = 500;

    String MarketManagerAccount = "007";

}
