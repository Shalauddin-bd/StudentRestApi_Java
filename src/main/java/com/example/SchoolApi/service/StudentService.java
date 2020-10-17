package com.example.SchoolApi.service;

import com.example.SchoolApi.entities.Student;

import java.util.List;

public interface StudentService {
    public List<Student> getStudent();
    public Student getStudent(long studentId);
    public Student addStudent(Student student);
    public Student updateStudent(Student student);
    public void deleteStudent(long studentId);
}
