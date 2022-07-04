package com.beanstalk.core.spanner.entities.group;

import com.beanstalk.core.spanner.entities.account.Account;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.cloud.spanner.hibernate.Interleaved;
import lombok.*;
import org.hibernate.annotations.Type;
import org.joda.time.Instant;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Getter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Interleaved(parentEntity = Group.class, cascadeDelete = true)
@IdClass(GroupMember.GroupMemberId.class)
public class GroupMember {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group")
    @Type(type = "uuid-char")
    private Group group;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account")
    @Type(type = "uuid-char")
    private Account account;

    private Instant addedDate;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @EqualsAndHashCode
    public static class GroupMemberId implements Serializable {

        // The primary key columns of the parent entity
        // must be declared first.
        @Type(type = "uuid-char")
        Group group;

        @Type(type = "uuid-char")
        Account account;

        // Getters and setters
    }

}
