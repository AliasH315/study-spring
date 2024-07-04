package ru.itone.iismagilov.study.spring.service;

import ru.itone.iismagilov.study.spring.dto.StudentDto;

/*
    2) создать интерфейс StudentService с методами по добавлению, удалению, получению данных студента над StudentDto
*/
public interface StudentService {

    StudentDto get(int id);

    StudentDto add(StudentDto studentDto);

    StudentDto delete(int id);

}
