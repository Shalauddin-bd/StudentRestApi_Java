package com.example.SchoolApi.service;

import com.example.SchoolApi.dao.StudentDao;
import com.example.SchoolApi.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public List<Student> getStudent() {
        return studentDao.findAll();
    }

    @Override
    public Student getStudent(long studentId) {
        return studentDao.getOne(studentId);
    }

    @Override
    public Student addStudent(Student student) {
        studentDao.save(student);
        return student;
    }

    @Override
    public Student updateStudent(Student student) {
        studentDao.save(student);
        return  student;
    }

    @Override
    public void deleteStudent(long studentId) {
        Student student = studentDao.getOne(studentId);
        studentDao.delete(student);
    }
}
