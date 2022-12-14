package com.net.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.net.Model.Student;
import com.net.Service.StudentService;

@Controller
public class StudentController {
	@Autowired
	private StudentService studentservice;
	
	@GetMapping("/get")
	public String viewHomePage(Model model) {
	model.addAttribute("listStudents",studentservice.getAllStudents());
		return "index";
		
	}
	/*
	 * @GetMapping("/get") public String viewHomePage(Model model) { return
	 * findPaginated(1, model); }
	 */
	
	@PostMapping("/saveStudent")
	public String saveStudent(@ModelAttribute("student") Student student) {
		studentservice.saveStudent(student);
		return "redirect:/get";
	}
	
	@GetMapping("/showNewStudentForm")
	public String showNewStudentForm(Model model) {
		Student student=new Student();
		model.addAttribute("newstudent", student);
		return"new_student";
	}
	
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable (value="id") long id, Model model) {
		Student student=studentservice.getStudentById(id);
		model.addAttribute("update", student);
		return "update_student";
	}
	
	@GetMapping("/deleteStudent/{id}")
	public String deleteStudent(@PathVariable(value="id") Student student) {
		this.studentservice.deleteStudentById(student);
		return "redirect:/get";
	}
	
	@GetMapping("/page/{pageNo}")
	public String findPaginated(@PathVariable (value="pageNo") int pageNo,Model model){
		int pageSize=5;
		Page<Student> page=studentservice.findPaginated(pageNo, pageSize);
		List<Student> listStudents=page.getContent();
		model.addAttribute("currentPage",pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		model.addAttribute("listStudents", listStudents);
		return "index";

		
	}

}
