package gr.hua.dit.springmvc1.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
import gr.hua.dit.springmvc1.dao.Job_offersDAO;
import gr.hua.dit.springmvc1.dao.StudentApplicationsDAO;
import gr.hua.dit.springmvc1.dao.StudentDAO;
import gr.hua.dit.springmvc1.dao.UsersDAO;
import gr.hua.dit.springmvc1.entity.Authorities;
import gr.hua.dit.springmvc1.entity.Job_offers;
import gr.hua.dit.springmvc1.entity.Office;
import gr.hua.dit.springmvc1.entity.Student;
import gr.hua.dit.springmvc1.entity.StudentApplications;
import gr.hua.dit.springmvc1.entity.Users;

@Controller
@RequestMapping("/job_offers")
public class Job_offersController {

	@Autowired
	private Job_offersDAO job_offersDAO;
	
	@Autowired
	private AuthoritiesDAO authoritiesDAO;
	
	@Autowired
	private UsersDAO usersDAO;
	
	@Autowired
	private StudentDAO studentDAO;
	
	@Autowired
	private StudentApplicationsDAO studentapplicationsDAO;
	
	@GetMapping("/addJob_offers")
	public String showAddForm(Model model) {
		Job_offers job_offers = new Job_offers();
		model.addAttribute("job_offers", job_offers);

		model.addAttribute("pageTitle", "Add an Office");
		return "job-offers-form";									
	}
	
	@GetMapping("/updatejob_offersList")
	public String showUpdateForm(Model model) {
		Job_offers job_offers = new Job_offers();
		model.addAttribute("job_offers", job_offers);

		model.addAttribute("pageTitle", "Update a job offer");
		return "update-job_offers-form";							
	}
	
	@PostMapping("/saveJob_offers")
	public String saveJob_offers(@ModelAttribute("job_offers") Job_offers job_offers) {
		  
		System.out.println(job_offers.getEnabled());
		
		if(job_offers.getEnabled()==null) {
		job_offers.setEnabled(0);
		}
		
	    job_offersDAO.saveJob_offers(job_offers);
   

		return "redirect:/job_offers/list";
	}
	
	@PostMapping("/updateJob_offers")
	public String updateJob_offers(@ModelAttribute("office") Job_offers job_offers) {
		
	
		  
	    job_offersDAO.saveJob_offers(job_offers);
	    

		return "redirect:/job_offers/list";
	}
	
	@RequestMapping("/list")
	public String listJob_offers(Model model) {

		// get Office from the service
		List<Job_offers> job_offers = job_offersDAO.getJob_offers();

		// add the Office to the model
		model.addAttribute("job_offers", job_offers);
		

		
		return "list-job_offers";																				
	}
	
	@GetMapping("/deleteJob_offers/{id}")
	public String deleteJob_offers(Model model, @PathVariable("id") int id) {
			
		job_offersDAO.deleteJob_offer(id);
		

		return "redirect:/job_offers/list";
	}
	
	@GetMapping("/accepted/{id}")
	@Transactional
	public String Accepted(Model model, @PathVariable("id") int id) {
		Job_offers job_offers = new Job_offers();
		
		job_offers = job_offersDAO.getJob_offer(id);
		
		job_offers.setEnabled(1);
		
		job_offersDAO.saveJob_offers(job_offers);
		
		
		
		return "redirect:/student/list";
	}
}
