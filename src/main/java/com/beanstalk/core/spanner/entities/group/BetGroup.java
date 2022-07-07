package com.beanstalk.core.spanner.entities.group;

import com.beanstalk.core.spanner.entities.account.Account;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.joda.time.Instant;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
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
    private Account owner;

    @NotNull
    private String name;

    @CreationTimestamp
    private Timestamp createdDate;

    @OneToMany(mappedBy = "groupMemberId.betGroup", fetch = FetchType.EAGER)
    private List<BetGroupMember> memberList;


}
