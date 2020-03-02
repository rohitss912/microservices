package com.boot.microservices.limitsservice;

import com.boot.microservices.limitsservice.bean.LimitConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsConfigurationController {

    @Autowired
    Configuration configuration;

    @GetMapping("/limits")
    public LimitConfiguration retrieveLimitsFromConfig(){
        return new LimitConfiguration(configuration.getMinimum(), configuration.getMaximum());
    }


}
