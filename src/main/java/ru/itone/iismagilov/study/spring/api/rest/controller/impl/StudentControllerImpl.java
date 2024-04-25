package ru.itone.iismagilov.study.spring.api.rest.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.itone.iismagilov.study.spring.api.rest.controller.StudentController;
import ru.itone.iismagilov.study.spring.dto.StudentDto;
import ru.itone.iismagilov.study.spring.service.StudentService;

@RestController
public class StudentControllerImpl implements StudentController {
    @Autowired
    private StudentService studentService;

    @Override
    public ResponseEntity<String> getStudentText(int id) {
        return ResponseEntity.ok(String.valueOf(studentService.get(id)));
    }
    @Override
    public ResponseEntity<String> addStudentText(String name, String lastName, String middleName, String passport) {
        StudentDto student = new StudentDto();
        student.setName(name);
        student.setLastName(lastName);
        student.setMiddleName(middleName);
        student.setPassport(passport);
        return ResponseEntity.ok(String.valueOf(studentService.add(student)));
    }
    @Override
    public ResponseEntity<String> deleteStudentText(int id) {
        return ResponseEntity.ok(String.valueOf(studentService.delete(id)));
    }
}
