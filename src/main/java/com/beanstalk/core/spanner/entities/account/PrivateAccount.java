package com.beanstalk.core.spanner.entities.account;

import com.beanstalk.core.spanner.entities.account.id.PrivateAccountId;
import com.beanstalk.core.transit.Account;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.cloud.spanner.hibernate.Interleaved;
import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.UUID;

@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Interleaved(parentEntity = PublicAccount.class, cascadeDelete = true)
@IdClass(PrivateAccountId.class)
public class PrivateAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type = "uuid-char")
    UUID privateAccountId;

    @Id
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id")
    @Type(type = "uuid-char")
    PublicAccount publicAccount;

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

    public Account toAccount() {
        return Account.builder()
                .id(publicAccount.getId())
                .firstName(publicAccount.getFirstName())
                .lastName(publicAccount.getLastName())
                .email(publicAccount.getEmail())
                .dob(dob)
                .address(address)
                .balance(balance)
                .build();
    }

    public static PrivateAccount parse(Account account) {
        return PrivateAccount.builder()
                .publicAccount(
                        PublicAccount.builder()
                                .id(account.getId())
                                .firstName(account.getFirstName())
                                .lastName(account.getLastName())
                                .email(account.getEmail())
                                .build()
                )
                .dob(account.getDob())
                .address(account.getAddress())
                .balance(account.getBalance())
                .build();
    }

}
