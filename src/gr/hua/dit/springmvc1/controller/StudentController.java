package gr.hua.dit.springmvc1.controller;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import gr.hua.dit.springmvc1.dao.AuthoritiesDAO;
import gr.hua.dit.springmvc1.dao.CustomerDAO;
import gr.hua.dit.springmvc1.dao.StudentDAO;
import gr.hua.dit.springmvc1.entity.Customer;
import gr.hua.dit.springmvc1.entity.Student;
import gr.hua.dit.springmvc1.entity.Authorities;

@Controller
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private StudentDAO studentDAO;
	
	@Autowired
	private AuthoritiesDAO authoritiesDAO;
	
	
	
	
//	@Autowired
//	private SessionFactory sessionFactory;
	
	
	
	

	@GetMapping("/addStudent")
	public String showAddForm(Model model) {
		// create model attribute to get form data
		Student student = new Student();
		model.addAttribute("student", student);

		// add page title
		model.addAttribute("pageTitle", "Add a Student");
		return "student-form";
	}
	
	@GetMapping("/updateStudent")
	public String showUpdateForm(Model model) {
		// create model attribute to get form data
		Student student = new Student();
		model.addAttribute("student", student);

		// add page title
		model.addAttribute("pageTitle", "Add a Student");
		return "update-student-form";
	}

	@PostMapping("/saveStudent")
	public String saveStudent(@ModelAttribute("student") Student student) {
		
		Authorities authorities = new Authorities();
		
		PasswordEncoder encoder = new BCryptPasswordEncoder(10);

	    student.setPassword(encoder.encode(student.getPassword()));
		  
	    studentDAO.saveStudent(student);
	    
	    authorities.setId(student.getId());
		authorities.setAuthority("ROLE_STUDENT");
		
		authoritiesDAO.saveAuthorities(authorities);

		return "redirect:/student/list";
	}

	@RequestMapping("/list")
	public String listStudents(Model model) {

		// get customers from the service
		List<Student> students = studentDAO.getStudents();

		// add the customers to the model
		model.addAttribute("students", students);
		


		return "list-students";
	}
	

	@GetMapping("/deleteStudent/{id}")
	public String deleteStudent(Model model, @PathVariable("id") int id) {
			
		studentDAO.deleteStudent(id);
		
		return "redirect:/student/lista";
	}

}
