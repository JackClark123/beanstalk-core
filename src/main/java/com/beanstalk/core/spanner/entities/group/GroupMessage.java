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
public class GroupMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type = "uuid-char")
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group")
    @Type(type = "uuid-char")
    private Group group;

    @Lob
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @Type(type = "uuid-char")
    private Account account;

    @NotNull
    private Instant time;

    @NotNull
    private String type;

    @Transient
    private String trackingId;

}
