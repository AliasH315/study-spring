package ru.itone.iismagilov.study.spring.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import ru.itone.iismagilov.study.spring.dao.StudentDao;
import ru.itone.iismagilov.study.spring.dao.impl.StudentDaoInDBImpl;
import ru.itone.iismagilov.study.spring.dao.impl.StudentDaoInMemoryImpl;
import ru.itone.iismagilov.study.spring.dao.impl.StudentDaoRouterImpl;
import ru.itone.iismagilov.study.spring.service.StudentService;
import ru.itone.iismagilov.study.spring.service.impl.StudentServiceImpl;

@Configuration
public class StudentConfiguration {

    @Bean
    public StudentService studentService() {
        return new StudentServiceImpl();
    }

    @Bean
    @Primary
    public StudentDao studentDao(@Qualifier("studentDaoInMemoryImpl") StudentDao studentDaoInMemory,
                                 @Qualifier("studentDaoInDBImpl") StudentDao studentDaoInDb) {
        return new StudentDaoRouterImpl(studentDaoInMemory, studentDaoInDb);
    }

    @Bean
    public StudentDao studentDaoInMemoryImpl() {
        return new StudentDaoInMemoryImpl();
    }

    @Bean
    public StudentDao studentDaoInDBImpl(NamedParameterJdbcTemplate jdbcTemplate) {
        return new StudentDaoInDBImpl(jdbcTemplate);
    }
}
