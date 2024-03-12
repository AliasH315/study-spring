package ru.itone.iismagilov.study.spring.service.impl;

import ru.itone.iismagilov.study.spring.service.HelloWorldService;

public class HelloWorldServiceImpl implements HelloWorldService {
    @Override
    public String getHelloWorldText() {
        return "Hello World!";
    }
}
