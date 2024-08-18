package com.example.account_service.clients;

import com.example.account_service.models.Customer;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerRestClient {
    @GetMapping(path = "/customer/{id}")
    @CircuitBreaker(name = "customerService",fallbackMethod = "getDefaultCustomer")
    Customer findCustomerById(@PathVariable Long id);
    @CircuitBreaker(name = "customerService",fallbackMethod = "getDefaultAllCustomer")

    @GetMapping("/customers")
    List<Customer> allCustomers();
    default Customer getDefaultCustomer(Long id,Exception e){
        return Customer.builder()
                .id(id)
                .email("notFound@404.com")
                .firstName("unavailable")
                .lastName("404")
                .build();
    }
    default List<Customer>getDefaultAllCustomer(Exception e)
    {
        return List.of();
    }
}
