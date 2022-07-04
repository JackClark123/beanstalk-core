package com.beanstalk.core.spanner.repositories;

import com.beanstalk.core.spanner.entities.market.Market;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

import java.util.UUID;

@Repository
public interface MarketRepository extends CrudRepository<Market, UUID> {
}
