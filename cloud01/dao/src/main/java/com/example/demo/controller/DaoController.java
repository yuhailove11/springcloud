package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.repositity.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by 24515 on 2017/10/29.
 */
@RestController
@RequestMapping("student")
public class DaoController {
    @Autowired
    private StudentRepo studentRepo;

    @GetMapping("/list")
    public List<Student> list(){
        return  studentRepo.findAll();
    }

    @GetMapping("/{id}")
    public Student findOneById(@PathVariable("id") Integer id){
        return studentRepo.findOne(id);
    }

}
