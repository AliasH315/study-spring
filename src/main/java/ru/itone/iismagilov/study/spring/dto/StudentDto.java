package ru.itone.iismagilov.study.spring.dto;

import lombok.Getter;
import lombok.Setter;
/*
    1) создать dto - StudentDto
 */
@Getter
@Setter
public class StudentDto {
    private String name;
    private String lastName;
    private String middleName;
    private String passport;
}
