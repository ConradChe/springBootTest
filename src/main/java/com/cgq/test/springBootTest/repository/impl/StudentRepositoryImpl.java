package com.cgq.test.springBootTest.repository.impl;

import com.cgq.test.springBootTest.entity.Student;
import com.cgq.test.springBootTest.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepositoryImpl implements StudentRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Student> findAll() {
        return jdbcTemplate.query("select * from student",new BeanPropertyRowMapper<Student>(Student.class));
    }

    @Override
    public Student findById(Integer id) {
        return jdbcTemplate.queryForObject("select * from student where id = ?",new Object[]{id},new BeanPropertyRowMapper<Student>(Student.class));
    }

    @Override
    public int save(Student student) {
        return jdbcTemplate.update("insert into student(name,score,birthday) values(?,?,?)", student.getName(), student.getScore(), student.getBirthday());
    }

    @Override
    public int update(Student student) {
        return jdbcTemplate.update("update student set name = ?,score = ?,birthday=? where id = ?", student.getName(), student.getScore(), student.getBirthday(), student.getId());
    }


    @Override
    public int deleteById(Integer id) {
        return jdbcTemplate.update("delete from student where id = ?",id);
    }
}