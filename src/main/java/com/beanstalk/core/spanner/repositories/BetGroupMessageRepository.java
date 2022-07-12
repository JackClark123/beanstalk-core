package com.beanstalk.core.spanner.repositories;


import com.beanstalk.core.spanner.entities.group.BetGroup;
import com.beanstalk.core.spanner.entities.group.BetGroupMessage;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.model.Pageable;
import io.micronaut.data.repository.PageableRepository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BetGroupMessageRepository extends PageableRepository<BetGroupMessage, UUID> {

    List<BetGroupMessage> findByBetGroupOrderByCreatedTimeDesc(BetGroup betGroup, Pageable pageable);

}
