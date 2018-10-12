package com.zq.ssm.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.zq.ssm.model.Areamanager;
import com.zq.ssm.service.AreaManagerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zq.ssm.model.Student;
import com.zq.ssm.service.StudentService;

@Controller
public class StudentController {
	@Resource
	private StudentService studentService;
	
	@RequestMapping("/selectAll.do")
	public String findAllStudent(Model model){
		List<Student> list = studentService.findAllStudent();
		model.addAttribute("list",list);
		return "examList";
	}
	
	@RequestMapping("/deleteStudent.do")
	public String deleteStudent(int id){
		studentService.deleteStudent(id);
		return "redirect:selectAll.do";
	}
	
	@RequestMapping("/toAddStudent.do")
	public String toAddStudent(){
		return "addStudents";
	}
	
	@RequestMapping("/addStudent.do")
	public String addStudent(Student stu){
		studentService.addStudent(stu);
		return "redirect:selectAll.do";
	}
	
	@RequestMapping("/toUpdateStudent.do")
	public String toUpdateStudent(int id, HttpServletRequest req){
		Student stu = studentService.findStudentById(id);
		req.setAttribute("student", stu);
		return "updateStudents";
	}
	
	@RequestMapping("/updateStudent.do")
	public String updateStudent(Student stu){
		studentService.updateStudent(stu);
		return "redirect:selectAll.do";
	}
	
	@RequestMapping("/searchStudentByVo.do")
	public String searchStudentByVo(Student stu,Model model){
		List<Student> list = studentService.findStudentByVo(stu);
		model.addAttribute("list", list);
		model.addAttribute("student", stu);
		return "examList";
	}

//
	@RequestMapping("/areaManager/index.do")
	public String toAreaManagerIndex(Model model){
		return "view/areaManager/index";
	}


/*	@Resource
	private AreaManagerService areaManagerService;

	@RequestMapping("/areaManager/selectAll.do")
	public String SelectAreaManager(Model model){
		List<Areamanager> areamanagersList = areaManagerService.SelectAllAreaManager();
		model.addAttribute("areaManagerList",areamanagersList);
		return "view/areaManager/ManagerView/manager-list";
	}*/

}
