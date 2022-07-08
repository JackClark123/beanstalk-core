package com.beanstalk.core.spanner.repositories;

import com.beanstalk.core.spanner.entities.account.PublicAccount;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface AccountRepository extends CrudRepository<PublicAccount, UUID> {

    Optional<PublicAccount> findByEmail(@NotNull String email);

    long update(@NonNull @NotNull @Id UUID id, @NonNull @NotBlank String firstName, @NonNull @NotBlank String lastName);

    long updateFirstName(@NonNull @NotNull @Id UUID id, @NonNull @NotBlank String firstName);

    long updateLastName(@NonNull @NotNull @Id UUID id, @NonNull @NotBlank String lastName);

}
