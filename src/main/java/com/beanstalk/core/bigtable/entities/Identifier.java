package com.beanstalk.core.bigtable.entities;

import com.beanstalk.core.bigtable.BeanstalkDataType;
import com.beanstalk.core.bigtable.Family;
import org.apache.avro.reflect.Nullable;
import org.apache.beam.sdk.coders.AvroCoder;
import org.apache.beam.sdk.coders.DefaultCoder;

import java.io.Serializable;
import java.util.Objects;

@DefaultCoder(AvroCoder.class)
public class Identifier extends BeanstalkDataType implements Serializable {

    @Family("Identifier")
    private Long market;

    @Family("Identifier")
    private Long competitor;

    @Nullable
    @Family("Identifier")
    private Long group;

    // ======================================= GETTERS AND SETTERS ====================================================

    public static Identifier create(Long market) {
        Identifier identifier = new Identifier();
        identifier.setMarket(market);
        return identifier;
    }

    public static Identifier createGroup(Long market, Long group) {
        Identifier identifier = new Identifier();
        identifier.setMarket(market);
        identifier.setGroup(group);
        return identifier;
    }

    public static Identifier create(Long market, Long competitor) {
        Identifier identifier = new Identifier();
        identifier.setMarket(market);
        identifier.setCompetitor(competitor);
        return identifier;
    }

    public static Identifier createGroup(Long market, Long competitor, Long group) {
        Identifier identifier = new Identifier();
        identifier.setMarket(market);
        identifier.setCompetitor(competitor);
        identifier.setGroup(group);
        return identifier;
    }

    public Long getMarket() {
        return market;
    }

    public void setMarket(Long market) {
        this.market = market;
    }

    public Long getCompetitor() {
        return competitor;
    }

    public void setCompetitor(Long competitor) {
        this.competitor = competitor;
    }

    public Long getGroup() {
        return group;
    }

    public void setGroup(Long group) {
        this.group = group;
    }

    public String keyBuilder() {
        String key = "";

        if (market != null) {
            key += market.toString();
        }

        if (competitor != null) {
            key += "#" + competitor.toString();
        }

        if (group != null) {
            key += "#" + group.toString();
        }

        return key;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Identifier that = (Identifier) o;
        return Objects.equals(market, that.market) && Objects.equals(competitor, that.competitor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(market, competitor);
    }

}
