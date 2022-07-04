package com.beanstalk.core.values;

import java.util.ArrayList;
import java.util.Arrays;

public interface OrderType {

    Integer BACK = 0;

    Integer LAY = 1;

    Integer BACK_MARKET_ORDER = 2;

    Integer LAY_MARKET_ORDER = 3;

    Integer CREATE = 4;

    Integer COMPLETED = 5;

    Integer IN_PROGRESS = 6;

    Integer CANCEL = 7;

    Integer ERROR = 9;

    Integer REMOVE = 10;

    ArrayList<Integer> validTypes = new ArrayList<>(Arrays.asList(
            BACK,
            LAY,
            BACK_MARKET_ORDER,
            LAY_MARKET_ORDER
    ));

}
