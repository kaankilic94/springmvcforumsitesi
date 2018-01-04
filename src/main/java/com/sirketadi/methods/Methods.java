package com.sirketadi.methods;



import java.io.File;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.springframework.web.multipart.MultipartFile;

import com.sirketadi.database.DB;
import com.sirketadi.enums.KategoriE;
import com.sirketadi.enums.KonuE;
import com.sirketadi.enums.Uye;
import com.sirketadi.ozellikler.Kategori;
import com.sirketadi.ozellikler.Konu;
import com.sirketadi.ozellikler.Kullanici;
import com.sirketadi.ozellikler.Mesaj;
import com.sirketadi.ozellikler.Yorum;

public class Methods {

	public String getHash(String md5) {
		try {
			java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
			byte[] array = md.digest(md5.getBytes());
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < array.length; ++i) {
				sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
			}
			return sb.toString();
		} catch (java.security.NoSuchAlgorithmException e) {
		}
		return null;
	}
	
	public int sayfaSayisi() {
		DB db2 = new DB();
		String qString  = "SELECT COUNT(konu_id) as c FROM konular WHERE konu_durum=1";
		PreparedStatement ps2 = db2.preBaglan(qString);
		double toplam = 0;
		double limit = 2;
		try {
			ResultSet rs2 = ps2.executeQuery();
			if (rs2.next()) {
				toplam = rs2.getDouble("c");
			}
		} catch (Exception e) {
			System.err.println("Sayfalama hata: " + e);
		}
		int sayfa_sayisi = (int) Math.ceil((toplam/limit));
		return sayfa_sayisi;
	}

	public ArrayList<Konu> konuListele(String sayfa) {
		ArrayList<Konu> ls = new ArrayList<Konu>();

		
		int limit = 2;
		int goster = Integer.valueOf(sayfa)*limit-limit;
		

		//sayfalamabitis
		
		DB db = new DB();
		String query = "SELECT *, date(konu_tarih) as tarih FROM konular as k INNER JOIN  kategoriler as kat ON k.konu_kategori=kat.kategori_id INNER JOIN uyeler as u ON u.uye_adi=k.konu_ekleyen and date(konu_tarih)"
				+ "  WHERE konu_durum=1 ORDER BY konu_tarih DESC LIMIT "+goster+","+limit+"";
		PreparedStatement ps = db.preBaglan(query);
		try {
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Konu k = new Konu();
				k.setKid(rs.getString("" + KonuE.konu_id));
				
				DB db2 = new DB();
				String q = "select COUNT(yorum_konu_id) as c from yorumlar where yorum_konu_id=? and yorum_onay=?";
				PreparedStatement ps2 = db2.preBaglan(q);
				ps2.setString(1, rs.getString("" + KonuE.konu_id));
				ps2.setString(2, "1");
				try {
					ResultSet rs2 = ps2.executeQuery();
					while (rs2.next()) {
						k.setKyorumsayisi(rs2.getString("c"));
					}
				} catch (Exception e) {
					System.err.println("Yorum sayisi hata: " + e);
				}finally {
					db2.kapat();
				}
				
				k.setKbaslik(rs.getString("" + KonuE.konu_baslik));
				k.setKaciklama(Jsoup.parse(rs.getString("" + KonuE.konu_aciklama)).text().substring(0, 300));
				k.setKekleyen(rs.getString("uye_id"));
				k.setKekleyenadi(rs.getString(""+KonuE.konu_ekleyen));
				k.setKtarih(rs.getString("" + KonuE.tarih));
				k.setKkategori(rs.getString("" + KategoriE.kategori_adi));
				k.setKkategoriId(rs.getString("" + KonuE.konu_kategori));
				k.setKdurum(rs.getString("" + KonuE.konu_durum));
				k.setKhit(rs.getString("" + KonuE.konu_hit));
				k.setKresim(rs.getString("" + KonuE.konu_resim));

				ls.add(k);

			}
		} catch (Exception e) {
			System.err.println("Konu Getirme Hatasi:" + e);
		} finally {
			db.kapat();
		}

		return ls;
	}

	public ArrayList<Kategori> kategoriListele() {
		ArrayList<Kategori> ls = new ArrayList<Kategori>();

		DB db = new DB();
		String query = "CALL kategoriGetir()";
		PreparedStatement ps = db.preBaglan(query);
		try {
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Kategori k = new Kategori();
				k.setKatid(rs.getString("" + KategoriE.kategori_id));
				k.setKatadi(rs.getString("" + KategoriE.kategori_adi));
				k.setKataciklama(rs.getString("" + KategoriE.kategori_aciklama));
				ls.add(k);

			}
		} catch (Exception e) {
			System.err.println("Kategori Getirme Hatasi:" + e);
		} finally {
			db.kapat();
		}

		return ls;
	}

	public ArrayList<Konu> kategoriKonuGetir(String id) {
		ArrayList<Konu> ls = new ArrayList<Konu>();

		DB db = new DB();
		String query = "CALL kategoriKonuGetir(?)";
		PreparedStatement ps = db.preBaglan(query);

		try {
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Konu k = new Konu();
				k.setKid(rs.getString("" + KonuE.konu_id));
				k.setKbaslik(rs.getString("" + KonuE.konu_baslik));
				k.setKaciklama(rs.getString("" + KonuE.konu_aciklama).substring(0, 300));
				k.setKekleyen(rs.getString("" + KonuE.konu_ekleyen));
				k.setKtarih(rs.getString("" + KonuE.tarih));
				k.setKkategori(rs.getString("" + KategoriE.kategori_adi));
				k.setKkategoriId(rs.getString("" + KonuE.konu_kategori));
				k.setKdurum(rs.getString("" + KonuE.konu_durum));
				k.setKhit(rs.getString("" + KonuE.konu_hit));
				k.setKresim(rs.getString("" + KonuE.konu_resim));
				ls.add(k);

			}
		} catch (Exception e) {
			System.err.println("Kategori Konulari Getirme Hatasi:" + e);
		} finally {
			db.kapat();

		}

		return ls;
	}

	public ArrayList<Konu> devam(String id) {
		ArrayList<Konu> ls = new ArrayList<Konu>();

		DB db = new DB();
		String query = "CALL devam(?)";

		PreparedStatement ps = db.preBaglan(query);
		try {
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Konu k = new Konu();
				k.setKid(rs.getString("" + KonuE.konu_id));
				
				DB db2 = new DB();
				String q = "select COUNT(yorum_konu_id) as c from yorumlar where yorum_konu_id=? and yorum_onay=?";
				PreparedStatement ps2 = db2.preBaglan(q);
				ps2.setString(1, rs.getString("" + KonuE.konu_id));
				ps2.setString(2, "1");
				try {
					ResultSet rs2 = ps2.executeQuery();
					while (rs2.next()) {
						k.setKyorumsayisi(rs2.getString("c"));
					}
				} catch (Exception e) {
					System.err.println("Yorum sayisi hata: " + e);
				}finally {
					db2.kapat();
				}
				
				k.setKbaslik(rs.getString("" + KonuE.konu_baslik));
				k.setKaciklama(rs.getString("" + KonuE.konu_aciklama));
				k.setKekleyen(rs.getString("" + KonuE.konu_ekleyen));
				k.setKtarih(rs.getString("" + KonuE.tarih));
				k.setKkategori(rs.getString("" + KategoriE.kategori_adi));
				k.setKkategoriId(rs.getString("" + KonuE.konu_kategori));
				k.setKdurum(rs.getString("" + KonuE.konu_durum));
				k.setKhit(rs.getString("" + KonuE.konu_hit));
				k.setKresim(rs.getString("" + KonuE.konu_resim));
				ls.add(k);

			}
		} catch (Exception e) {
			System.err.println("Devam hata:" + e);
		} finally {
			db.kapat();
		}

		return ls;

	}

	public String konuEkle(String baslik, String aciklama, String kategori, String resim, String ekleyen) {

		String mesaj = "";
		DB db = new DB();
		DB db2 = new DB();
		String query = "INSERT INTO konular SET konu_baslik=?, konu_aciklama=?, konu_kategori=?, konu_resim=?, konu_ekleyen=? ";
		PreparedStatement ps = db.preBaglan(query);
		try {

			String q = "SELECT * FROM konular";
			PreparedStatement ps2 = db2.preBaglan(q);
			ResultSet rs2 = ps2.executeQuery();
			while (rs2.next()) {

				if (baslik.equals(rs2.getString("konu_baslik"))) {
					mesaj = "Bu başlık daha önce kullanılmış";
					return mesaj;
				}

			}

			if (baslik.trim().equals("") || aciklama.trim().equals("") || resim.trim().equals("")) {
				mesaj = "Lütfen boş alan bırakmayınız";
				return mesaj;
			} else {
				ps.setString(1, baslik);
				ps.setString(2, aciklama);
				ps.setString(3, kategori);
				ps.setString(4, resim);
				ps.setString(5, ekleyen);
				int ekle = ps.executeUpdate();
				if (ekle > 0) {
					mesaj = "Ekleme başarılı";
					return mesaj;
				} else {
					mesaj = "Ekleme sırasında bir hata oluştu";
					return mesaj;
				}
			}

		} catch (Exception e) {
			System.err.println("Ekleme Hatasi: " + e);
		} finally {
			db.kapat();
			db2.kapat();
		}

		return "";
	}

	public ArrayList<Kullanici> kullaniciBilgi(String id) {

		ArrayList<Kullanici> ls = new ArrayList<Kullanici>();
		String query = "SELECT * FROM uyeler WHERE uye_id = ?";
		DB db = new DB();

		try {
			PreparedStatement ps = db.preBaglan(query);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				Kullanici k = new Kullanici();
				k.setAdi(rs.getString("" + Uye.uye_adi));
				k.setDogum(rs.getString("" + Uye.uye_dogum));
				k.setFacebook(rs.getString("" + Uye.uye_facebook));
				k.setHakkimda(rs.getString("" + Uye.uye_hakkimda));
				k.setId(rs.getString("" + Uye.uye_id));
				k.setMail(rs.getString("" + Uye.uye_eposta));
				k.setResim(rs.getString("" + Uye.uye_resim));
				k.setSehir(rs.getString("" + Uye.uye_sehir));
				k.setTwitter(rs.getString("" + Uye.uye_twitter));
				ls.add(k);
			}
		} catch (Exception e) {
			System.err.println("kullaniciBilgi Hata: " + e);
		}

		return ls;

	}

	public String kullaniciUpdate(String id, String mail, String resim, String fcb, String twt, String sehir,
			String dogum, String hakkimda) {

		String query = "UPDATE uyeler SET uye_eposta = ?, uye_resim = ?, uye_facebook = ?, uye_twitter = ?, uye_sehir = ?, uye_dogum = ?, uye_hakkimda = ? WHERE uye_id = ?";
		DB db = new DB();

		try {
			if (mail.trim().equals("") || resim.trim().equals("") || sehir.trim().equals("")
					|| dogum.trim().equals("")) {
				return "Lütfen boş olan bırakmayınız.";
			}
			PreparedStatement ps = db.preBaglan(query);
			ps.setString(1, mail.trim());
			ps.setString(2, resim.trim());
			ps.setString(3, fcb.trim());
			ps.setString(4, twt.trim());
			ps.setString(5, sehir.trim());
			ps.setString(6, dogum.trim());
			ps.setString(7, hakkimda.trim());
			ps.setString(8, id);
			int upt = ps.executeUpdate();
			if (upt > 0) {
				return "Başarıyla güncellendi.";
			} else {
				return "Güncellenirken bir hata oluştu.";
			}
		} catch (Exception e) {
			System.err.println("Update Hata: " + e);
		}

		return "";
	}

	public String kayitEkle(String mail, String resim, String fcb, String twt, String sehir, String dogum,
			String hakkimda, String parola, String parolatekrar, String kladi) {

		String query = "INSERT INTO uyeler (uye_adi, uye_parola, uye_eposta, uye_hakkimda, uye_sehir, uye_dogum, uye_facebook, uye_twitter, uye_resim) VALUES (?,?,?,?,?,?,?,?,?) ";
		DB db = new DB();
		DB db2 = new DB();

		try {
			if (kladi.trim().equals("") || parola.trim().equals("") || parolatekrar.trim().equals("")
					|| mail.trim().equals("") || dogum.trim().equals("") || resim.trim().equals("")) {
				return "Lütfen zorunlu yerleri doldurun.";
			} else if (!parola.trim().equals(parolatekrar.trim())) {
				return "Parola ve parola tekrarı uyuşmuyor";
			}

			PreparedStatement ps = db.preBaglan("SELECT uye_adi FROM uyeler");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				if (kladi.equals(rs.getString("" + Uye.uye_adi))) {
					return "Bu kullanıcı adı daha önce alınmış.";
				}
			}

			PreparedStatement ps2 = db2.preBaglan(query);
			ps2.setString(1, kladi);
			ps2.setString(2, getHash(parola));
			ps2.setString(3, mail);
			ps2.setString(4, hakkimda);
			ps2.setString(5, sehir);
			ps2.setString(6, dogum);
			ps2.setString(7, fcb);
			ps2.setString(8, twt);
			ps2.setString(9, resim);
			int ekle = ps2.executeUpdate();

			if (ekle > 0) {
				return "Başarıyla kayıt oldunuz.";
			} else {
				return "Kayıt başarısız.";
			}

		} catch (Exception e) {
			System.err.println("Kayit Hata: " + e);
		} finally {
			db.kapat();
			db2.kapat();
		}

		return "";

	}

	public String parolaDegis(String id, String parolaeski, String parolayeni, String parolayenitekrar) {

		String query = "SELECT uye_parola FROM uyeler WHERE uye_id = ?";
		DB db = new DB();
		DB db2 = new DB();

		if (parolaeski.trim().equals("") || parolayeni.trim().equals("") || parolayenitekrar.trim().equals("")) {
			return "Boş alan bırakmayın";
		}

		try {
			PreparedStatement ps = db.preBaglan(query);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				if (!getHash(parolaeski).trim().equals(rs.getString("" + Uye.uye_parola))) {
					return "Eski parola doğru değil";
				}
			}

			if (!parolayeni.trim().equals(parolayenitekrar.trim())) {
				return "Yeni parolalar uyuşmuyor";
			} else {
				String q = "UPDATE uyeler SET uye_parola = ? WHERE uye_id = ?";
				PreparedStatement ps2 = db2.preBaglan(q);
				ps2.setString(1, getHash(parolayeni));
				ps2.setString(2, id);
				int upt = ps2.executeUpdate();

				if (upt > 0) {
					return "Parola başarıyla güncellendi";
				} else {
					return "Parola güncellenemedi";
				}
			}
		} catch (Exception e) {
			System.err.println("parola degis hata: " + e);
		} finally {
			db.kapat();
			db2.kapat();
		}

		return "";
	}

	public ArrayList<Konu> arama(String yazi) {

		ArrayList<Konu> ls = new ArrayList<Konu>();
		String query = "CALL arama(?)";
		DB db = new DB();

		try {

			PreparedStatement ps = db.preBaglan(query);
			ps.setString(1, yazi);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Konu k = new Konu();
				k.setKid(rs.getString("" + KonuE.konu_id));
				k.setKbaslik(rs.getString("" + KonuE.konu_baslik));
				k.setKaciklama(Jsoup.parse(rs.getString("" + KonuE.konu_aciklama)).text().substring(0, 300));
				k.setKekleyen(rs.getString("" + KonuE.konu_ekleyen));
				k.setKtarih(rs.getString("" + KonuE.tarih));
				k.setKkategori(rs.getString("" + KategoriE.kategori_adi));
				k.setKkategoriId(rs.getString("" + KonuE.konu_kategori));
				k.setKdurum(rs.getString("" + KonuE.konu_durum));
				k.setKhit(rs.getString("" + KonuE.konu_hit));
				k.setKresim(rs.getString("" + KonuE.konu_resim));
				ls.add(k);
			}
		} catch (Exception e) {
			System.err.println("Ara hata: " + e);
		}

		return ls;

	}

	public ArrayList<Mesaj> mesajlar(String id) {
		ArrayList<Mesaj> ls = new ArrayList<Mesaj>();

		String query = "SELECT *, date(mesaj_tarih) as tarih FROM mesajlar WHERE mesaj_kime = ? ORDER BY mesaj_id DESC";
		DB db = new DB();

		try {
			PreparedStatement ps = db.preBaglan(query);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Mesaj m = new Mesaj();
				m.setMid(rs.getString("mesaj_id"));
				m.setMbaslik(rs.getString("mesaj_baslik"));
				m.setMaciklama(rs.getString("mesaj_aciklama"));
				m.setMgonderen(rs.getString("mesaj_gonderen"));
				m.setMkime(rs.getString("mesaj_kime"));
				m.setMtarih(rs.getString("tarih"));
				m.setMokunma(rs.getString("mesaj_okunma"));
				ls.add(m);
			}
		} catch (Exception e) {
			System.err.println("Mesajlar Hata: " + e);
		}

		return ls;
	}

	public ArrayList<Mesaj> mesajoku(String id, String sessionid) {
		ArrayList<Mesaj> ls = new ArrayList<Mesaj>();

		String query = "SELECT *, date(mesaj_tarih) as tarih FROM mesajlar WHERE mesaj_id = ? and mesaj_kime=?";
		DB db = new DB();

		try {
			PreparedStatement ps = db.preBaglan(query);
			ps.setString(1, id);
			ps.setString(2, sessionid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Mesaj m = new Mesaj();
				m.setMid(rs.getString("mesaj_id"));
				m.setMbaslik(rs.getString("mesaj_baslik"));
				m.setMaciklama(rs.getString("mesaj_aciklama"));
				m.setMgonderen(rs.getString("mesaj_gonderen"));
				m.setMkime(rs.getString("mesaj_kime"));
				m.setMtarih(rs.getString("tarih"));
				m.setMokunma(rs.getString("mesaj_okunma"));
				ls.add(m);
			}
		} catch (Exception e) {
			System.err.println("Mesaj Oku Hata: " + e);
		} finally {
			db.kapat();
		}

		return ls;
	}

	public String mesajGonder(String kime, String baslik, String mesaj, String gonderen) {

		String query = "SELECT uye_id FROM uyeler WHERE uye_adi=?";
		String q = "INSERT INTO mesajlar SET mesaj_baslik=?, mesaj_aciklama=?, mesaj_gonderen=?, mesaj_kime=?";
		String sorgu = "SELECT COUNT(uye_id) as count FROM uyeler WHERE uye_adi=?";
		DB db = new DB();
		DB db2 = new DB();
		DB db3 = new DB();
		String uye_id = "";
		String count = "";

		try {
			PreparedStatement ps = db3.preBaglan(sorgu);
			ps.setString(1, kime);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				count = rs.getString("count");
			}

		} catch (Exception e) {
			System.err.println("mesaj sayisi hata: " + e);
		} finally {
			db3.kapat();
		}

		try {

			if (count.equals("0")) {
				return kime + " adlı üye sistemde kayıtlı değil";
			}
			if (kime.equals("") || baslik.equals("") || mesaj.equals("")) {
				return "Lütfen boş alan bırakmayın";
			} else {
				PreparedStatement ps = db.preBaglan(query);
				ps.setString(1, kime);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					uye_id = rs.getString("" + Uye.uye_id);
				}

				PreparedStatement ps2 = db2.preBaglan(q);
				ps2.setString(1, baslik);
				ps2.setString(2, mesaj);
				ps2.setString(3, gonderen);
				ps2.setString(4, uye_id);
				int upt = ps2.executeUpdate();
				if (upt > 0) {
					return "Mesaj başarıyla gönderildi";
				} else {
					return "Mesaj gönderilemedi lütfen tekrar deneyin";
				}
			}

		} catch (Exception e) {
			System.err.println("mesajGonder Hata: " + e);
		} finally {
			db.kapat();
			db2.kapat();
		}

		return "";
	}

	public String mesajSayisi(String id) {

		String query = "SELECT COUNT(mesaj_id) as count FROM mesajlar WHERE mesaj_kime=? and mesaj_okunma=?";
		DB db = new DB();

		try {
			PreparedStatement ps = db.preBaglan(query);
			ps.setString(1, id);
			ps.setString(2, "0");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getString("count");
			}

		} catch (Exception e) {
			System.err.println("mesajSayisi Hata: " + e);
		}

		return "";
	}

	public String mesajSil(String mesajId, String uyeId) {

		String query = "DELETE FROM mesajlar WHERE mesaj_id=? and mesaj_kime=?";
		DB db = new DB();

		try {
			PreparedStatement ps = db.preBaglan(query);
			ps.setString(1, mesajId);
			ps.setString(2, uyeId);
			int dlt = ps.executeUpdate();

		} catch (Exception e) {
			System.err.println("mesajSilme Hata: " + e);
		}

		return "";
	}

	public ArrayList<Yorum> yorumlar(String ykid) {

		ArrayList<Yorum> ls = new ArrayList<Yorum>();

		String query = "SELECT *, date(yorum_tarih) as tarih FROM yorumlar as y INNER JOIN uyeler as u  ON y.yorum_ekleyen = u.uye_id WHERE yorum_konu_id = ? and yorum_onay = ?";
		DB db = new DB();

		try {
			PreparedStatement ps = db.preBaglan(query);
			ps.setString(1, ykid);
			ps.setString(2, "1");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Yorum y = new Yorum();

				y.setYid(rs.getString("yorum_id"));
				y.setYekleyen(rs.getString("uye_adi"));
				y.setYmesaj(rs.getString("yorum_mesaj"));
				y.setYtarih(rs.getString("tarih"));
				y.setYkresim(rs.getString("uye_resim"));
				y.setYkid(rs.getString("uye_id"));

				ls.add(y);
			}
		} catch (Exception e) {
			System.err.println("yorumlar Hata: " + e);
		}

		return ls;

	}

	public String yorumEkle(String konuid, String ekleyenid, String mesaj) {

		String query = "INSERT INTO yorumlar SET yorum_ekleyen = ?, yorum_mesaj=?, yorum_konu_id=?";
		DB db = new DB();
		
		if(mesaj.trim().equals("")) {
			return "Lütfen yorum giriniz.";
		}
		
		try {
			PreparedStatement ps = db.preBaglan(query);
			ps.setString(1, ekleyenid);
			ps.setString(2, mesaj);
			ps.setString(3, konuid);
			
			int ekle = ps.executeUpdate();
			if(ekle>0) {
				return "Yorum gönderildi.";
			}else {
				return "Yorum gönderilemedi.";
			}
		} catch (Exception e) {
			System.err.println("Yorum ekleme HATA: " + e);
		}
		

		return "";
	}
	
	// covert multipartfile to file
	public File convert(MultipartFile multifile) {
		
		Random rand = new Random();

		int  n = rand.nextInt(10000) + 1;
		
		File file = new File("/Applications/XAMPP/xamppfiles/htdocs/resimler/" +n+".jpg");
		try {
			FileUtils.writeByteArrayToFile(file, multifile.getBytes());
			
		} catch (IOException e) {
			System.err.println("convert error: " + e);
			
		}
		
		return file;
		
	}
	

}
