package ru.itone.iismagilov.study.spring.dao.impl;

import ru.itone.iismagilov.study.spring.dao.StudentDao;
import ru.itone.iismagilov.study.spring.dao.entity.StudentEntity;

import java.util.HashMap;
import java.util.Map;

public class StudentDaoInMemoryImpl implements StudentDao {

    private final Map<Integer, StudentEntity> studentsEntityMap = new HashMap<>();

    private int countID = 0;

    @Override
    public StudentEntity save(StudentEntity studentEntity) {
        final int studentId = countID;
        studentEntity.setId(studentId);
        studentsEntityMap.put(studentId, studentEntity);
        countID = countID + 1;
        return studentEntity;
    }

    @Override
    public StudentEntity find(int id) {
        return studentsEntityMap.get(id);
    }

    @Override
    public StudentEntity update(StudentEntity studentEntity) {
        //получить объект из коллекции и проставить ему поля такие же как в аргументе метода
        StudentEntity inMemoryStudentEntity = studentsEntityMap.get(studentEntity.getId());
        inMemoryStudentEntity.setName(studentEntity.getName());
        inMemoryStudentEntity.setLastName(studentEntity.getLastName());
        inMemoryStudentEntity.setMiddleName(studentEntity.getMiddleName());
        inMemoryStudentEntity.setAge(studentEntity.getAge());
        inMemoryStudentEntity.setPassport(studentEntity.getPassport());
        return inMemoryStudentEntity;
    }

    @Override
    public StudentEntity delete(int id) {
        return studentsEntityMap.remove(id);
    }
}
