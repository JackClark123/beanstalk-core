package com.beanstalk.core.spanner.entities.market;


import com.beanstalk.core.bigtable.entities.Price;
import com.beanstalk.core.spanner.entities.market.id.CompetitorId;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.cloud.spanner.hibernate.Interleaved;
import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Interleaved(parentEntity = Market.class, cascadeDelete = true)
@IdClass(CompetitorId.class)
public class Competitor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type = "uuid-char")
    private UUID competitorId;

    @Id
    @ManyToOne
    @JoinColumn(name = "id")
    @Type(type = "uuid-char")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Market market;

    private String name;

    private String position;

    private Boolean isHome;

    private Boolean isCompeting;

    private String image;

    private Boolean winner;

    @Transient
    private Price price;

}
