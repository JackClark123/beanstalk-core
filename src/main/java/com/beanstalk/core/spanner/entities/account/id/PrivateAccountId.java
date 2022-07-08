package com.beanstalk.core.spanner.entities.account.id;

import com.beanstalk.core.spanner.entities.account.PublicAccount;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class PrivateAccountId implements Serializable {

    @Type(type = "uuid-char")
    UUID privateAccountId;

    @OneToOne
    @JoinColumn(name = "id")
    @Type(type = "uuid-char")
    PublicAccount publicAccount;

}
