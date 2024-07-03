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
    public StudentEntity get(int id) {
        return studentDao.find(id);
    }

    @Override
    public StudentEntity add(StudentDto studentDto) {
        StudentEntity student = new StudentEntity();
        student.setName(studentDto.getName());
        student.setMiddleName(studentDto.getMiddleName());
        student.setLastName(studentDto.getLastName());
        student.setPassport(studentDto.getPassport());
        return studentDao.save(student);
    }

    @Override
    public StudentEntity delete(int id) {
        return studentDao.delete(id);
    }

}
