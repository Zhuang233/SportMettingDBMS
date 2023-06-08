package com.zbw.controller;

import com.google.gson.Gson;
import com.zbw.mapper.StudentMapper;
import com.zbw.pojo.Student;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin(origins = {"*","null"})
public class StudentController {
    private Gson gson = new Gson();
    @Resource
    private StudentMapper studentMapper;

    @GetMapping("/getAllStudents")
    public String getStudents(){
        List<Student> list = studentMapper.SelectAllStudent();
        return gson.toJson(list);
    }


    @GetMapping("/addStudent")
    public int AddStudent(Student s){
        return studentMapper.InsertStudent(s);
    }
}
