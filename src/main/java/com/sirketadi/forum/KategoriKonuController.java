package com.sirketadi.forum;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sirketadi.methods.Methods;

@Controller
public class KategoriKonuController {
	
	@RequestMapping(value = "/kategori/{id}", method = RequestMethod.GET)
	public String kategori(@PathVariable String id, HttpServletRequest req, Model model) {

		boolean durum = req.getSession().getAttribute("klId") != null;
		model.addAttribute("durum", durum);
		/////////////////////////////////////
		Methods methods = new Methods();
		
		model.addAttribute("katListe", methods.kategoriListele());
		model.addAttribute("kategoriKonu", methods.kategoriKonuGetir(id));
		
		String isim = (String) req.getSession().getAttribute("klAdi");
		model.addAttribute("isim",isim);
		String klid = (String) req.getSession().getAttribute("klId");
		model.addAttribute("klid",klid);
		String klrutbe = (String) req.getSession().getAttribute("klRutbe");
		model.addAttribute("klrutbe",klrutbe);
		
		model.addAttribute("count", new Methods().mesajSayisi(klid));
	
		return "kategoriKonulari";
	}

}
