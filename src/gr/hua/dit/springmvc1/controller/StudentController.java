package gr.hua.dit.springmvc1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
	@RequestMapping("/lista")
	   public String listStudents(Model model) {
	           
	           // get customers from the service
	           List<Student> students = studentDAO.getStudents();
	           
	           // add the customers to the model
	           model.addAttribute("students",students);
	           
	           return "list-students";
	   }
}
