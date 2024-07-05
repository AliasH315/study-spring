package ru.itone.iismagilov.study.spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import ru.itone.iismagilov.study.spring.dao.StudentDao;
import ru.itone.iismagilov.study.spring.dao.entity.StudentEntity;
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
        if (studentEntity != null) {
            StudentDto studentDto = new StudentDto();
            studentDto.setId(studentEntity.getId());
            studentDto.setName(studentEntity.getName());
            studentDto.setMiddleName(studentEntity.getMiddleName());
            studentDto.setLastName(studentEntity.getLastName());
            studentDto.setPassport(studentEntity.getPassport());
            return studentDto;
        } else {
            return null;
        }

    }

    /*
   Добавить в StudentDto id. То есть метод add должен вернуть данные по добавленному студенту с id.
    тест следующий:
    1) добавить студента
    2) по id добавленного студента, получить его данные

    В итоге, метод add должен возвращать id, по которому мы можем из get получить данные добавленного студента
    */
    @Override
    public StudentDto add(StudentDto studentDto) {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setName(studentDto.getName());
        studentEntity.setMiddleName(studentDto.getMiddleName());
        studentEntity.setLastName(studentDto.getLastName());
        studentEntity.setPassport(studentDto.getPassport());
        studentDao.save(studentEntity);
        studentDto.setId(studentEntity.getId());
        return studentDto;
    }

    @Override
    public StudentDto delete(int id) {
        StudentEntity studentEntity = studentDao.delete(id);
        StudentDto studentDto = new StudentDto();
        if (studentEntity != null) {
            studentDto.setId(studentEntity.getId());
            studentDto.setName(studentEntity.getName());
            studentDto.setMiddleName(studentEntity.getMiddleName());
            studentDto.setLastName(studentEntity.getLastName());
            studentDto.setPassport(studentEntity.getPassport());
            return studentDto;
        } else {
            return null;
        }

    }

}
