package com.workintech.s18d4.service;

import com.workintech.s18d4.entity.Account;

import java.util.List;
import java.util.Optional;

public interface AccountService {
    List<Account> findAll();
    Optional<Account> find(Long id);
    Account createAccount(Account account);
    Account updateAccount(Long id, Account Account);
    void deleteAccount(Long id);
    Account getAccountByCustomerId(Long id);
    Optional<Account>  findAccountById(Long id);
}
