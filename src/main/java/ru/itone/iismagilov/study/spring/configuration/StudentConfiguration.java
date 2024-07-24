package ru.itone.iismagilov.study.spring.configuration;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import ru.itone.iismagilov.study.spring.configuration.properties.DbProperties;
import ru.itone.iismagilov.study.spring.dao.StudentDao;
import ru.itone.iismagilov.study.spring.dao.impl.StudentDaoInDBImpl;
import ru.itone.iismagilov.study.spring.dao.impl.StudentDaoInMemoryImpl;
import ru.itone.iismagilov.study.spring.service.StudentService;
import ru.itone.iismagilov.study.spring.service.impl.StudentServiceImpl;

@Configuration
@EnableConfigurationProperties(DbProperties.class)
public class StudentConfiguration {

    @Bean
    public StudentService studentService() {
        return new StudentServiceImpl();
    }

    @Bean
    public StudentDao studentDao(DbProperties dbProperties, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        final String dbMode = dbProperties.getMode();
        if (dbMode == null) {
            throw new IllegalStateException("Отсутствует настройка db.mode");
        }

        return switch (dbMode) {
            case "in_memory" -> new StudentDaoInMemoryImpl();
            case "db" -> new StudentDaoInDBImpl(namedParameterJdbcTemplate);
            default -> throw new IllegalStateException("Некорректное значение настройки db.mode:" + dbMode);
        };
    }
}
