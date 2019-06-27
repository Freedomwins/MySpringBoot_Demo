package com.qf.controller;


import com.qf.entity.Classes;
import com.qf.entity.Student;
import com.qf.service.IClassesService;
import com.qf.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("student")
public class StudentController {

    @Autowired
    private IStudentService studentService;

    @Autowired
    private IClassesService classesService;

    @RequestMapping("queryAll")
    public Object queryAllStudent(Model model){
        List<Student> students = studentService.queryAll();
        model.addAttribute("students",students);
        return "stuList";
    }

    @RequestMapping("toAdd")
    public Object toAdd(Model model){
        List<Classes> classesList = classesService.queryAll();
        model.addAttribute("classesList",classesList);
        return "addStudent";
    }

    @RequestMapping("addStudent")
    public Object addStudent(Student student){
        studentService.addStudent(student);
        return "redirect:/student/queryAll";
    }

    @RequestMapping("delete")
    public Object deleteStudent(@RequestParam(name = "sid") int id){
        studentService.deleteStudent(id);
        return "redirect:/student/queryAll";
    }
}
