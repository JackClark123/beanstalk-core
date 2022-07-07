package com.beanstalk.core.spanner.entities.group;


import com.beanstalk.core.spanner.entities.group.id.GroupMarketId;
import com.beanstalk.core.spanner.entities.group.id.GroupMemberId;
import com.beanstalk.core.spanner.entities.market.Market;
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

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Interleaved(parentEntity = BetGroup.class, cascadeDelete = true)
public class BetGroupMarket {

    @EmbeddedId
    private GroupMarketId groupMarketId;

    @CreationTimestamp
    private Timestamp createdDate;


}
