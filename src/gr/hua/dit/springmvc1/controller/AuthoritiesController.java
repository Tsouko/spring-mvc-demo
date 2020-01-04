package gr.hua.dit.springmvc1.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import gr.hua.dit.springmvc1.dao.AuthoritiesDAO;
import gr.hua.dit.springmvc1.entity.Authorities;

@Controller
@RequestMapping("/authorities")
public class AuthoritiesController {
	
	@Autowired
	private AuthoritiesDAO authoritiesDAO;

	@RequestMapping("/list")
	public String listAuthorities(Model model) {

		List<Authorities> authorities = authoritiesDAO.getAuthorities();
		model.addAttribute("authorities", authorities);
		


		return "list-authorities";
	}
}
