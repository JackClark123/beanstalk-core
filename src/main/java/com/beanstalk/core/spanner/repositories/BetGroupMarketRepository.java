package com.beanstalk.core.spanner.repositories;

import com.beanstalk.core.spanner.entities.group.BetGroupMarket;
import com.beanstalk.core.spanner.entities.group.id.GroupMarketId;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

import java.util.UUID;

@Repository
public interface BetGroupMarketRepository extends CrudRepository<BetGroupMarket, GroupMarketId> {
}
