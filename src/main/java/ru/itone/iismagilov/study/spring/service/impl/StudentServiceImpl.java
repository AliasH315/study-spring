package ru.itone.iismagilov.study.spring.service.impl;

import ru.itone.iismagilov.study.spring.dao.entity.StudentEntity;
import ru.itone.iismagilov.study.spring.dao.impl.StudentDaoInMemoryImpl;
import ru.itone.iismagilov.study.spring.dto.StudentDto;
import ru.itone.iismagilov.study.spring.service.StudentService;

/*
    3) реализовать интерфейс StudentService с методами по добавлению, удалению, получению данных студента над StudentDto
 */
public class StudentServiceImpl implements StudentService {
    @Override
    public StudentEntity get(int id) {
        return new StudentDaoInMemoryImpl().find(id);
    }

    @Override
    public StudentEntity add(StudentDto studentDto) {
        StudentEntity student = new StudentEntity();
        student.setName(studentDto.getName());
        student.setMiddleName(studentDto.getMiddleName());
        student.setLastName(studentDto.getLastName());
        student.setPassport(studentDto.getPassport());
        return new StudentDaoInMemoryImpl().save(student);
    }

    @Override
    public StudentEntity delete(int id) {
        return new StudentDaoInMemoryImpl().delete(id);
    }

}
