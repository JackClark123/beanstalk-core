package com.beanstalk.core.spanner.repositories;

import com.beanstalk.core.spanner.entities.account.Account;
import com.beanstalk.core.spanner.entities.group.Group;
import com.beanstalk.core.spanner.entities.group.GroupMember;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

import java.util.UUID;

@Repository
public interface GroupMemberRepository extends CrudRepository<GroupMember, UUID> {

    boolean existsByGroupAndAccount(Group group, Account account);

    void deleteByGroup(Group group);

}
