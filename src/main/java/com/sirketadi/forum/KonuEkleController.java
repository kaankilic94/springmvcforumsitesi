package com.sirketadi.forum;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.sirketadi.methods.Methods;

@Controller
public class KonuEkleController {
	
	@RequestMapping(value = "/konuekle", method = RequestMethod.GET)
	public String konuekle(Model model,  HttpServletRequest req) {

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

		return "KonuEkle";
	}
	
	@RequestMapping(value = "/konuekle", method = RequestMethod.POST)
	public String home(Model model, HttpServletResponse res,  HttpServletRequest req, @RequestParam(value= "konu_baslik") String baslik, 
			@RequestParam(value= "konu_resim") MultipartFile resim, @RequestParam(value= "konu_kategori") String kategori,
			@RequestParam(value= "konu_aciklama") String aciklama) {

		    String ekleyen = (String) req.getSession().getAttribute("klAdi");
		    File file = new Methods().convert(resim);
		    String resimyol = file.getName();
			String mesaj = new Methods().konuEkle(baslik, aciklama, kategori, resimyol, ekleyen);
			//System.out.println(mesaj);
		    
		    System.out.println(mesaj);
		    
		    model.addAttribute("eklemesaj", mesaj);
			
			//---------------------------------------
			
			boolean durum = req.getSession().getAttribute("klId") != null;
			model.addAttribute("durum", durum);
			model.addAttribute("isim",ekleyen);
			/////////////////////////////////////
			Methods methods = new Methods();
			model.addAttribute("katListe", methods.kategoriListele());
			
			String klid = (String) req.getSession().getAttribute("klId");
			model.addAttribute("klid",klid);
			String klsehir = (String) req.getSession().getAttribute("klSehir");
			model.addAttribute("klsehir",klsehir);
			String kldogum = (String) req.getSession().getAttribute("klDogum");
			model.addAttribute("kldogum",kldogum);
			String klfacebook = (String) req.getSession().getAttribute("klFacebook");
			model.addAttribute("klfacebook",klfacebook);
			String kltwitter = (String) req.getSession().getAttribute("klTwitter");
			model.addAttribute("kltwitter",kltwitter);
			String klresim = (String) req.getSession().getAttribute("klResim");
			model.addAttribute("klresim",klresim);
			String klrutbe = (String) req.getSession().getAttribute("klRutbe");
			model.addAttribute("klrutbe",klrutbe);
		
			model.addAttribute("count", new Methods().mesajSayisi(klid));
			
		return "KonuEkle";
	}

}
