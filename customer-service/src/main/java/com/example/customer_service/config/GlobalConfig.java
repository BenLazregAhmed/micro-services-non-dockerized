package com.example.customer_service.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@ConfigurationProperties(prefix = "global.pram")
@Getter@Setter@AllArgsConstructor@NoArgsConstructor
@RefreshScope
public class GlobalConfig {
    private int a;
    private int b;
}
