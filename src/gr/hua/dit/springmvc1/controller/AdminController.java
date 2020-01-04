package gr.hua.dit.springmvc1.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import gr.hua.dit.springmvc1.entity.Customer;

@Controller
public class AdminController {
	
	@GetMapping("/admin/page")
	public String listCustomers() {
		
		return "/admin/adminonly";
	}
	
	@GetMapping("/admin/addCustomer")
	public String showAddForm(Model model) {
		// create model attribute to get form data
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		
		// add page title
		model.addAttribute("pageTitle", "Add a Customer");
		return "customer-form";
	}
}
