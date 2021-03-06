package com.beanstalk.core.spanner.entities.group.id;

import com.beanstalk.core.spanner.entities.account.PublicAccount;
import com.beanstalk.core.spanner.entities.group.BetGroup;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@Embeddable
public class GroupMemberId implements Serializable {

    // The primary key columns of the parent entity
    // must be declared first.

    @ManyToOne
    @Type(type = "uuid-char")
    PublicAccount publicAccount;

    @ManyToOne
    @JoinColumn(name = "id")
    @Type(type = "uuid-char")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    BetGroup betGroup;

    // Getters and setters
}
