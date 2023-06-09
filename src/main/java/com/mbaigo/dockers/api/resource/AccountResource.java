package com.mbaigo.dockers.api.resource;

import com.mbaigo.dockers.api.model.Account;
import com.mbaigo.dockers.api.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

import static com.mbaigo.dockers.api.resource.EmployeeResource.getLocation;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/accounts")
public class AccountResource {
    private final AccountService accountService;

    @PostMapping
    public ResponseEntity<Account> addAccount(@RequestBody Account account){
        Account newAccount = accountService.addAccount(account);
        return ResponseEntity.created(getLocation(newAccount.getId().intValue())).body(newAccount/*accountService.addAccount(account)*/);
    }
    @GetMapping
    public ResponseEntity<List<Account>> getAccounts(){
        return ResponseEntity.ok(accountService.getAccounts());
    }


}
