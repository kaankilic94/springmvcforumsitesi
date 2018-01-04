package com.sirketadi.forum;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sirketadi.database.DB;
import com.sirketadi.enums.Uye;
import com.sirketadi.methods.Methods;


@Controller
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home1() {
	return "redirect:/1";
	}

	@RequestMapping(value = "/{sayfa}", method = RequestMethod.GET)
	public String home(@PathVariable String sayfa, Model model,  HttpServletRequest req) {

		
		
		
		boolean durum = req.getSession().getAttribute("klId") != null;
		model.addAttribute("durum", durum);
		/////////////////////////////////////
		Methods methods = new Methods();
		model.addAttribute("liste", methods.konuListele(sayfa));
		model.addAttribute("katListe", methods.kategoriListele());
		
		String isim = (String) req.getSession().getAttribute("klAdi");
		model.addAttribute("isim",isim);
		String klid = (String) req.getSession().getAttribute("klId");
		model.addAttribute("klid",klid);
		String klrutbe = (String) req.getSession().getAttribute("klRutbe");
		model.addAttribute("klrutbe",klrutbe);
		model.addAttribute("count", new Methods().mesajSayisi(klid));
		
		//sayfalama
		int sayfa_sayisi = new Methods().sayfaSayisi();
		int forlimit = 2;
		int s = Integer.valueOf(sayfa);
		
		ArrayList<Integer> ls = new ArrayList<Integer>();
		for (int i = s-forlimit; i < s+forlimit+1; i++) {
			if(i>0 && i<=sayfa_sayisi){
				
				ls.add(i);
				
			}
			
		}
		
		model.addAttribute("sayfalama", ls);
		model.addAttribute("sayfa", sayfa);
		model.addAttribute("son",String.valueOf(sayfa_sayisi));
		//sayfalama
	
 
		return "home";
	}
	

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String kullaniciGiris(Model model, HttpServletRequest req,
			@RequestParam(value = "kullanici_adi") String klAdi,
			@RequestParam(value = "kullanici_parola") String klParola) {

		Methods methods = new Methods();
		DB db = new DB();
		String query = "CALL klGiris(?,?)";

		boolean durum = false;
		String kontrol = "";

		try {

			if (klAdi.trim().equals("") || klParola.equals("")) {

				
				kontrol="Kullanici adi veya parola boş bırakılamaz.";
				
			} else {
				PreparedStatement ps = db.preBaglan(query);
				ps.setString(1, klAdi.trim());
				ps.setString(2, methods.getHash(klParola.trim()));
				ResultSet rs = ps.executeQuery();

				if (rs.next()) {
					req.getSession().setAttribute("klId", rs.getString("" + Uye.uye_id));
					req.getSession().setAttribute("klAdi", rs.getString("" + Uye.uye_adi));
					req.getSession().setAttribute("klRutbe", rs.getString("" + Uye.uye_rutbe));
					req.getSession().setAttribute("klMail", rs.getString("" + Uye.uye_eposta));
					req.getSession().setAttribute("klSehir", rs.getString("uye_sehir"));
					req.getSession().setAttribute("klDogum", rs.getString("" + Uye.uye_dogum));
					req.getSession().setAttribute("klFacebook", rs.getString("" + Uye.uye_facebook));
					req.getSession().setAttribute("klTwitter", rs.getString("" + Uye.uye_twitter));
					req.getSession().setAttribute("klResim", rs.getString("uye_resim"));

					durum = true;
					kontrol="giriş başarılı";
					
				} else {
					
					kontrol= "Bu kullanınıcı sistemde kayıtlı değil.";
					
				}
			}

		} catch (Exception e) {
			System.err.println("Kullanici Giris Hata: " + e);
		}
		
		model.addAttribute("durum", durum);
		model.addAttribute("liste", methods.konuListele("1"));
		model.addAttribute("katListe", methods.kategoriListele());
		model.addAttribute("kontrol", kontrol);
		
		String isim = (String) req.getSession().getAttribute("klAdi");
		model.addAttribute("isim",isim);
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

		return "home";
	}
	
	@RequestMapping(value = "/cikis", method = RequestMethod.GET)
	public String cikis(Model model,  HttpServletRequest req) {

		req.getSession().invalidate();

		return "redirect:/1";
	}

	
	
	


}
