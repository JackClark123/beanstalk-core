package com.beanstalk.core.spanner.entities.group;

import com.beanstalk.core.spanner.entities.account.PublicAccount;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.*;

@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class BetGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type = "uuid-char")
    private UUID id;

    @ManyToOne
    private PublicAccount owner;

    @NotNull
    private String name;

    @CreationTimestamp
    private Timestamp createdDate;

    @OneToMany(mappedBy = "betGroup", fetch = FetchType.EAGER)
    private Set<BetGroupMember> memberList;

}
