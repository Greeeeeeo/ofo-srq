package com.zq.ssm.service.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zq.ssm.dao.StudentMapper;
import com.zq.ssm.model.Student;
import com.zq.ssm.service.StudentService;

@Service
public class StudentServiceimpl implements StudentService {

	@Resource
	private StudentMapper studentMapper;

	@Override
	public List<Student> findAllStudent() {
	// TODO Auto-generated method stub
		return studentMapper.findAllStudent();
}

	@Override
	public void deleteStudent(int id) {
		studentMapper.deleteByPrimaryKey(id);

	}

	@Override
	public void addStudent(Student stu) {
		studentMapper.insertSelective(stu);

	}

	@Override
	public Student findStudentById(int id) {
		// TODO Auto-generated method stub
		return studentMapper.selectByPrimaryKey(id);
	}

	@Override
	public void updateStudent(Student stu) {
		studentMapper.updateByPrimaryKeySelective(stu);

	}

	@Override
	public List<Student> findStudentByVo(Student stu) {
		// TODO Auto-generated method stub
		return studentMapper.findStudentByVo(stu);
	}

}
