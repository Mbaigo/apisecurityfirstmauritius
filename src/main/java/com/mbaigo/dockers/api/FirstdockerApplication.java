package com.mbaigo.dockers.api;

import com.mbaigo.dockers.api.model.Account;
import com.mbaigo.dockers.api.model.Role;
import com.mbaigo.dockers.api.repository.AccountRepository;
import com.mbaigo.dockers.api.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Arrays.asList;

@SpringBootApplication
@RequiredArgsConstructor
public class FirstdockerApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(FirstdockerApplication.class, args);

	}
	@Autowired
	private final RoleRepository roleRepository;
	@Autowired
	private final AccountRepository accountRepository;

	@Override
	public void run(String... args) throws Exception {
		Role user = new Role(1L, "USER", "ROLE_USER");
		Role admin = new Role(2L, "ADMIN", "ROLE_ADMIN");


	}
}
