package com.zbw.controller;

import com.google.gson.Gson;
import com.zbw.mapper.StudentMapper;
import com.zbw.pojo.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin(origins = {"*","null"})
public class StudentController {
    private Gson gson = new Gson();
    @Resource
    private StudentMapper studentMapper;

    //查询

    //查询所有学生
    @GetMapping("/getAllStudents")
    public String getStudents(){
        List<Student> list = studentMapper.SelectAllStudent();
        return gson.toJson(list);
    }

    //按关键词查询
    @GetMapping("/getStudents")
    public String getStudentsByKeyword(Student s){
        List<Student> list = studentMapper.SelectStudentByKeyword(s);
        return gson.toJson(list);
    }

    @GetMapping("/addStudent")
    public int AddStudent(Student s){
        return studentMapper.InsertStudent(s);
    }

    @GetMapping("/deleteStudent")
    public int DeleteStudent(@RequestParam("studentno") Integer sno){
        return studentMapper.DeleteStudent(sno);
    }

    @GetMapping("/updateStudent")
    public int UpdateStudent(Student s){
        return studentMapper.UpdateStudent(s);
    }
}
