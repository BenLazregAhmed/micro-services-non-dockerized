package com.example.account_service;

import com.example.account_service.clients.CustomerRestClient;
import com.example.account_service.entities.BankAccount;
import com.example.account_service.enums.AccountType;
import com.example.account_service.repositories.BankAccountRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class AccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(BankAccountRepo bankAccountRepo, CustomerRestClient customerRestClient)
	{
		return args -> {
			customerRestClient.allCustomers().forEach(
					(customer -> {
						BankAccount b1= BankAccount.builder()
								.accountId(UUID.randomUUID().toString())
								.type(AccountType.SAVING_ACCOUNT)
								.createdAt(LocalDate.now())
								.currency("Dinar")
								.solde(Math.random()*41578)
								.customerId(customer.getId())
								.build();
						BankAccount b2= BankAccount.builder()
								.accountId(UUID.randomUUID().toString())
								.type(AccountType.CURRENT_ACCOUNT)
								.createdAt(LocalDate.now())
								.currency("Dinar")
								.solde(Math.random()*5478)
								.customerId(customer.getId())
								.build();
						bankAccountRepo.save(b1);
						bankAccountRepo.save(b2);
					})
			);

		};
	}
}
