package com.beanstalk.core.spanner.repositories;

import com.beanstalk.core.spanner.entities.account.PrivateAccount;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PrivateAccountRepository extends CrudRepository<PrivateAccount, UUID> {

    Optional<PrivateAccount> findByEmail(@NotNull String email);

    long update(@NonNull @NotNull @Id UUID id, @NonNull @NotBlank String firstName, @NonNull @NotBlank String lastName);

}
