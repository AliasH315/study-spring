package ru.itone.iismagilov.study.spring.service;

import ru.itone.iismagilov.study.spring.dao.entity.StudentEntity;
import ru.itone.iismagilov.study.spring.dto.StudentDto;

/*
    2) создать интерфейс StudentService с методами по добавлению, удалению, получению данных студента над StudentDto
*/
public interface StudentService {

    StudentEntity get(int id);

    StudentEntity add(StudentDto studentDto);

    StudentEntity delete(int id);

}
