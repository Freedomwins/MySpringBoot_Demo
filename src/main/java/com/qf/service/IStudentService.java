package com.qf.service;

import com.qf.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IStudentService  {
    public List<Student> queryAll();
    public int addStudent(Student student);
    public int deleteStudent(int id);
    public Student getStudentById(int id);
    public int updateStudent(Student student);
}
