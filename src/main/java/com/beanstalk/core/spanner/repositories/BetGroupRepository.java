package com.beanstalk.core.spanner.repositories;

import com.beanstalk.core.spanner.entities.account.PublicAccount;
import com.beanstalk.core.spanner.entities.group.BetGroup;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface BetGroupRepository extends CrudRepository<BetGroup, UUID> {

    @Query("SELECT b FROM BetGroup b JOIN b.memberList m WHERE m.publicAccount = :publicAccount")
    List<BetGroup> findByMember(PublicAccount publicAccount);

    boolean existsByOwner(PublicAccount publicAccount);

    Optional<BetGroup> findByOwnerAndId(PublicAccount owner, UUID id);

    long update(@Id UUID id, @NonNull @NotBlank String name);

}
