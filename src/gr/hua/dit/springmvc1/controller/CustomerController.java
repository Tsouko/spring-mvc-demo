package gr.hua.dit.springmvc1.controller;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import gr.hua.dit.springmvc1.dao.CustomerDAO;
import gr.hua.dit.springmvc1.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {

		@Autowired
		private CustomerDAO customerDAO;

	
		@RequestMapping("/list")
		   public String listCustomers(Model model) {
		           
		           List<Customer> customers = customerDAO.getCustomers();
		           
		           model.addAttribute("customers",customers);
		           
		           return "list-customers";
		   }
		@GetMapping("/{id}")
		public String getCustomer(Model model, @PathVariable("id") int id) {
			Customer customer = customerDAO.getCustomer(id);
			
			model.addAttribute("customer", customer);
		
			return "StudentDelete";
		}
		
		@GetMapping("/addCustomer")
		public String showAddForm(Model model) {
			Customer customer = new Customer();
			model.addAttribute("customer", customer);
			
			model.addAttribute("pageTitle", "Add a Customer");
			return "customer-form";
		}
		
		@PostMapping("/saveCustomer")
		public String saveStudent(@ModelAttribute("student") Customer customer) {
			customerDAO.saveCustomer(customer);
			
			return "redirect:/customer/list";
		}
		
		@GetMapping("/deleteCustomer/{id}")
		public String deleteStudent(Model model, @PathVariable("id") int id) {
				
			customerDAO.deleteCustomer(id);
			
			return "redirect:/customer/list";
		}
		
}
