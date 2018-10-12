package com.zq.ssm.service;

import java.util.List;

import com.zq.ssm.model.Student;

public interface StudentService {

	List<Student> findAllStudent();

	void deleteStudent(int id);

	void addStudent(Student stu);

	Student findStudentById(int id);

	void updateStudent(Student stu);

	List<Student> findStudentByVo(Student stu);
	
}
