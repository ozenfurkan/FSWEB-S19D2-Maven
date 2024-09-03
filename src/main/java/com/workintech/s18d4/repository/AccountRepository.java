package com.workintech.s18d4.repository;

import com.workintech.s18d4.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {


    @Override
    List<Account> findAll();

    @Override
    Optional<Account> findById(Long id);

    @Override
    void deleteById(Long id);

    Account findByAccountName (String accountName);

    Account findByMoneyAmount (String moneyAmount);


}
