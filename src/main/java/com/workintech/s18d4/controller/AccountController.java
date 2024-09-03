package com.workintech.s18d4.controller;

import com.workintech.s18d4.entity.Account;
import com.workintech.s18d4.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    private AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public List<Account> getAllAccounts(){
        return accountService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Account> getAccountById(Long id){
        return accountService.findAccountById(id);
    }

    @PutMapping ("/{customerId}")
    public Account getAccountByCustomerId(@PathVariable Long customerId){
        return accountService.getAccountByCustomerId(customerId);
    }

    @DeleteMapping("/{id}")
    public void deleteAccountById(Long id){
         accountService.deleteAccount(id);
    }

}
