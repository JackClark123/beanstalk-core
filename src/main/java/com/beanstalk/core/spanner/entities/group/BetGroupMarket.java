package com.beanstalk.core.spanner.entities.group;


import com.beanstalk.core.spanner.entities.group.id.GroupMarketId;
import com.beanstalk.core.spanner.entities.market.Market;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.cloud.spanner.hibernate.Interleaved;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.joda.time.Instant;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Interleaved(parentEntity = BetGroup.class, cascadeDelete = true)
@IdClass(GroupMarketId.class)
public class BetGroupMarket {

    @Id
    @ManyToOne
    @Type(type = "uuid-char")
    private Market market;

    @Id
    @ManyToOne
    @JoinColumn(name = "id")
    @Type(type = "uuid-char")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    BetGroup betGroup;

    @CreationTimestamp
    private Timestamp createdDate;


}
