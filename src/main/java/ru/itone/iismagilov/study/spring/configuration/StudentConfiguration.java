package ru.itone.iismagilov.study.spring.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.itone.iismagilov.study.spring.dao.StudentDao;
import ru.itone.iismagilov.study.spring.dao.impl.StudentDaoInMemoryImpl;
import ru.itone.iismagilov.study.spring.dto.StudentDto;
import ru.itone.iismagilov.study.spring.service.StudentService;
import ru.itone.iismagilov.study.spring.service.impl.StudentServiceImpl;

@Configuration
public class StudentConfiguration {
    @Bean
    public StudentService studentService(){
        return new StudentServiceImpl();
    }
    @Bean
    public StudentDao studentDao() {return new StudentDaoInMemoryImpl();}
}
