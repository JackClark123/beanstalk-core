package com.beanstalk.core.spanner.entities.market;


import com.beanstalk.core.bigtable.entities.Price;
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
@Interleaved(parentEntity = Market.class)
@IdClass(Competitor.CompetitorId.class)
public class Competitor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type = "uuid-char")
    private UUID id;

    @Id
    @ManyToOne
    @JoinColumn(name = "market")
    @Type(type = "uuid-char")
    private Market market;

    private String name;

    private String position;

    private Boolean isHome;

    private Boolean isCompeting;

    private String image;

    private Boolean winner;

    @Transient
    private Price price;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode
    public static class CompetitorId implements Serializable {

        // The primary key columns of the parent entity
        // must be declared first.
        @Type(type = "uuid-char")
        Market market;

        @Type(type = "uuid-char")
        UUID id;

        // Getters and setters
    }

}
