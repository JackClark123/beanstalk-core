package com.beanstalk.core.spanner.entities.group;

import com.beanstalk.core.spanner.entities.account.Account;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.joda.time.Instant;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.UUID;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class BetGroupMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type = "uuid-char")
    private UUID id;

    @ManyToOne
    private BetGroup betGroup;

    @Lob
    private String content;

    @ManyToOne
    private Account account;

    @CreationTimestamp
    private Timestamp createdTime;

    @NotNull
    private String type;

    @Transient
    private String trackingId;

}
