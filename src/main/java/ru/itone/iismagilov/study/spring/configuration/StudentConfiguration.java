package ru.itone.iismagilov.study.spring.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import ru.itone.iismagilov.study.spring.dao.StudentDao;
import ru.itone.iismagilov.study.spring.dao.impl.StudentDaoInDBImpl;
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

    //public StudentDao studentDao() {return new StudentDaoInMemoryImpl();}
    @Bean
    public StudentDao studentDao(NamedParameterJdbcTemplate jdbcTemplate) {
        return new StudentDaoInDBImpl(jdbcTemplate);
    }
}
