package ru.itone.iismagilov.study.spring.api.rest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

public interface StudentController {

    @GetMapping(value = "/getStudent")
    ResponseEntity<String> getStudentText(int id);
    @PostMapping(value = "/addStudent")
    ResponseEntity<String> addStudentText(String name, String lastName, String middleName, String passport);
    @DeleteMapping(value = "/deleteStudent")
    ResponseEntity<String> deleteStudentText(int id);
}
