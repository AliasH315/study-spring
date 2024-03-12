package ru.itone.iismagilov.study.spring.service.impl;

import org.springframework.stereotype.Service;
import ru.itone.iismagilov.study.spring.service.HelloWorldService;
@Service
public class HelloWorldServiceImpl implements HelloWorldService {
    @Override
    public String getHelloWorldText() {
        return "Hello World!";
    }
}
