package org.liu.controller;


import org.liu.model.Student;
import org.liu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {

    @Autowired
    StudentService studentService;

    @RequestMapping("/getStuByPriKey")
    @ResponseBody
    public Student getStu(@RequestParam("id")String id){
        return studentService.getStu(id);
    }

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }
}
