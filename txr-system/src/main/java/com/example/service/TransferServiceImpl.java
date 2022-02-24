package com.example.service;


import com.example.model.Account;
import com.example.repository.AccountRepository;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

@Data
@Slf4j
@Service("transferService")
@Scope("singleton")
public class TransferServiceImpl implements TransferService {

    private final AccountRepository accountRepository;

    private String txrType;

    public TransferServiceImpl(@Qualifier("jpa") AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @PostConstruct
    public void init(){
        log.info("transferService:init()");
    }

    @Override
    @Transactional(
            transactionManager = "transactionManager"
    )
    public void transfer(double amount, String sourceAccNumber, String targetAccNumber){

//        log.info("transfer initiated..");

        Account sourceAccount=accountRepository.loadAccount(sourceAccNumber);
        Account targetAccount=accountRepository.loadAccount(targetAccNumber);

        System.out.println(sourceAccount);
        System.out.println(targetAccount);

        log.info("debit & credit");
        sourceAccount.setBalance(sourceAccount.getBalance()-amount);
        targetAccount.setBalance(targetAccount.getBalance()+amount);

        accountRepository.updateAccount(sourceAccount);
        accountRepository.updateAccount(targetAccount);

//        log.info("transfer finished..");

    }

}
