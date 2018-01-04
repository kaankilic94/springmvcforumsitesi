package com.sirketadi.forum;

import static org.hamcrest.CoreMatchers.nullValue;

import java.sql.PreparedStatement;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sirketadi.database.DB;
import com.sirketadi.methods.Methods;

@Controller
public class DevamController {

	@RequestMapping(value = "/devam/{baslik}-{id}", method = RequestMethod.GET)
	public String devam(@PathVariable String id, HttpServletRequest req, HttpServletResponse res, Model model) {

		boolean durum = req.getSession().getAttribute("klId") != null;
		model.addAttribute("durum", durum);
		/////////////////////////////////////
		Methods methods = new Methods();
		model.addAttribute("lsdvm", methods.devam(id));
		model.addAttribute("katListe", methods.kategoriListele());

		String isim = (String) req.getSession().getAttribute("klAdi");
		model.addAttribute("isim", isim);
		String klid = (String) req.getSession().getAttribute("klId");
		model.addAttribute("klid", klid);
		String klrutbe = (String) req.getSession().getAttribute("klRutbe");
		model.addAttribute("klrutbe", klrutbe);

		model.addAttribute("count", new Methods().mesajSayisi(klid));

		// if(req.getCookies() != null) {
		// Cookie[] cDizi = req.getCookies();
		//
		// for (int i = 0; i < cDizi.length; i++) {
		// if (!cDizi[i].getName().equals("hit"+klid)) {
		// String query ="update konular set konu_hit = konu_hit+1 where konu_id=?";
		// DB db = new DB();
		// try {
		// PreparedStatement ps = db.preBaglan(query);
		// ps.setString(1, id);
		// ps.executeUpdate();
		// } catch (Exception e) {
		// System.err.println("Cookie Hata:" + e);
		// }
		//
		// break;
		// }
		// }
		// }
		//
		//
		//
		// Cookie cerez = new Cookie("hit"+klid, "-");
		// cerez.setMaxAge(31556926);
		// res.addCookie(cerez);

		model.addAttribute("yorumls", new Methods().yorumlar(id));

		int yorumcount = new Methods().yorumlar(id).size();

		model.addAttribute("yorumcount", yorumcount);
		model.addAttribute("konuid",id);

		return "devam";
	}

	@RequestMapping(value = "/yorumgonder/{id}", method = RequestMethod.POST)
	public String yorumgonder(@PathVariable String id, @RequestParam String yorum, HttpServletRequest req, HttpServletResponse res,
			Model model) {

		boolean durum = req.getSession().getAttribute("klId") != null;
		model.addAttribute("durum", durum);
		/////////////////////////////////////
		Methods methods = new Methods();
		model.addAttribute("lsdvm", methods.devam(id));
		model.addAttribute("katListe", methods.kategoriListele());

		String isim = (String) req.getSession().getAttribute("klAdi");
		model.addAttribute("isim", isim);
		String klid = (String) req.getSession().getAttribute("klId");
		model.addAttribute("klid", klid);
		String klrutbe = (String) req.getSession().getAttribute("klRutbe");
		model.addAttribute("klrutbe", klrutbe);

		model.addAttribute("count", new Methods().mesajSayisi(klid));
		model.addAttribute("yorumls", new Methods().yorumlar(id));

		int yorumcount = new Methods().yorumlar(id).size();

		model.addAttribute("yorumcount", yorumcount);
		model.addAttribute("konuid",id);
		
		new Methods().yorumEkle(id, klid, yorum);

		return "devam";
	}
	
	@RequestMapping(value = "/yorumgonder/{id}", method = RequestMethod.GET)
	public String yorumgonderget(@PathVariable String id, HttpServletRequest req, HttpServletResponse res,
			Model model) {

		boolean durum = req.getSession().getAttribute("klId") != null;
		model.addAttribute("durum", durum);
		/////////////////////////////////////
		Methods methods = new Methods();
		model.addAttribute("lsdvm", methods.devam(id));
		model.addAttribute("katListe", methods.kategoriListele());

		String isim = (String) req.getSession().getAttribute("klAdi");
		model.addAttribute("isim", isim);
		String klid = (String) req.getSession().getAttribute("klId");
		model.addAttribute("klid", klid);
		String klrutbe = (String) req.getSession().getAttribute("klRutbe");
		model.addAttribute("klrutbe", klrutbe);

		model.addAttribute("count", new Methods().mesajSayisi(klid));
		model.addAttribute("yorumls", new Methods().yorumlar(id));

		int yorumcount = new Methods().yorumlar(id).size();

		model.addAttribute("yorumcount", yorumcount);
		model.addAttribute("konuid",id);
		
		

		return "devam";
	}


}
