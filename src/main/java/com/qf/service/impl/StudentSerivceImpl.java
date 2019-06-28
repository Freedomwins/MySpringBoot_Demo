package com.qf.service.impl;

import com.qf.dao.ClassesMapper;
import com.qf.dao.StudentMapper;
import com.qf.entity.Classes;
import com.qf.entity.Student;
import com.qf.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentSerivceImpl implements IStudentService {

    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private ClassesMapper classesMapper;

    @Override
    public List<Student> queryAll() {
        List<Student> students = studentMapper.selectList(null);

        for (Student stu:students) {
            Classes classes = classesMapper.selectById(stu.getCid());
            stu.setClasses(classes);
        }
        return students;
    }

    @Override
    public int addStudent(Student student) {
        int insert = studentMapper.insert(student);
        return insert;
    }

    @Override
    public int deleteStudent(int id) {
        int deleteById = studentMapper.deleteById(id);
        return deleteById;
    }

    @Override
    public Student getStudentById(int id) {
        Student student = studentMapper.selectById(id);
        Classes classes = classesMapper.selectById(student.getCid());
        student.setClasses(classes);
        return student;
    }

    @Override
    public int updateStudent(Student student) {
        int update = studentMapper.updateById(student);
        return update;
    }
}
