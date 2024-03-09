package com.poc.ServiceB.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "/service-b")
public class ServiceBController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/call-service-a")
    public String callServiceA() {
        String variableFromServiceA = restTemplate.getForObject("http://service-a:8080/get-variable-from-a", String.class);
        return "Variable from Service A: " + variableFromServiceA;
    }

    @GetMapping("/get-variable-from-b")
    public String getVariableFromServiceB() {
        String variable = "Variable from Service B";
        return variable;
    }
}