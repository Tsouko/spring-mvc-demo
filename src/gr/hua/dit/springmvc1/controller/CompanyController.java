package gr.hua.dit.springmvc1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import gr.hua.dit.springmvc1.dao.CompanyDAO;
import gr.hua.dit.springmvc1.dao.UsersDAO;
import gr.hua.dit.springmvc1.entity.Authorities;
import gr.hua.dit.springmvc1.entity.Company;
import gr.hua.dit.springmvc1.entity.Student;
import gr.hua.dit.springmvc1.entity.Users;

@Controller
@RequestMapping("/company")
public class CompanyController {
	
	@Autowired
	private CompanyDAO companyDAO;
	
	@Autowired
	private AuthoritiesDAO authoritiesDAO;
	
	@Autowired
	private UsersDAO usersDAO;
	
	@GetMapping("/addCompany")
	public String showAddForm(Model model) {
		// create model attribute to get form data
		Company company = new Company();
		model.addAttribute("company", company);

		// add page title
		model.addAttribute("pageTitle", "Add a Student");
		return "company-form";											
	}
	
	@GetMapping("/updateCompanyList")
	public String showUpdateForm(Model model) {
		Company company = new Company();
		model.addAttribute("company", company);
		model.addAttribute("pageTitle", "Update a Company");
		return "update-company-form";									
	}
	
	@PostMapping("/saveCompany")
	public String saveStudent(@ModelAttribute("company") Company company) {
		
		Authorities authorities = new Authorities();
		
		PasswordEncoder encoder = new BCryptPasswordEncoder(10);

		company.setPassword(encoder.encode(company.getPassword()));
		  
		companyDAO.saveCompany(company);
	    
	    authorities.setId(company.getId());
		authorities.setAuthority("ROLE_COMPANY");
		
		authoritiesDAO.saveAuthorities(authorities);
		
		Users users = new Users();
		
		users.setId(company.getId());
		users.setPassword(company.getPassword());
		users.setEnabled(company.getEnabled());
		
		usersDAO.saveUsers(users);

		return "redirect:/company/list";								
	}
	
	@PostMapping("/updateCompany")
	public String updateCompany(@ModelAttribute("company") Company company) {
		
		
		PasswordEncoder encoder = new BCryptPasswordEncoder(10);

		company.setPassword(encoder.encode(company.getPassword()));
		  
		companyDAO.saveCompany(company);
	    

		return "redirect:/company/list";									
	}
	@RequestMapping("/list")
	public String listCompanies(Model model) {

		List<Company> companies = companyDAO.getCompanies();
		model.addAttribute("companies", companies);
		
		return "list-companies";												
	}
	

	@GetMapping("/deleteCompany/{id}")
	public String deleteCompany(Model model, @PathVariable("id") int id) {
			
		companyDAO.deleteCompany(id);
		
		authoritiesDAO.deleteAuthority(id);
		
		usersDAO.deleteUsers(id);
		
		return "redirect:/company/list";									
	}
	
}
