package com.example.account_service.web;

import com.example.account_service.clients.CustomerRestClient;
import com.example.account_service.entities.BankAccount;
import com.example.account_service.models.Customer;
import com.example.account_service.repositories.BankAccountRepo;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class BankAccountRestController {
    BankAccountRepo bankAccountRepo;
    CustomerRestClient customerRestClient;
    @GetMapping(path = "/accounts")
    public List<BankAccount>accounts()
    {
        List<BankAccount>accounts=bankAccountRepo.findAll();
        accounts.forEach(
                bankAccount -> {
                    bankAccount.setCustomer(customerRestClient.findCustomerById(bankAccount.getCustomerId()));
                }
        );
        return accounts;
    }
    @GetMapping(path = "/account/{id}")

    public BankAccount getAccountById(@PathVariable String id)
    {
        BankAccount bankAccount=bankAccountRepo.findById(id).orElseThrow(()->new RuntimeException("NO BANK ACCOUNT"));
        Customer customer=customerRestClient.findCustomerById(bankAccount.getCustomerId());
        bankAccount.setCustomer(customer);
        return bankAccount;
    }

}
