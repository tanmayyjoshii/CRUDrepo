package com.example.demo.controller;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/Student")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;
    @GetMapping
    public List<Student> getAllStudent(){
        return studentRepository.findAll();
    }

    //Build create student RestApi
    @PostMapping
    public Student createStudent(@RequestBody Student student){
        return studentRepository.save(student);
    }

    @GetMapping("{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id){
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("student not exist with this id"+id));
        return ResponseEntity.ok(student);
    }

    //Build Update rest api
    @PutMapping("{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id,@RequestBody Student studentDetails){
        Student updateStudent = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not exist with this id"));

        updateStudent.setName(studentDetails.getName());
        updateStudent.setAdd(studentDetails.getAdd());

        studentRepository.save(updateStudent);
        return ResponseEntity.ok(updateStudent);
    }

    //Build delete rest api
    @DeleteMapping("{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable Long id){
        Student deleteStudent = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not exist with this id"));
        studentRepository.delete(deleteStudent);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
