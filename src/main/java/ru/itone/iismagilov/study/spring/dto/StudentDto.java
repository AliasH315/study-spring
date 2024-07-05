package ru.itone.iismagilov.study.spring.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class StudentDto {
    private int id;
    private String name;
    private String lastName;
    private String middleName;
    private String passport;
}
