package com.example.SchoolApi.controller;

import com.example.SchoolApi.entities.Student;
import com.example.SchoolApi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    @Autowired
    public StudentService studentService;


    @GetMapping("/home")
    public String home(){
        return "Welcome to our school.";
    }

//    @GetMapping("/students")
//    public List<Student> getStudents(){
//        if(studentList.size()==0){
//            studentList.add(new Student(1,"Mr.A","Dhaka"));
//            studentList.add(new Student(2,"Mr.B","Ctg"));
//            studentList.add(new Student(3,"Mr.C","Khulna"));
//        }
//
//        return studentList;
//    }
//
//    @DeleteMapping("/students/{studentId}")
//    public List<Student> deleteStudent(@PathVariable long studentId)
//    {
//        Student s = null;
//        for(Student student:studentList){
//            if(student.getId()== studentId){
//                s = student;
//                break;
//            }
//        }
//
//        studentList.remove(s);
//        return studentList;
//    }

    //Get all the students
    @GetMapping("/students")
    //@RequestMapping(path = "/students",method = RequestMethod.GET)
    public List<Student> getStudents()
    {
        return  this.studentService.getStudent();
    }

    //Get single student
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable String studentId)
    {
        return  this.studentService.getStudent(Long.parseLong(studentId));
    }

    //Save single student
    @PostMapping("/students")
    //@PostMapping(path = "/students", consumes = "application/json")
    public Student addStudent(@RequestBody Student student)
    {
        return  this.studentService.addStudent(student);
    }

    //Update single student
    @PutMapping("/students")
    public Student updateStudent(@RequestBody Student student)
    {
        return  this.studentService.updateStudent(student);
    }

    @GetMapping("/students_V2/{studentId}")
    public ResponseEntity<HttpStatus> getStudent_V2(@PathVariable String studentId)
    {
        try {
           Student student = this.studentService.getStudent(Long.parseLong(studentId));
           if(student == null){
               return new ResponseEntity<>(HttpStatus.OK);
           }
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        catch (Exception ex){
        return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    //Update single course
    @DeleteMapping("/students/{studentId}")
    public ResponseEntity<HttpStatus> deleteStudent(@PathVariable String studentId)
    {
        try {
            this.studentService.deleteStudent(Long.parseLong(studentId));
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception ex){
            return  new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
