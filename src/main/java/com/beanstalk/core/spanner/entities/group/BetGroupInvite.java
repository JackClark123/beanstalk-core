package com.beanstalk.core.spanner.entities.group;

import com.beanstalk.core.spanner.entities.account.PublicAccount;
import com.beanstalk.core.spanner.entities.group.id.GroupInviteId;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.cloud.spanner.hibernate.Interleaved;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Interleaved(parentEntity = BetGroup.class, cascadeDelete = true)
@IdClass(GroupInviteId.class)
public class BetGroupInvite {

    @Id
    private String email;

    @Id
    @ManyToOne
    @JoinColumn(name = "id")
    @Type(type = "uuid-char")
    BetGroup betGroup;

    @CreationTimestamp
    private Timestamp time;

    @NotNull
    @ManyToOne
    private PublicAccount publicAccount;

    @ManyToOne
    private PublicAccount invitedPublicAccount;

}
