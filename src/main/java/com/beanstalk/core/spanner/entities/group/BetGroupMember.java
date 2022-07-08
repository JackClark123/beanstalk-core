package com.beanstalk.core.spanner.entities.group;

import com.beanstalk.core.spanner.entities.account.PublicAccount;
import com.beanstalk.core.spanner.entities.group.id.GroupMemberId;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.cloud.spanner.hibernate.Interleaved;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Interleaved(parentEntity = BetGroup.class, cascadeDelete = true)
@IdClass(GroupMemberId.class)
public class BetGroupMember implements Serializable {

    @Id
    @ManyToOne
    @Type(type = "uuid-char")
    PublicAccount publicAccount;

    @Id
    @ManyToOne
    @JoinColumn(name = "id")
    @Type(type = "uuid-char")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    BetGroup betGroup;

    @CreationTimestamp
    private Timestamp addedDate;

}
