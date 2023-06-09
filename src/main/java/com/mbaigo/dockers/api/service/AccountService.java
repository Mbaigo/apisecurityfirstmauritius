package com.mbaigo.dockers.api.service;

import com.mbaigo.dockers.api.model.Account;

import java.util.List;

public interface AccountService {
    Account addAccount(Account account);
    Account findByUsername(String username);
    List<Account> getAccounts();

}
