package com.bank.bankaccountms.repository;

import com.bank.bankaccountms.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
