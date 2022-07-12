package com.beanstalk.core.bigtable.entities;

import com.beanstalk.core.bigtable.BeanstalkDataType;
import com.beanstalk.core.bigtable.Family;
import lombok.*;
import org.apache.avro.reflect.Nullable;
import org.apache.beam.sdk.coders.AvroCoder;
import org.apache.beam.sdk.coders.DefaultCoder;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = false)
@DefaultCoder(AvroCoder.class)
public class Identifier extends BeanstalkDataType implements Serializable {

    @Family("Identifier")
    private UUID market;

    @Family("Identifier")
    private UUID competitor;

    @Nullable
    @Family("Identifier")
    private UUID group;

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

}
