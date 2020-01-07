package gr.hua.dit.springmvc1.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import gr.hua.dit.springmvc1.dao.Job_offersDAO;
import gr.hua.dit.springmvc1.dao.OfficeDAO;
import gr.hua.dit.springmvc1.dao.StudentApplicationsDAO;
import gr.hua.dit.springmvc1.dao.StudentDAO;
import gr.hua.dit.springmvc1.entity.Authorities;
import gr.hua.dit.springmvc1.entity.Job_offers;
import gr.hua.dit.springmvc1.entity.Office;
import gr.hua.dit.springmvc1.entity.Student;
import gr.hua.dit.springmvc1.entity.StudentApplications;
import gr.hua.dit.springmvc1.entity.Users;

@Controller
@RequestMapping("/stdapps")									// stdapps/addStdapp
public class StudentApplicationsController {
	

	@Autowired
	private StudentApplicationsDAO studentapplicationsDAO;
	
	@Autowired
	private StudentDAO studentDAO;
	
	@Autowired Job_offersDAO job_offersDAO;
	
	@GetMapping("/addStdapp")
    @Transactional
    public String showAddForm(Model model1, Model model2) {

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();


        String username = ((UserDetails)principal).getUsername();
        int id = Integer.parseInt(username);
        System.out.println(username);
        Student student = new Student();
        student = studentDAO.getStudent(id);
        System.out.println(student);

        if(student.getEnabled()== 1) {
            StudentApplications Studentapplications = new StudentApplications();
            model1.addAttribute("Studentapplications", Studentapplications);

            model1.addAttribute("pageTitle", "Add an Add an std app");


            List<Job_offers> job_offers = job_offersDAO.getJob_offers();

            System.out.println(job_offers);

            // add the Office to the model
            model2.addAttribute("job_offers", job_offers);

            return "stdapp-form";
        }else {

            return "stdapp-error";
        }


    }
	
	@PostMapping("/saveStdapps")
	@Transactional
	public String saveStdApps(@ModelAttribute("Studentapplications") StudentApplications Studentapplications) {
		
		
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();


		String username = ((UserDetails)principal).getUsername();
		int id = Integer.parseInt(username);
		System.out.println(username);
		Student student = new Student();
		student = studentDAO.getStudent(id);
		System.out.println(student);

		
		
		Studentapplications.setId(student.getId());
		Studentapplications.setFirstName(student.getFirstName());
		Studentapplications.setLastName(student.getLastName());
		Studentapplications.setEmail(student.getEmail());
		
	    studentapplicationsDAO.saveStdApps(Studentapplications);


		return "redirect:/";
	}
}
