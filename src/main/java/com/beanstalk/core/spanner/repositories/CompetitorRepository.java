package com.beanstalk.core.spanner.repositories;

import com.beanstalk.core.spanner.entities.market.Competitor;
import com.beanstalk.core.spanner.entities.market.id.CompetitorId;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

import java.util.UUID;

@Repository
public interface CompetitorRepository extends CrudRepository<Competitor, CompetitorId> {
}