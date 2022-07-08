package com.beanstalk.core.spanner.repositories;

import com.beanstalk.core.spanner.entities.group.BetGroupInvite;
import com.beanstalk.core.spanner.entities.group.id.GroupInviteId;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

import java.util.UUID;

@Repository
public interface BetGroupInviteRepository extends CrudRepository<BetGroupInvite, GroupInviteId> {



}
