package com.beanstalk.core.spanner.repositories;

import com.beanstalk.core.spanner.entities.account.PrivateAccount;
import com.beanstalk.core.spanner.entities.account.PublicAccount;
import com.beanstalk.core.spanner.entities.account.id.PrivateAccountId;
import com.beanstalk.core.transit.Account;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PrivateAccountRepository extends CrudRepository<PrivateAccount, PrivateAccountId> {

    Optional<PrivateAccount> findByPublicAccount(PublicAccount publicAccount);

}
