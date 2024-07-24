package ru.itone.iismagilov.study.spring.configuration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import ru.itone.iismagilov.study.spring.dao.StudentDao;
import ru.itone.iismagilov.study.spring.dao.impl.StudentDaoInDBImpl;
import ru.itone.iismagilov.study.spring.dao.impl.StudentDaoInMemoryImpl;
import ru.itone.iismagilov.study.spring.service.StudentService;
import ru.itone.iismagilov.study.spring.service.impl.StudentServiceImpl;

@Configuration
public class StudentConfiguration {

    @Bean
    public StudentService studentService() {
        return new StudentServiceImpl();
    }

    @Bean
    @ConditionalOnProperty(name = "db.mode", havingValue = "in_memory")
    public StudentDao StudentDaoInMemoryImpl() {
        return new StudentDaoInMemoryImpl();
    }

    @Bean
    @ConditionalOnProperty(name = "db.mode", havingValue = "db")
    public StudentDao studentDaoInDBImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        return new StudentDaoInDBImpl(namedParameterJdbcTemplate);
    }
}
