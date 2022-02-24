package com.example.repository;


import com.example.model.Account;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Slf4j
@Repository("jpaAccountRepository")
@Qualifier("jpa")
public class JpaAccountRepository implements AccountRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Account loadAccount(String number){
        log.info("loading account-"+number);
        //....
        return entityManager.find(Account.class,number);
    }

    public void updateAccount(Account account){
        log.info("updating account-"+account.getNumber());
        //...
        entityManager.merge(account);
        return;
    }

}
