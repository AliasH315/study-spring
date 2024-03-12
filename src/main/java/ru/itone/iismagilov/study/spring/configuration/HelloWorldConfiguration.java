package ru.itone.iismagilov.study.spring.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.itone.iismagilov.study.spring.service.HelloWorldService;
import ru.itone.iismagilov.study.spring.service.impl.HelloWorldServiceImpl;

@Configuration
public class HelloWorldConfiguration {
    @Bean
    public HelloWorldService helloWorldService(){
        return new HelloWorldServiceImpl();
    }
}
