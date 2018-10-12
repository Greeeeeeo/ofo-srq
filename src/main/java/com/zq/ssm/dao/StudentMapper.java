package com.zq.ssm.dao;

import java.util.List;

import com.zq.ssm.model.Student;

public interface StudentMapper {
    int deleteByPrimaryKey(Integer sId);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer sId);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

	List<Student> findAllStudent();

	List<Student> findStudentByVo(Student stu);
}