package gr.hua.dit.springmvc1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import gr.hua.dit.springmvc1.dao.CustomerDAO;
import gr.hua.dit.springmvc1.dao.StudentDAO;
import gr.hua.dit.springmvc1.entity.Customer;
import gr.hua.dit.springmvc1.entity.Student;

@Controller
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private StudentDAO studentDAO;

	@GetMapping("/addStudent")
	public String showAddForm(Model model) {
		// create model attribute to get form data
		Student student = new Student();
		model.addAttribute("student", student);

		// add page title
		model.addAttribute("pageTitle", "Add a Customer");
		return "student-form";
	}

	@PostMapping("/saveStudent")
	public String saveStudent(@ModelAttribute("student") Student student) {
		// save the student using the service

		studentDAO.saveStudent(student);
		
		PasswordEncoder encoder = new BCryptPasswordEncoder();

		System.out.println(encoder.encode(student.getPassword()));
	    student.setPassword(encoder.encode(student.getPassword()));

		return "redirect:/student/lista";
	}

	@RequestMapping("/lista")
	public String listStudents(Model model) {

		// get customers from the service
		List<Student> students = studentDAO.getStudents();

		// add the customers to the model
		model.addAttribute("students", students);

		return "list-students";
	}
	

}
