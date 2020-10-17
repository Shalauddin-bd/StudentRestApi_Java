package com.example.SchoolApi.dao;

import com.example.SchoolApi.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDao extends JpaRepository<Student, Long> {

}
