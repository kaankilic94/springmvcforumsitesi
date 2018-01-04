package com.sirketadi.methods;

import static org.hamcrest.CoreMatchers.not;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.ietf.jgss.GSSContext;
import org.springframework.web.servlet.handler.WebRequestHandlerInterceptorAdapter;
import org.w3c.dom.ls.LSException;

import com.mysql.fabric.xmlrpc.base.Array;
import com.sirketadi.database.DB;
import com.sirketadi.enums.Uye;
import com.sirketadi.ozellikler.Kategori;
import com.sirketadi.ozellikler.Konu;
import com.sirketadi.ozellikler.Kullanici;
import com.sirketadi.ozellikler.Yorum;

public class AdminMethods {

	public String adminKontrol(HttpServletRequest req, String sayfa) {

		boolean kontrol = req.getSession().getAttribute("klId") == null;
		String klrutbe = (String) req.getSession().getAttribute("klRutbe");

		if (kontrol) {
			return "redirect:/1";
		} else if (klrutbe.equals("0")) {
			return "redirect:/1";
		} else {
			return "admin/" + sayfa;
		}

	}

	public ArrayList<Kullanici> uyeListele() {
		ArrayList<Kullanici> ls = new ArrayList<Kullanici>();

		String query = "SELECT *, date(uye_tarih) as tarih FROM uyeler";
		DB db = new DB();

		try {
			PreparedStatement ps = db.preBaglan(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				Kullanici k = new Kullanici();
				k.setAdi(rs.getString("" + Uye.uye_adi));
				k.setId(rs.getString("" + Uye.uye_id));
				k.setOnay(rs.getString("" + Uye.uye_onay));
				k.setTarih(rs.getString("tarih"));

				ls.add(k);

			}
		} catch (Exception e) {
			System.err.println("Uye Listeleme Hata:" + e);
		} finally {
			db.kapat();
		}

		return ls;

	}

	public String implode(String[] ids) {

		String implode = "";

		for (String item : ids) {
			implode = implode + item + ",";
		}

		implode = implode.substring(0, implode.length() - 1);

		return implode;
	}

	public void uyeSil(String ids) {
		String query = "delete from uyeler where uye_id in(" + ids + ")";
		DB db = new DB();

		try {
			PreparedStatement ps = db.preBaglan(query);
			ps.executeUpdate();
		} catch (Exception e) {
			System.err.println("Uye Silme hata: " + e);
		} finally {
			db.kapat();
		}

	}

	public void uyeOnay(String id) {
		String query = "SELECT uye_onay FROM uyeler WHERE uye_id = ?";
		DB db = new DB();
		String onay = "";

		try {
			PreparedStatement ps = db.preBaglan(query);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				onay = rs.getString("uye_onay");
			}
		} catch (Exception e) {
			System.err.println("uye onay select hata: " + e);
		} finally {
			db.kapat();
		}

		if (onay.equals("0")) {
			String q = "UPDATE uyeler SET uye_onay=? WHERE uye_id=?";
			DB db2 = new DB();

			try {
				PreparedStatement ps2 = db2.preBaglan(q);
				ps2.setString(1, "1");
				ps2.setString(2, id);
				ps2.executeUpdate();
			} catch (Exception e) {
				System.err.println("Uye onay 0 Hata: " + e);
			} finally {
				db2.kapat();
			}
		} else {
			String q = "UPDATE uyeler SET uye_onay=? WHERE uye_id=?";
			DB db2 = new DB();

			try {
				PreparedStatement ps2 = db2.preBaglan(q);
				ps2.setString(1, "0");
				ps2.setString(2, id);
				ps2.executeUpdate();
			} catch (Exception e) {
				System.err.println("Uye onay 1 Hata: " + e);
			} finally {
				db2.kapat();
			}
		}

	}

	public ArrayList<Kategori> kategoriListele() {
		ArrayList<Kategori> ls = new ArrayList<Kategori>();

		String query = "SELECT * FROM kategoriler";
		DB db = new DB();

		try {
			PreparedStatement ps = db.preBaglan(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Kategori k = new Kategori();
				k.setKataciklama(rs.getString("kategori_aciklama"));
				k.setKatadi(rs.getString("kategori_adi"));
				k.setKatid(rs.getString("kategori_id"));
				ls.add(k);
			}
		} catch (Exception e) {
			System.err.println("kategoriListele Hata: " + e);
		} finally {
			db.kapat();
		}

		return ls;
	}

	public void kategoriSil(String ids) {
		String query = "delete from kategoriler where kategori_id in(" + ids + ")";
		DB db = new DB();

		try {
			PreparedStatement ps = db.preBaglan(query);
			ps.executeUpdate();
		} catch (Exception e) {
			System.err.println("Kategori Silme hata: " + e);
		} finally {
			db.kapat();
		}

	}

	public void kategoriDuzenle(String id, String adi, String aciklama) {
		String query = "UPDATE kategoriler SET kategori_adi=?, kategori_aciklama=? WHERE kategori_id=?";
		DB db = new DB();

		try {
			PreparedStatement ps = db.preBaglan(query);
			ps.setString(1, adi);
			ps.setString(2, aciklama);
			ps.setString(3, id);
			ps.executeUpdate();
		} catch (Exception e) {
			System.err.println("kategori duzenle Hata: " + e);
		} finally {
			db.kapat();
		}
	}
	
	public void kategoriEkle(String adi, String aciklama) {
		String query = "INSERT INTO kategoriler SET kategori_adi=?, kategori_aciklama=? ";
		DB db = new DB();
		PreparedStatement ps = db.preBaglan(query);
		try {
			ps.setString(1, adi);
			ps.setString(2, aciklama);
			ps.executeUpdate();
		} catch (Exception e) {
			System.err.println("Kategori Ekleme Hatası: " + e);
		}finally {
			db.kapat();
		}
		
	}
	
	public ArrayList<Yorum> yorumListele() {
		
		ArrayList<Yorum> ls = new ArrayList<Yorum>();
		
		String query = "SELECT *,date(yorum_tarih) as tarih FROM yorumlar as y, uyeler as u, konular as k WHERE y.yorum_ekleyen=u.uye_id and y.yorum_konu_id=k.konu_id";
		DB db = new DB();

		try {
			PreparedStatement ps = db.preBaglan(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Yorum y = new Yorum();
				y.setYid(rs.getString("yorum_id"));
				y.setYekleyen(rs.getString("uye_adi"));
				y.setYtarih(rs.getString("tarih"));
				y.setYorumkonuadi(rs.getString("konu_baslik"));
				y.setYonay(rs.getString("yorum_onay"));
				ls.add(y);
			}
		} catch (Exception e) {
			System.err.println("yorumListele Hata: " + e);
		} finally {
			db.kapat();
		}
		
		return ls;
	}
	
	public void yorumSil(String ids) {
		String query = "delete from yorumlar where yorum_id in(" + ids + ")";
		DB db = new DB();

		try {
			PreparedStatement ps = db.preBaglan(query);
			ps.executeUpdate();
		} catch (Exception e) {
			System.err.println("Yorum Silme hata: " + e);
		} finally {
			db.kapat();
		}

	}
	
	public Yorum yorumOku(String id) {
		String query = "SELECT *, date(yorum_tarih) as tarih FROM yorumlar as y,uyeler as u WHERE u.uye_id = y.yorum_ekleyen and yorum_id=?";
		DB db = new DB();
		Yorum y = new Yorum();
		try {
			PreparedStatement ps = db.preBaglan(query);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
			   
			   y.setYmesaj(rs.getString("yorum_mesaj"));
			   y.setYkresim(rs.getString("uye_resim"));
			   y.setYtarih(rs.getString("tarih"));
			   y.setYekleyen(rs.getString("uye_adi"));
			}
		} catch (Exception e) {
			System.err.println("yorumoku HATA: " + e);
		}finally {
			db.kapat();
		}
		
		return y;
	}
	
	public void yorumOnay(String id) {
		String query = "SELECT yorum_onay FROM yorumlar WHERE yorum_id = ?";
		DB db = new DB();
		String onay = "";

		try {
			PreparedStatement ps = db.preBaglan(query);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				onay = rs.getString("yorum_onay");
			}
		} catch (Exception e) {
			System.err.println("yorum onay select hata: " + e);
		} finally {
			db.kapat();
		}

		if (onay.equals("0")) {
			String q = "UPDATE yorumlar SET yorum_onay=? WHERE yorum_id=?";
			DB db2 = new DB();

			try {
				PreparedStatement ps2 = db2.preBaglan(q);
				ps2.setString(1, "1");
				ps2.setString(2, id);
				ps2.executeUpdate();
			} catch (Exception e) {
				System.err.println("yorum onay 0 Hata: " + e);
			} finally {
				db2.kapat();
			}
		} else {
			String q = "UPDATE yorumlar SET yorum_onay=? WHERE yorum_id=?";
			DB db2 = new DB();

			try {
				PreparedStatement ps2 = db2.preBaglan(q);
				ps2.setString(1, "0");
				ps2.setString(2, id);
				ps2.executeUpdate();
			} catch (Exception e) {
				System.err.println("yorum onay 1 Hata: " + e);
			} finally {
				db2.kapat();
			}
		}

	}
	
	public ArrayList<Konu> konuListele(){
		ArrayList<Konu> ls = new ArrayList<Konu>();
		
		String query = "SELECT *, date(konu_tarih) as tarih FROM konular order by konu_tarih desc";
		DB db = new DB();
		
		try {
			PreparedStatement ps =  db.preBaglan(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Konu k = new Konu();
				k.setKid(rs.getString("konu_id"));
				k.setKbaslik(rs.getString("konu_baslik"));
				k.setKtarih(rs.getString("tarih"));
				k.setKekleyen(rs.getString("konu_ekleyen"));
				k.setKaciklama(rs.getString("konu_aciklama"));
				k.setKresim(rs.getString("konu_resim"));
				ls.add(k);
			}
		} catch (Exception e) {
			System.err.println("konuListele Hata: " + e);
		}finally {
			db.kapat();
		}
		
		return ls; 
	}
	
	public void konuSil(String ids) {
		String query = "delete from konular where konu_id in(" + ids + ")";
		DB db = new DB();

		try {
			PreparedStatement ps = db.preBaglan(query);
			ps.executeUpdate();
		} catch (Exception e) {
			System.err.println("Konu Silme hata: " + e);
		} finally {
			db.kapat();
		}

	}
	
	public Konu konuOku(String id) {
		String query = "SELECT * FROM konular WHERE konu_id=?";
		DB db = new DB();
		Konu k = new Konu();
		try {
			PreparedStatement ps = db.preBaglan(query);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
			   
				k.setKaciklama(rs.getString("konu_aciklama"));
				k.setKresim(rs.getString("konu_resim"));
			  
			}
		} catch (Exception e) {
			System.err.println("konumoku HATA: " + e);
		}finally {
			db.kapat();
		}
		
		return k;
	}

}
