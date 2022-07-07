package com.beanstalk.core.spanner.entities.market;


import com.beanstalk.core.bigtable.entities.Price;
import com.beanstalk.core.spanner.entities.market.id.CompetitorId;
import com.google.cloud.spanner.hibernate.Interleaved;
import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Getter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Interleaved(parentEntity = Market.class, cascadeDelete = true)
public class Competitor implements Serializable {

    @EmbeddedId
    CompetitorId competitorId;

    private String name;

    private String position;

    private Boolean isHome;

    private Boolean isCompeting;

    private String image;

    private Boolean winner;

    @Transient
    private Price price;

}
