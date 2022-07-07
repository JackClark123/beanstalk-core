package com.beanstalk.core.spanner.repositories;

import com.beanstalk.core.spanner.entities.account.Account;
import com.beanstalk.core.spanner.entities.group.BetGroup;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.UUID;

@Repository
public interface BetGroupRepository extends CrudRepository<BetGroup, UUID> {

    @Query(value = "SELECT * FROM bet_group g JOIN bet_group_member gm ON gm.group_id = g.id WHERE gm.account_id = :member", nativeQuery = true)
    List<BetGroup> findByMember(UUID member);

    boolean existsByOwner(Account account);

    long update(@Id UUID id, @NonNull @NotBlank String name);

}
