package com.beanstalk.core.spanner.entities.group;

import com.beanstalk.core.spanner.entities.account.Account;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.cloud.spanner.hibernate.Interleaved;
import lombok.*;
import org.hibernate.annotations.Type;
import org.joda.time.Instant;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.UUID;

@Getter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Interleaved(parentEntity = Group.class, cascadeDelete = true)
@IdClass(Invite.InviteId.class)
public class Invite {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type = "uuid-char")
    private UUID id;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @Type(type = "uuid-char")
    private Group group;

    private String email;

    private Instant time;

    private String name;

    @NotNull
    @ManyToOne
    @Type(type = "uuid-char")
    private Account account;

    @ManyToOne
    @Type(type = "uuid-char")
    private Account invitedAccount;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @EqualsAndHashCode
    public static class InviteId implements Serializable {

        // The primary key columns of the parent entity
        // must be declared first.
        Group group;

        @Type(type = "uuid-char")
        UUID id;

        // Getters and setters
    }

}
