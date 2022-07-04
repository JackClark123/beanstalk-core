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
import java.util.List;
import java.util.UUID;

@Getter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type = "uuid-char")
    private UUID id;

    @ManyToOne
    @Type(type = "uuid-char")
    private Account owner;

    @NotNull
    private String name;

    @NotNull
    private Instant createdDate;

    @OneToMany(mappedBy = "group")
    private List<GroupMember> memberList;

    @OneToMany(mappedBy = "group")
    private List<GroupMarket> openMarkets;

}
