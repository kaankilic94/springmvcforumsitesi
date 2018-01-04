package com.sirketadi.forum;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sirketadi.methods.AdminMethods;

@Controller
public class AdminKonuController {
	
	@RequestMapping(value="/konular", method = RequestMethod.GET)
	public String admin (Model model, HttpServletRequest req) {
		
		model.addAttribute("konular", new AdminMethods().konuListele());
		
		
		return	new AdminMethods().adminKontrol(req,"konular");
	}
	
	@RequestMapping(value="/konular", method = RequestMethod.POST)
	public String adminpost (Model model, HttpServletRequest req) {
		
		
		String implode = "";
		String[] ids = req.getParameterValues("silkonu");
		if( ids != null) {
			implode = new AdminMethods().implode(ids);
			
			new AdminMethods().konuSil(implode);
		}else {
			System.out.println("null");
		}
		model.addAttribute("konular", new AdminMethods().konuListele());
		
		
		return	"admin/konular";
	}
	
	@RequestMapping(value="/konuoku/{id}", method = RequestMethod.GET)
	public String yorumoku (@PathVariable String id, Model model, HttpServletRequest req) {
		
	
		
		model.addAttribute("konuoku", new AdminMethods().konuOku(id));
		
		
		return	new AdminMethods().adminKontrol(req,"konuoku");
	}
	

}
