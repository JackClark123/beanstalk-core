package com.beanstalk.core.spanner.repositories;

import com.beanstalk.core.spanner.entities.account.Account;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

import java.util.UUID;

@Repository
public interface AccountRepository extends CrudRepository<Account, UUID> {
}
