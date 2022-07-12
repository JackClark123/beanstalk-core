package com.beanstalk.core.bigtable.entities;


import com.beanstalk.core.bigtable.BeanstalkDataType;
import com.beanstalk.core.bigtable.Family;
import lombok.*;
import org.apache.avro.reflect.Nullable;
import org.apache.beam.sdk.coders.AvroCoder;
import org.apache.beam.sdk.coders.DefaultCoder;
import org.joda.time.Instant;

import java.io.Serializable;
import java.sql.Timestamp;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@DefaultCoder(AvroCoder.class)
public class Price extends BeanstalkDataType implements Serializable {

    @Nullable
    @Family("Identifier")
    private Identifier identifier;

    @Family("Price")
    private Integer back;

    @Family("Price")
    private Integer lay;

    @Family("Price")
    private Integer price;

    @Family("Price")
    private Integer matched;

    @Nullable
    @Family("Time")
    private Timestamp processTime;

}
