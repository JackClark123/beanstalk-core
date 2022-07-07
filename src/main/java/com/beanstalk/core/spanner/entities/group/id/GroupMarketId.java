package com.beanstalk.core.spanner.entities.group.id;

import com.beanstalk.core.spanner.entities.account.Account;
import com.beanstalk.core.spanner.entities.group.BetGroup;
import com.beanstalk.core.spanner.entities.market.Market;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@Embeddable
public class GroupMarketId implements Serializable {

    // The primary key columns of the parent entity
    // must be declared first.

    @ManyToOne
    @Type(type = "uuid-char")
    private Market market;

    @ManyToOne
    @JoinColumn(name = "id")
    @Type(type = "uuid-char")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    BetGroup betGroup;

    // Getters and setters
}
