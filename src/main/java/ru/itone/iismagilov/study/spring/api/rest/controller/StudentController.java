package ru.itone.iismagilov.study.spring.api.rest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itone.iismagilov.study.spring.dto.StudentDto;

public interface StudentController {

    @GetMapping(value = "/getStudent/{id}")
    ResponseEntity<String> getStudentText(@PathVariable("id") int id);

    @PostMapping(value = "/addStudent")
    ResponseEntity<String> addStudentText(@RequestBody StudentDto studentDto);

    @DeleteMapping(value = "/deleteStudent/{id}")
    ResponseEntity<String> deleteStudentText(@PathVariable("id") int id);
}
