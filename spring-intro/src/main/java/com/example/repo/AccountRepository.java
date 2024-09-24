package com.example.repo;

import com.example.account.Account;

public interface AccountRepository {

    Account findByCreditCard(String creditCardNumber);
    void updateBeneficiaries(Account account);
}
