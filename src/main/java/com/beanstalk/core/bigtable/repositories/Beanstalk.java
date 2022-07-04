package com.beanstalk.core.bigtable.repositories;


import com.beanstalk.core.bigtable.BeanstalkData;
import com.beanstalk.core.bigtable.entities.Identifier;
import com.beanstalk.core.bigtable.entities.Price;
import com.beanstalk.core.values.Table;
import com.google.api.gax.rpc.NotFoundException;
import com.google.cloud.bigtable.data.v2.BigtableDataClient;

public class Beanstalk {

    public static Price price(BigtableDataClient dataClient, Identifier identifier) {

        try {
            return BeanstalkData.parse(dataClient.readRow(Table.PRICE, identifier.keyBuilder()), Price.class);
        } catch (NotFoundException e) {
            System.err.println("Failed to read from a non-existent table: " + e.getMessage());
        }

        return null;
    }

}
