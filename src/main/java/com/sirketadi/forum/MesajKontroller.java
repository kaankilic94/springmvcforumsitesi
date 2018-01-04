package com.sirketadi.forum;

import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sirketadi.database.DB;
import com.sirketadi.methods.Methods;

@Controller
public class MesajKontroller {

	
	@RequestMapping(value = "/mesajkutusu/{id}", method = RequestMethod.GET)
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
		
		
		model.addAttribute("mesajlar", methods.mesajlar(klid));
		model.addAttribute("count", new Methods().mesajSayisi(klid));
	

		return "mesajkutusu";
	}
	
	@RequestMapping(value = "/mesajoku/{mesajkime}/{id}", method = RequestMethod.GET)
	public String mesajoku(@PathVariable String id,@PathVariable String mesajkime, Model model,  HttpServletRequest req) {

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
		
		if (klid.equals(mesajkime)) {
			model.addAttribute("mesajokuls", methods.mesajoku(id, klid));
		}
		
		DB db = new DB();
		String q = "UPDATE mesajlar SET mesaj_okunma=? WHERE mesaj_id = ?";
		PreparedStatement ps = db.preBaglan(q);
		try {
			ps.setString(1, "1");
			ps.setString(2, id);
			ps.executeUpdate();
		} catch (Exception e) {
			System.err.println("mesaj_okunma Hata: " + e);
		}finally {
			db.kapat();
		}
	

		model.addAttribute("count", new Methods().mesajSayisi(klid));
		return "mesajoku";
	}
	
	@RequestMapping(value = "/mesajgonder", method = RequestMethod.GET)
	public String mesajgonder(Model model,  HttpServletRequest req) {

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
		
		
	

		return "mesajgonder";
	}
	
	@RequestMapping(value = "/mesajgonder", method = RequestMethod.POST)
	public String mesajgonderpost(Model model,  HttpServletRequest req, @RequestParam String kime, @RequestParam String baslik,
			@RequestParam String icerik) {

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
		
		String mesajgonder = new Methods().mesajGonder(kime, baslik, icerik, isim);
		model.addAttribute("mesajgonder", mesajgonder);
		
		
		
		model.addAttribute("count", new Methods().mesajSayisi(klid));
	

		return "mesajgonder";
	}
	
	@RequestMapping(value = "/mesajsil/{id}", method = RequestMethod.GET)
	public String mesajsil(Model model, HttpServletRequest req, @PathVariable String id) {

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
		
		model.addAttribute("mesajlar", methods.mesajlar(klid));
		model.addAttribute("count", new Methods().mesajSayisi(klid));
		
		new Methods().mesajSil(id, klid);
	

		return "redirect:/mesajkutusu/"+klid;
	}
	
	
	
	
}
