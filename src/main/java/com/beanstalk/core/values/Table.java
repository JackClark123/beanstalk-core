package com.beanstalk.core.values;

public interface Table {

    // =============== Bigtable instance =============
    String INSTANCE = "emulator";

    // =============== Tables ===============
    String ACCOUNT = "Account";

    String SALT = "Salt";

    String LIVE_ORDER = "LiveOrder";

    String PRICE = "Price";

    String MARKET = "Market";

    String COMPETITOR = "Competitor";

    String PRICE_10M = "PriceMinute";

    String PRICE_1H = "PriceHour";

    String PRICE_1D = "PriceDay";

    String PRICE_1W = "PriceWeek";

    String ORDER_BOOK = "OrderBook";

    String ORDER_WAREHOUSE = "OrderWarehouse";

    String MATCHED_ORDER = "MatchedOrder";

    String PAID_ORDER = "PaidOrder";

    String GROUP = "Group";

    String GROUP_MEMBER = "GroupMember";

    String INVITE = "Invite";

    String GROUP_MESSAGE = "GroupMessage";

    String TOKEN = "Token";

    String GROUP_MARKET = "GroupMarket";

}
