package com.beanstalk.core.spanner.entities.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PrivateAccount extends Account {

    @NotNull
    private Date dob;

    @NotNull
    private String address;

    @NotNull
    private Integer balance;

    private String refreshToken;

    private Boolean revoked;

    @NotNull
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

}
