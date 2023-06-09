package com.mbaigo.dockers.api.service.impl;

import com.mbaigo.dockers.api.model.Account;
import com.mbaigo.dockers.api.model.Role;
import com.mbaigo.dockers.api.repository.AccountRepository;
import com.mbaigo.dockers.api.repository.RoleRepository;
import com.mbaigo.dockers.api.service.AccountService;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    private final RoleRepository roleRepository;
   // private final PasswordEncoder encoder;

    public AccountServiceImpl(AccountRepository accountRepository, RoleRepository roleRepository/*, PasswordEncoder encoder*/) {
        this.accountRepository = accountRepository;
        this.roleRepository = roleRepository;
       // this.encoder = encoder;
    }

    @Override
    public Account addAccount(Account account) {
        //recuperer et crypter le password
       // account.setPassword(encoder.encode(account.getPassword()));
        //recuperer le role par défaut dans la base de donnees
        Role role = roleRepository.findByName("ROLE_USER");
        //lister les roles a attribuer au user
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        //associer la liste des roles au user
        account.setRoles(roles);
        return accountRepository.save(account);
    }

    @Override
    public Account findByUsername(String username) {
        return accountRepository.findByUsername(username);
    }

    @Override
    public List<Account> getAccounts() {
        return accountRepository.findAll();
    }
}
