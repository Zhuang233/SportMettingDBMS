package com.zbw.mapper;

import com.zbw.pojo.Student;

import java.util.List;

public interface StudentMapper{
    int InsertStudent(Student s);
    int DeleteStudent(Integer sno);
    int UpdateStudent(Student s);
    List<Student> SelectAllStudent();
    List<Student> SelectStudentByKeyword(Student s);

}
