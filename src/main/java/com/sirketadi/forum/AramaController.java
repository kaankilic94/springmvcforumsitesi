package com.sirketadi.forum;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sirketadi.methods.Methods;

@Controller
public class AramaController {
	
	@RequestMapping(value = "/ara", method = RequestMethod.GET)
	public String home(Model model,  HttpServletRequest req) {

		boolean durum = req.getSession().getAttribute("klId") != null;
		model.addAttribute("durum", durum);
		/////////////////////////////////////
		Methods methods = new Methods();
		
		model.addAttribute("katListe", methods.kategoriListele());
		
		String isim = (String) req.getSession().getAttribute("klAdi");
		model.addAttribute("isim",isim);
		String klid = (String) req.getSession().getAttribute("klId");
		model.addAttribute("klid",klid);
		String klrutbe = (String) req.getSession().getAttribute("klRutbe");
		model.addAttribute("klrutbe",klrutbe);
	
		model.addAttribute("count", new Methods().mesajSayisi(klid));
		

		
	
 
		return "arama";
	}
	
	@RequestMapping(value = "/ara", method = RequestMethod.POST)
	public String arapost(Model model,  HttpServletRequest req ,@RequestParam String yazi) {

		boolean durum = req.getSession().getAttribute("klId") != null;
		model.addAttribute("durum", durum);
		/////////////////////////////////////
		Methods methods = new Methods();
//		model.addAttribute("liste", methods.konuListele());
		model.addAttribute("katListe", methods.kategoriListele());
		
		String isim = (String) req.getSession().getAttribute("klAdi");
		model.addAttribute("isim",isim);
		String klid = (String) req.getSession().getAttribute("klId");
		model.addAttribute("klid",klid);
		String klrutbe = (String) req.getSession().getAttribute("klRutbe");
		model.addAttribute("klrutbe",klrutbe);
		
		
		model.addAttribute("araliste", methods.arama(yazi));
		model.addAttribute("count", new Methods().mesajSayisi(klid));
		

		
	
 
		return "arama";
	}

}
