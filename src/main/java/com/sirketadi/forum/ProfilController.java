package com.sirketadi.forum;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.ldap.Rdn;
import javax.servlet.http.HttpServletRequest;

import org.jsoup.select.Evaluator.Id;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sirketadi.database.DB;
import com.sirketadi.enums.Uye;
import com.sirketadi.methods.Methods;

@Controller
public class ProfilController {

	@RequestMapping(value = "/profil/{klid}", method = RequestMethod.GET)
	public String profil(@PathVariable String klid, Model model,  HttpServletRequest req) {

		boolean durum = req.getSession().getAttribute("klId") != null;

		model.addAttribute("durum", durum);
		/////////////////////////////////////
		Methods methods = new Methods();
		model.addAttribute("katListe", methods.kategoriListele());
		
		String isim = (String) req.getSession().getAttribute("klAdi");
		model.addAttribute("isim",isim);
		model.addAttribute("klid",klid);
		String sessionid = (String) req.getSession().getAttribute("klId");
		model.addAttribute("sessionid",sessionid);
		String klrutbe = (String) req.getSession().getAttribute("klRutbe");
		model.addAttribute("klrutbe",klrutbe);
		
		model.addAttribute("count", new Methods().mesajSayisi(klid));
		
		
		String query ="SELECT * FROM uyeler WHERE uye_id=?";
		DB db = new DB();
		try {
			
			PreparedStatement ps = db.preBaglan(query);
			ps.setString(1, klid);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				String kladi = rs.getString("" + Uye.uye_adi);
				model.addAttribute("kladi", kladi);
				String klmail = rs.getString("" + Uye.uye_eposta);
				model.addAttribute("klmail", klmail);
				String klsehir = rs.getString("" + Uye.uye_sehir);
				model.addAttribute("klsehir",klsehir);
				String kldogum = rs.getString("" + Uye.uye_dogum);
				model.addAttribute("kldogum",kldogum);
				String klfacebook = rs.getString("" + Uye.uye_facebook);
				model.addAttribute("klfacebook",klfacebook);
				String kltwitter = rs.getString("" + Uye.uye_twitter);
				model.addAttribute("kltwitter",kltwitter);
				String klresim = rs.getString("uye_resim");
				model.addAttribute("klresim",klresim);
			
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "profil";
	}
}
