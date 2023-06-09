package com.mbaigo.dockers.api.repository;

import com.mbaigo.dockers.api.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository  extends JpaRepository<Account, Long> {
    Account findByUsername(String username);
}
