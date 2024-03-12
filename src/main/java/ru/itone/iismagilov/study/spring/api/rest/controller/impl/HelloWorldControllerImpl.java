package ru.itone.iismagilov.study.spring.api.rest.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.itone.iismagilov.study.spring.api.rest.controller.HelloWorldController;
import ru.itone.iismagilov.study.spring.service.HelloWorldService;

@RestController
public class HelloWorldControllerImpl implements HelloWorldController {
    @Autowired
    private HelloWorldService helloWorldService;
    @Override
    public ResponseEntity<String> getHelloWorldText() {
        return ResponseEntity.ok(helloWorldService.getHelloWorldText());
    }
}
