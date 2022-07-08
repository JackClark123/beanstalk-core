package com.beanstalk.core.spanner.repositories;

import com.beanstalk.core.spanner.entities.account.PublicAccount;
import com.beanstalk.core.spanner.entities.group.BetGroup;
import com.beanstalk.core.spanner.entities.group.BetGroupMember;
import com.beanstalk.core.spanner.entities.group.id.GroupMemberId;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;


@Repository
public interface BetGroupMemberRepository extends CrudRepository<BetGroupMember, GroupMemberId> {

    boolean existsByBetGroupAndPublicAccount(BetGroup betGroup, PublicAccount publicAccount);

    void deleteByBetGroup(BetGroup betGroup);

}
