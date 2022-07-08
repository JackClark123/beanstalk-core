package com.beanstalk.core.transit;

import com.beanstalk.core.spanner.entities.account.PrivateAccount;
import com.beanstalk.core.spanner.entities.account.PublicAccount;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Nullable;
import lombok.*;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Account {

    @Nullable
    private UUID id;

    @Nullable
    private String firstName;

    @Nullable
    private String lastName;

    @Nullable
    private String email;

    @Nullable
    private Date dob;

    @Nullable
    private String address;

    @Nullable
    private Integer balance;

    @Nullable
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

}
