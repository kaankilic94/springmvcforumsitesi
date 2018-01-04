package com.sirketadi.forum;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sirketadi.database.DB;
import com.sirketadi.methods.AdminMethods;
import com.sirketadi.ozellikler.Kategori;

@Controller
public class AdminKategoriController {
	
	@RequestMapping(value="/kategoriler", method = RequestMethod.GET)
	public String admin (Model model, HttpServletRequest req) {
		
		model.addAttribute("kategoriler", new AdminMethods().kategoriListele());
		
		
		return	new AdminMethods().adminKontrol(req,"kategoriler");
	}
	
	@RequestMapping(value="/kategoriler", method = RequestMethod.POST)
	public String adminpost (Model model, HttpServletRequest req) {
		
		
		String implode = "";
		String[] ids = req.getParameterValues("silkat");
		if( ids != null) {
			implode = new AdminMethods().implode(ids);
			
			new AdminMethods().kategoriSil(implode);
		}else {
			System.out.println("null");
		}
		model.addAttribute("kategoriler", new AdminMethods().kategoriListele());
		
		
		return	"admin/kategoriler";
	}
	
	@RequestMapping(value="/kategoriduzenle/{id}", method = RequestMethod.GET)
	public String duzenle (@PathVariable String id, Model model, HttpServletRequest req) {
		
		
		String query = "SELECT * FROM kategoriler WHERE kategori_id = ?";
		DB db = new DB();
		Kategori k = new Kategori();
		try {
			PreparedStatement ps = db.preBaglan(query);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				k.setKatadi(rs.getString("kategori_adi"));
				k.setKataciklama(rs.getString("kategori_aciklama"));
				k.setKatid(rs.getString("kategori_id"));
			}
		} catch (Exception e) {
			System.err.println("kategori doldur hata: " + e);
		}
		
		model.addAttribute("kat", k);
		
		return	new AdminMethods().adminKontrol(req,"kategoriduzenle");
	}
	
	
	@RequestMapping(value="/kategoriduzenle/{id}", method = RequestMethod.POST)
	public String duzenlepost (@PathVariable String id, @RequestParam String katadi, @RequestParam String kataciklama, Model model, HttpServletRequest req) {
		
		new AdminMethods().kategoriDuzenle(id, katadi, kataciklama);
		model.addAttribute("kategoriler", new AdminMethods().kategoriListele());
		return "admin/kategoriler";
	}
	
	@RequestMapping(value="/kategoriekle", method = RequestMethod.GET)
	public String kategoriekleget () {
		
		
		
		
		return "admin/kategoriekle";
	}
	
	@RequestMapping(value="/kategoriekle", method = RequestMethod.POST)
	public String kategoriekle (@RequestParam String katadi, @RequestParam String kataciklama, Model model, HttpServletRequest req) {
		
		
		new AdminMethods().kategoriEkle(katadi, kataciklama);
		
		model.addAttribute("kategoriler", new AdminMethods().kategoriListele());
		
		return "admin/kategoriler";
	}
	
	
	

}
