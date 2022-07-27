package com.example.secondspringproject.Service;

import com.example.secondspringproject.Entity.Student;
import com.example.secondspringproject.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {


    @Autowired
    StudentRepository studentRepository;

    // get lists of students
    public List<Student> getStudent(){
        return studentRepository.findAll();
    }

    // add students
    public void addStudent(Student student){
        studentRepository.save(student);
    }

    // delete students
    public void deleteStudent(int id){
        studentRepository.deleteById(id);
    }

    // get student by id
    public Student getStudentById(int id){
        return studentRepository.findById(id).orElse(null);
    }

    // edit student
//   public void editStudent(Student student, int id){
//
//       Student student1 =  studentRepository.findById(id).orElse(null);
//
//       student1.setFullname(student.getFullname());
//       student1.setUsername(student.getUsername());
//       student1.setPwd(student.getPwd());
//
//
//       studentRepository.save(student1);
//   }






}
