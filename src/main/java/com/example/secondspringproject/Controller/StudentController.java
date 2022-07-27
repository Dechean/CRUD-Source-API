package com.example.secondspringproject.Controller;

import com.example.secondspringproject.Entity.Student;
import com.example.secondspringproject.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
//@RequestMapping("/api")
public class StudentController {

    @Autowired
    StudentService studentService;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/")
    public String homePage(Model model){

       List<Student> studentList = studentService.getStudent();

       model.addAttribute("listOfStudents", studentList);

//        System.out.println(studentList);

        // return file name
        return "index";
    }


    @RequestMapping("delete/{id}")
    public String deleteStudent(@PathVariable(name = "id") int id){
        studentService.deleteStudent(id);
        return "redirect:/";
    }



    // add new student - takes to the form
    @GetMapping("/new")
    public String addNewStudent(Model model){
        Student student = new Student();
        model.addAttribute("student", student);

        return "addNewStudent";
    }



    // adds new student
    @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
    public String addStudent(@ModelAttribute Student student){
        String pwd = student.getPwd();
        String encodePwd = bCryptPasswordEncoder.encode(pwd);

        student.setPwd(encodePwd);

        studentService.addStudent(student);

        return "redirect:/";
    }




    // edit form page
    @RequestMapping(value = "/edit/{id}")
    public ModelAndView editPage(@PathVariable(name = "id") int id){
        ModelAndView modelAndView = new ModelAndView("edit");

        // get student by id to show details
        Student student = studentService.getStudentById(id);
        modelAndView.addObject("student", student);



        return modelAndView;

    }







}
