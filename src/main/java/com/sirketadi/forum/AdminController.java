package com.sirketadi.forum;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sirketadi.methods.AdminMethods;

@Controller
public class AdminController {
	
	@RequestMapping(value="/yonetim", method = RequestMethod.GET)
	public String admin (HttpServletRequest req) {
		
	return	new AdminMethods().adminKontrol(req,"yonetim");
		
		
	}
	
	@RequestMapping(value="/yonetim", method = RequestMethod.POST)
	public String admin2 (Model model, HttpServletRequest req) {
		
		model.addAttribute("selam","selam");
		
		return "admin/yonetim";
	}

}
