package com.beanstalk.core.spanner.repositories;


import com.beanstalk.core.spanner.entities.account.Salt;

public interface SaltRepository {

    void generate(Salt salt);

    Salt getSalt();

}
