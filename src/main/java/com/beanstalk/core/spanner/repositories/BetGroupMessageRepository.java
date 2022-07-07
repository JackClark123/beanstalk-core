package com.beanstalk.core.spanner.repositories;


import com.beanstalk.core.spanner.entities.group.BetGroupMessage;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.PageableRepository;

import java.util.UUID;

@Repository
public interface BetGroupMessageRepository extends PageableRepository<BetGroupMessage, UUID> {
}
