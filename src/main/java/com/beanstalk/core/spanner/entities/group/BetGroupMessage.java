package com.beanstalk.core.spanner.entities.group;

import com.beanstalk.core.spanner.entities.account.PublicAccount;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class BetGroupMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type = "uuid-char")
    private UUID id;

    @NotNull
    @ManyToOne
    private BetGroup betGroup;

    @Lob
    private String content;

    @NotNull
    @ManyToOne
    private PublicAccount publicAccount;

    @CreationTimestamp
    private Timestamp createdTime;

    @NotNull
    private String type;

    @Transient
    private UUID trackingId;

}
