package com.beanstalk.core.spanner.repositories;

import com.beanstalk.core.spanner.entities.group.GroupMessage;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.PageableRepository;

import java.util.UUID;

@Repository
public interface GroupMessageRepository extends PageableRepository<GroupMessage, UUID> {
}
