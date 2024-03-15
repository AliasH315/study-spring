package ru.itone.iismagilov.study.spring.dao;

import ru.itone.iismagilov.study.spring.dao.entity.StudentEntity;

public interface StudentDao {
    StudentEntity save(StudentEntity studentEntity);

    StudentEntity find(int id);

    StudentEntity update(StudentEntity studentEntity);

    StudentEntity delete(int id);
}
