package com.beanstalk.core.spanner.repositories;

import com.beanstalk.core.spanner.entities.group.GroupMarket;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

import java.util.UUID;

@Repository
public interface GroupMarketRepository extends CrudRepository<GroupMarket, UUID> {
}
