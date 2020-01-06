package gr.hua.dit.springmvc1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import gr.hua.dit.springmvc1.dao.OfficeDAO;
import gr.hua.dit.springmvc1.dao.StudentApplicationsDAO;
import gr.hua.dit.springmvc1.entity.Authorities;
import gr.hua.dit.springmvc1.entity.Office;
import gr.hua.dit.springmvc1.entity.StudentApplications;
import gr.hua.dit.springmvc1.entity.Users;

@Controller
@RequestMapping("/stdapps")									// stdapps/addStdapp
public class StudentApplicationsController {

	@Autowired
	private StudentApplicationsDAO studentapplicationsDAO;
	
	@GetMapping("/addStdapp")
	public String showAddForm(Model model) {
		StudentApplications Studentapplications = new StudentApplications();
		model.addAttribute("Studentapplications", Studentapplications);

		model.addAttribute("pageTitle", "Add an Add an std app");
		return "stdapp-form";
	}
	
	@PostMapping("/saveStdapps")
	public String saveStdApps(@ModelAttribute("Studentapplications") StudentApplications Studentapplications) {
		
				  
	    studentapplicationsDAO.saveStdApps(Studentapplications);


		return "redirect:/office/list";
	}
}
