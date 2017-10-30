package com.example.demo.repositity;

import com.example.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by 24515 on 2017/10/28.
 */
public interface StudentRepo extends JpaRepository<Student,Integer> {

}
