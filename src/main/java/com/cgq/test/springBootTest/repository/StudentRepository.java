package com.cgq.test.springBootTest.repository;

import com.cgq.test.springBootTest.entity.Student;

import java.util.List;

public interface StudentRepository {
    public List<Student> findAll();
    public Student findById(Integer id);
    public int save(Student student);
    public int update(Student student);
    public int deleteById(Integer id);
}
