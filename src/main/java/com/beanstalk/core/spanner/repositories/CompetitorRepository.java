package com.beanstalk.core.spanner.repositories;

import com.beanstalk.core.spanner.entities.market.Competitor;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

import java.util.UUID;

@Repository
public interface CompetitorRepository extends CrudRepository<Competitor, UUID> {
}
