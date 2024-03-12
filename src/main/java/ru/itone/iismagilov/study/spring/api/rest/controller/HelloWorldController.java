package ru.itone.iismagilov.study.spring.api.rest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

public interface HelloWorldController {
    @GetMapping(value = "/hello")
    ResponseEntity<String> getHelloWorldText();

}
