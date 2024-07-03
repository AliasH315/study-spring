package ru.itone.iismagilov.study.spring.dao.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class StudentEntity {
    private int id;
    private String name;
    private String lastName;
    private String middleName;
    private int age;
    private String passport;
    private String address;
}

