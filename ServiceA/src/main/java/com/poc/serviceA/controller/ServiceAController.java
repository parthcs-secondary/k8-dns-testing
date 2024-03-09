package com.poc.serviceA.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "/service-a")
public class ServiceAController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/call-service-b")
    public String callServiceB() {
        String variableFromServiceB = restTemplate.getForObject("http://service-b:8081/service-b/get-variable-from-b", String.class);
        return "Variable from Service B: " + variableFromServiceB;
    }

    @GetMapping("/get-variable-from-a")
    public String getVariableFromServiceA() {
        String variable = "***I am Service A****";
        return variable;
    }
}
