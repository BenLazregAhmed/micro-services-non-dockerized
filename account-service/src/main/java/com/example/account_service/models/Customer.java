package com.example.account_service.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter@Builder
public class Customer {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
