package com.beanstalk.core.spanner.entities.group;

import com.beanstalk.core.spanner.entities.account.Account;
import com.beanstalk.core.spanner.entities.group.id.GroupMemberId;
import com.google.cloud.spanner.hibernate.Interleaved;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.joda.time.Instant;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Interleaved(parentEntity = BetGroup.class, cascadeDelete = true)
public class BetGroupMember implements Serializable {

    @EmbeddedId
    private GroupMemberId groupMemberId;

    @CreationTimestamp
    private Timestamp addedDate;


}
