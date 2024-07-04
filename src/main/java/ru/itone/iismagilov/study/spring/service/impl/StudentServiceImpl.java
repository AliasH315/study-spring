package ru.itone.iismagilov.study.spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import ru.itone.iismagilov.study.spring.dao.StudentDao;
import ru.itone.iismagilov.study.spring.dao.entity.StudentEntity;
import ru.itone.iismagilov.study.spring.dao.impl.StudentDaoInMemoryImpl;
import ru.itone.iismagilov.study.spring.dto.StudentDto;
import ru.itone.iismagilov.study.spring.service.StudentService;

/*
    3) реализовать интерфейс StudentService с методами по добавлению, удалению, получению данных студента над StudentDto
 */
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public StudentDto get(int id) {
        StudentEntity studentEntity = studentDao.find(id);
        StudentDto studentDto = new StudentDto();
        studentDto.setName(studentEntity.getName());
        studentDto.setMiddleName(studentEntity.getMiddleName());
        studentDto.setLastName(studentEntity.getLastName());
        studentDto.setPassport(studentEntity.getPassport());
        return studentDto;
    }

    @Override
    public StudentDto add(StudentDto studentDto) {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setName(studentDto.getName());
        studentEntity.setMiddleName(studentDto.getMiddleName());
        studentEntity.setLastName(studentDto.getLastName());
        studentEntity.setPassport(studentDto.getPassport());
        studentDao.save(studentEntity);
        return studentDto;
    }

    @Override
    public StudentDto delete(int id) {
        StudentEntity studentEntity = studentDao.delete(id);
        StudentDto studentDto = new StudentDto();
        studentDto.setName(studentEntity.getName());
        studentDto.setMiddleName(studentEntity.getMiddleName());
        studentDto.setLastName(studentEntity.getLastName());
        studentDto.setPassport(studentEntity.getPassport());
        return studentDto;
    }

}
