package com.sirketadi.forum;

import java.io.File;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.sirketadi.database.DB;
import com.sirketadi.enums.Uye;
import com.sirketadi.methods.Methods;
import com.sirketadi.ozellikler.Kullanici;

@Controller
public class KayitController{


	@RequestMapping(value = "/kayit", method = RequestMethod.GET)
	public String profil(Model model,  HttpServletRequest req ) {
	
		boolean durum = req.getSession().getAttribute("klId") != null;
		model.addAttribute("durum", durum);
		//////////////////////////////////////////////////////////////////////////
		Methods methods = new Methods(); 
		model.addAttribute("katListe", methods.kategoriListele());
		//////////////////////////////////////////////////////////////////////////
		String isim = (String) req.getSession().getAttribute("klAdi");
		model.addAttribute("isim",isim);
		String klid= (String) req.getSession().getAttribute("klId");
		model.addAttribute("klid",klid);
		String klrutbe = (String) req.getSession().getAttribute("klRutbe");
		model.addAttribute("klrutbe",klrutbe);
		
		
		
		String query = "SELECT * FROM iller";
		DB db = new DB();
		ArrayList<String> ilList = new ArrayList<String>();
		
		try {
			PreparedStatement ps = db.preBaglan(query);
			ResultSet rs = ps.executeQuery();
			
		    while(rs.next()) {
		    	 ilList.add(rs.getString("il_adi"));
		    }
		    
		    
 		} catch (Exception e) {
			System.err.println("iller hata:" + e);
		}finally {
			db.kapat();
		}
		model.addAttribute("ills", ilList);
		
		model.addAttribute("count", new Methods().mesajSayisi(klid));
		
		
		
		
		return "kayit";
	}
	
	@RequestMapping(value = "/kayit", method = RequestMethod.POST)
	public String profilPost(Model model,  HttpServletRequest req, @RequestParam(value="email") String mail, @RequestParam MultipartFile resim, @RequestParam String fcb, @RequestParam String twt,
			@RequestParam String sehir, @RequestParam(value="bday") String dogum, @RequestParam String hakkimda, @RequestParam String kladi, @RequestParam String parola,
			@RequestParam String parolatekrar) {
		
		boolean durum = req.getSession().getAttribute("klId") != null;
		model.addAttribute("durum", durum);
		//////////////////////////////////////////////////////////////////////////
		Methods methods = new Methods(); 
		model.addAttribute("katListe", methods.kategoriListele());
		//////////////////////////////////////////////////////////////////////////
		String isim = (String) req.getSession().getAttribute("klAdi");
		model.addAttribute("isim",isim);
		String klid= (String) req.getSession().getAttribute("klId");
		model.addAttribute("klid",klid);
		String klrutbe = (String) req.getSession().getAttribute("klRutbe");
		model.addAttribute("klrutbe",klrutbe);
		
		
		
		String query = "SELECT * FROM iller";
		DB db = new DB();
		ArrayList<String> ilList = new ArrayList<String>();
		
		try {
			PreparedStatement ps = db.preBaglan(query);
			ResultSet rs = ps.executeQuery();
			
		    while(rs.next()) {
		    	 ilList.add(rs.getString("il_adi"));
		    }
		    
		    
 		} catch (Exception e) {
			System.err.println("iller hata:" + e);
		}finally {
			db.kapat();
		}
		model.addAttribute("ills", ilList);
		
		
		
		File file = new Methods().convert(resim);
		String resimyolu = file.getName();
		
		String kayit = new Methods().kayitEkle(mail, resimyolu, fcb, twt, sehir, dogum, hakkimda, parola, parolatekrar, kladi);
		model.addAttribute("kayitmesaj",kayit);
		
		model.addAttribute("count", new Methods().mesajSayisi(klid));
		
		return "kayit";
	}
	


	
}
