package com.beanstalk.core.spanner.entities.market.id;

import com.beanstalk.core.spanner.entities.group.BetGroup;
import com.beanstalk.core.spanner.entities.market.Market;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@Embeddable
public class CompetitorId implements Serializable {

    // The primary key columns of the parent entity
    // must be declared first.

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type = "uuid-char")
    private UUID competitorId;

    @ManyToOne
    @JoinColumn(name = "id")
    @Type(type = "uuid-char")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Market market;

    // Getters and setters
}
