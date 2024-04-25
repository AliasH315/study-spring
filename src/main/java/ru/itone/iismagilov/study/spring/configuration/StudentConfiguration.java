package ru.itone.iismagilov.study.spring.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.itone.iismagilov.study.spring.service.StudentService;
import ru.itone.iismagilov.study.spring.service.impl.StudentServiceImpl;

@Configuration
public class StudentConfiguration {
    @Bean
    public StudentService studentService(){
        return new StudentServiceImpl();
    }
}
