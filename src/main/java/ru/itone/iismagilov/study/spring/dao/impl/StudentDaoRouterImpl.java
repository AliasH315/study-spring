package ru.itone.iismagilov.study.spring.dao.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import ru.itone.iismagilov.study.spring.dao.StudentDao;
import ru.itone.iismagilov.study.spring.dao.entity.StudentEntity;

import java.util.Random;

public class StudentDaoRouterImpl implements StudentDao {
    private final StudentDao studentDaoInMemory;
    private final StudentDao studentDaoInDb;

    public StudentDaoRouterImpl(
            StudentDao studentDaoInMemory,
            StudentDao studentDaoInDb) {
        this.studentDaoInMemory = studentDaoInMemory;
        this.studentDaoInDb = studentDaoInDb;
    }

    @Override
    public StudentEntity save(StudentEntity studentEntity) {
        return chooseStudentDao().save(studentEntity);
    }

    @Override
    public StudentEntity find(int id) {
        return chooseStudentDao().find(id);
    }

    @Override
    public StudentEntity update(StudentEntity studentEntity) {
        return chooseStudentDao().update(studentEntity);
    }

    @Override
    public StudentEntity delete(int id) {
        return chooseStudentDao().delete(id);
    }

    private StudentDao chooseStudentDao() {
        if (new Random().nextBoolean()) {
            return studentDaoInMemory;
        } else {
            return studentDaoInDb;
        }
    }
}
