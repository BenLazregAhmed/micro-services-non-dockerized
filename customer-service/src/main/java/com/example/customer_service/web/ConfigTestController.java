package com.example.customer_service.web;

import com.example.customer_service.config.GlobalConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RefreshScope
public class ConfigTestController {
//    @Value("${global.pram.a}")
//    private int p1;
//    @Value("${global.pram.b}")

    private int p2;
//    @Value("${global.pram.x}")
//
//    private int x;
//    @Value("${global.pram.y}")
//
//    private int y;
    @Autowired
    private GlobalConfig globalConfig;
    @GetMapping(path = "/global/config")

    public GlobalConfig globalConfig()
    {
        return globalConfig;
    }
//    @GetMapping(path = "/config/test")
//    public Map<String ,Integer>configTest()
//    {
//        return Map.of("p1",p1,"p2",p2);
//    }
}
