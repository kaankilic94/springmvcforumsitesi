package com.sirketadi.forum;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sirketadi.database.DB;
import com.sirketadi.methods.AdminMethods;
import com.sirketadi.ozellikler.Yorum;

@Controller
public class AdminYorumController {

	
	@RequestMapping(value="/yorumlar", method = RequestMethod.GET)
	public String admin (Model model, HttpServletRequest req) {
		
		model.addAttribute("yorumlar", new AdminMethods().yorumListele());
		
		
		return	new AdminMethods().adminKontrol(req,"yorumlar");
	}
	
	@RequestMapping(value="/yorumlar", method = RequestMethod.POST)
	public String adminpost (Model model, HttpServletRequest req) {
		
		
		String implode = "";
		String[] ids = req.getParameterValues("silyorum");
		if( ids != null) {
			implode = new AdminMethods().implode(ids);
			
			new AdminMethods().yorumSil(implode);
		}else {
			System.out.println("null");
		}
		model.addAttribute("yorumlar", new AdminMethods().yorumListele());
		
		
		return	"admin/yorumlar";
	}
	
	@RequestMapping(value="/yorumoku/{id}", method = RequestMethod.GET)
	public String yorumoku (@PathVariable String id, Model model, HttpServletRequest req) {
		
	
		
		model.addAttribute("yorumoku", new AdminMethods().yorumOku(id));
		
		
		return	new AdminMethods().adminKontrol(req,"yorumoku");
	}
	
	@RequestMapping(value="/yorumonay/{id}", method = RequestMethod.GET)
	public String onay (@PathVariable String id, Model model, HttpServletRequest req) {
	
		boolean kontrol = req.getSession().getAttribute("klId") != null;
		String klrutbe = (String) req.getSession().getAttribute("klRutbe");
		
		if (kontrol && klrutbe.equals("1")) {
			new AdminMethods().yorumOnay(id);
			model.addAttribute("yorumlar", new AdminMethods().yorumListele());
		}
		
		
		
		
		return	new AdminMethods().adminKontrol(req,"yorumlar");
		
	}
	
}
