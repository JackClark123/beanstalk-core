package com.beanstalk.core.spanner.implementation;

import com.beanstalk.core.spanner.entities.account.Salt;
import com.beanstalk.core.spanner.repositories.SaltRepository;
import io.micronaut.transaction.annotation.ReadOnly;
import jakarta.inject.Singleton;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

@Singleton
public class SaltSpannerRepository implements SaltRepository {

    private final EntityManager entityManager;

    public SaltSpannerRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void generate(Salt salt) {
        TypedQuery<Long> query = entityManager.createQuery("SELECT COUNT(s) FROM Salt s", Long.class);
        Long numSalts = query.getSingleResult();
        if (numSalts == 0) {
            entityManager.persist(salt);
        }
    }

    @Override
    @ReadOnly
    public Salt getSalt() {
        TypedQuery<Salt> query = entityManager.createQuery("SELECT s FROM Salt s", Salt.class).setMaxResults(1);
        return query.getResultList().stream().findFirst().orElse(null);
    }
}
