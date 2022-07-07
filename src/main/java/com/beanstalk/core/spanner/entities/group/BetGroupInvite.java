package com.beanstalk.core.spanner.entities.group;

import com.beanstalk.core.spanner.entities.account.Account;
import com.beanstalk.core.spanner.entities.group.id.GroupInviteId;
import com.beanstalk.core.spanner.entities.group.id.GroupMemberId;
import com.google.cloud.spanner.hibernate.Interleaved;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.joda.time.Instant;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Interleaved(parentEntity = BetGroup.class, cascadeDelete = true)
public class BetGroupInvite {

    @EmbeddedId
    private GroupInviteId groupInviteId;

    private String email;

    @CreationTimestamp
    private Timestamp time;

    private String name;

    @NotNull
    @ManyToOne
    private Account account;

    @ManyToOne
    private Account invitedAccount;

}
