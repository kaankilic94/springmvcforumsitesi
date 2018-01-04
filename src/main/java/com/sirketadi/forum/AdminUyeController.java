package com.sirketadi.forum;

import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sirketadi.methods.AdminMethods;

@Controller
public class AdminUyeController {
	
	@RequestMapping(value="/uyeler", method = RequestMethod.GET)
	public String admin (Model model, HttpServletRequest req) {
		
		model.addAttribute("uyeler", new AdminMethods().uyeListele());
		
		return	new AdminMethods().adminKontrol(req,"uyeler");
	}
	
	@RequestMapping(value="/uyeler", method = RequestMethod.POST)
	public String admin2 (Model model, HttpServletRequest req) {
		
		String implode = "";
		String[] ids = req.getParameterValues("sil");
		if( ids != null) {
			implode = new AdminMethods().implode(ids);
			System.out.println(implode);
			new AdminMethods().uyeSil(implode);
		}else {
			System.out.println("null");
		}
		
		model.addAttribute("uyeler", new AdminMethods().uyeListele());
		

		return "admin/uyeler";
	}
	
	@RequestMapping(value="/onay/{id}", method = RequestMethod.GET)
	public String onay (@PathVariable String id, Model model, HttpServletRequest req) {
	
		boolean kontrol = req.getSession().getAttribute("klId") != null;
		String klrutbe = (String) req.getSession().getAttribute("klRutbe");
		
		if (kontrol && klrutbe.equals("1")) {
			new AdminMethods().uyeOnay(id);
			model.addAttribute("uyeler", new AdminMethods().uyeListele());
		}
		
		
		
		
		return	new AdminMethods().adminKontrol(req,"uyeler");
		
	}
	
	

}
