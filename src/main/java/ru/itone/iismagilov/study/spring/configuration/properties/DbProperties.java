package ru.itone.iismagilov.study.spring.configuration.properties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ToString
@NoArgsConstructor
@ConfigurationProperties(prefix = "db")
public class DbProperties {
    private String mode;
}
