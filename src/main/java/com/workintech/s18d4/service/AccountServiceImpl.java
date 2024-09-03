package com.workintech.s18d4.service;

import com.workintech.s18d4.entity.Account;
import com.workintech.s18d4.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }


    @Override
    public List<Account> findAll() {
       return accountRepository.findAll();
    }

    @Override
    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Optional<Account> find(Long id) {
        return accountRepository.findById(id);
    }

    @Override

    public Account updateAccount(Long id, Account account) {
        if (!accountRepository.existsById(id)) {
            throw new RuntimeException("Account not found");
        }
        account.setId(id);
        account.setAccountName(account.getAccountName());
        account.setCustomer(account.getCustomer());
        account.setMoneyAmount(account.getMoneyAmount());
        return accountRepository.save(account);
    }

    @Override
    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }

    @Override
    public Account getAccountByCustomerId(Long id) {
        return accountRepository.getReferenceById(id);
    }

    @Override
    public  Optional<Account>  findAccountById(Long id) {
        return accountRepository.findById(id);
    }
}
