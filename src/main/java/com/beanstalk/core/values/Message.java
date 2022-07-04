package com.beanstalk.core.values;

public interface Message {

    String NO_ENOUGH_FUNDS = "Not enough funds to meet liability";

    String INVALID_IDENTIFIER = "Identifier for Create Market not formatted correctly";

    String MARKET_NOT_EXISTS = "Market does not exist: ";

    String MARKET_ALREADY_EXISTS = "Market already exist: ";

    String INVALID_STATE = "Order state not recognized";

    String NO_VOLUME = "Volume not set";

    String INVALID_BET_VOLUME = "Invalid bet volume: ";

    String INVALID_BET_PRICE = "Invalid bet price: ";

    String SUCCESS = "success";

    String IN_ORDER_BOOK = "IN ORDER BOOK";

    String ORDER_CANCELED = "ORDER CANCELLED";

    String MARKET_CREATED = "MARKET CREATED";

    String ORDER_MATCHED = "ORDER MATCHED";

    String TEXT = "TEXT";

    String MARKET_IN_PROGRESS = "MARKET IN PROGRESS NO MORE BETS ALLOWED";

}
