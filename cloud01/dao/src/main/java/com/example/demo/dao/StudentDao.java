package com.example.demo.dao;

import com.example.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

/**
 * Created by 24515 on 2017/10/27.
 */

@Component
public interface StudentDao extends JpaRepository<Student,Integer> {

}
