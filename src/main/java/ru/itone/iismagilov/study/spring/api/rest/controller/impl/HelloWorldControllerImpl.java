package ru.itone.iismagilov.study.spring.api.rest.controller.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.itone.iismagilov.study.spring.api.rest.controller.HelloWorldController;
@RestController
public class HelloWorldControllerImpl implements HelloWorldController {
    @Override
    public ResponseEntity<String> getHelloWorldText() {
        return ResponseEntity.ok("Hello World");
    }
}
