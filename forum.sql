/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 100128
 Source Host           : localhost:3306
 Source Schema         : forum

 Target Server Type    : MySQL
 Target Server Version : 100128
 File Encoding         : 65001

 Date: 05/01/2018 00:16:22
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for iller
-- ----------------------------
DROP TABLE IF EXISTS `iller`;
CREATE TABLE `iller` (
  `il_id` int(11) NOT NULL,
  `il_adi` varchar(45) COLLATE utf8_turkish_ci NOT NULL,
  PRIMARY KEY (`il_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

-- ----------------------------
-- Records of iller
-- ----------------------------
BEGIN;
INSERT INTO `iller` VALUES (1, 'Adana');
INSERT INTO `iller` VALUES (2, 'Adıyaman');
INSERT INTO `iller` VALUES (3, 'Afyonkarahisar');
INSERT INTO `iller` VALUES (4, 'Ağrı');
INSERT INTO `iller` VALUES (5, 'Amasya');
INSERT INTO `iller` VALUES (6, 'Ankara');
INSERT INTO `iller` VALUES (7, 'Antalya');
INSERT INTO `iller` VALUES (8, 'Artvin');
INSERT INTO `iller` VALUES (9, 'Aydın');
INSERT INTO `iller` VALUES (10, 'Balıkesir');
INSERT INTO `iller` VALUES (11, 'Bilecik');
INSERT INTO `iller` VALUES (12, 'Bingöl');
INSERT INTO `iller` VALUES (13, 'Bitlis');
INSERT INTO `iller` VALUES (14, 'Bolu');
INSERT INTO `iller` VALUES (15, 'Burdur');
INSERT INTO `iller` VALUES (16, 'Bursa');
INSERT INTO `iller` VALUES (17, 'Çanakkale');
INSERT INTO `iller` VALUES (18, 'Çankırı');
INSERT INTO `iller` VALUES (19, 'Çorum');
INSERT INTO `iller` VALUES (20, 'Denizli');
INSERT INTO `iller` VALUES (21, 'Diyarbakır');
INSERT INTO `iller` VALUES (22, 'Edirne');
INSERT INTO `iller` VALUES (23, 'Elâzığ');
INSERT INTO `iller` VALUES (24, 'Erzincan');
INSERT INTO `iller` VALUES (25, 'Erzurum');
INSERT INTO `iller` VALUES (26, 'Eskişehir');
INSERT INTO `iller` VALUES (27, 'Gaziantep');
INSERT INTO `iller` VALUES (28, 'Giresun');
INSERT INTO `iller` VALUES (29, 'Gümüşhane');
INSERT INTO `iller` VALUES (30, 'Hakkâri');
INSERT INTO `iller` VALUES (31, 'Hatay');
INSERT INTO `iller` VALUES (32, 'Isparta');
INSERT INTO `iller` VALUES (33, 'Mersin');
INSERT INTO `iller` VALUES (34, 'İstanbul');
INSERT INTO `iller` VALUES (35, 'İzmir');
INSERT INTO `iller` VALUES (36, 'Kars');
INSERT INTO `iller` VALUES (37, 'Kastamonu');
INSERT INTO `iller` VALUES (38, 'Kayseri');
INSERT INTO `iller` VALUES (39, 'Kırklareli');
INSERT INTO `iller` VALUES (40, 'Kırşehir');
INSERT INTO `iller` VALUES (41, 'Kocaeli');
INSERT INTO `iller` VALUES (42, 'Konya');
INSERT INTO `iller` VALUES (43, 'Kütahya');
INSERT INTO `iller` VALUES (44, 'Malatya');
INSERT INTO `iller` VALUES (45, 'Manisa');
INSERT INTO `iller` VALUES (46, 'Kahramanmaraş');
INSERT INTO `iller` VALUES (47, 'Mardin');
INSERT INTO `iller` VALUES (48, 'Muğla');
INSERT INTO `iller` VALUES (49, 'Muş');
INSERT INTO `iller` VALUES (50, 'Nevşehir');
INSERT INTO `iller` VALUES (51, 'Niğde');
INSERT INTO `iller` VALUES (52, 'Ordu');
INSERT INTO `iller` VALUES (53, 'Rize');
INSERT INTO `iller` VALUES (54, 'Sakarya');
INSERT INTO `iller` VALUES (55, 'Samsun');
INSERT INTO `iller` VALUES (56, 'Siirt');
INSERT INTO `iller` VALUES (57, 'Sinop');
INSERT INTO `iller` VALUES (58, 'Sivas');
INSERT INTO `iller` VALUES (59, 'Tekirdağ');
INSERT INTO `iller` VALUES (60, 'Tokat');
INSERT INTO `iller` VALUES (61, 'Trabzon');
INSERT INTO `iller` VALUES (62, 'Tunceli');
INSERT INTO `iller` VALUES (63, 'Şanlıurfa');
INSERT INTO `iller` VALUES (64, 'Uşak');
INSERT INTO `iller` VALUES (65, 'Van');
INSERT INTO `iller` VALUES (66, 'Yozgat');
INSERT INTO `iller` VALUES (67, 'Zonguldak');
INSERT INTO `iller` VALUES (68, 'Aksaray');
INSERT INTO `iller` VALUES (69, 'Bayburt');
INSERT INTO `iller` VALUES (70, 'Karaman');
INSERT INTO `iller` VALUES (71, 'Kırıkkale');
INSERT INTO `iller` VALUES (72, 'Batman');
INSERT INTO `iller` VALUES (73, 'Şırnak');
INSERT INTO `iller` VALUES (74, 'Bartın');
INSERT INTO `iller` VALUES (75, 'Ardahan');
INSERT INTO `iller` VALUES (76, 'Iğdır');
INSERT INTO `iller` VALUES (77, 'Yalova');
INSERT INTO `iller` VALUES (78, 'Karabük');
INSERT INTO `iller` VALUES (79, 'Kilis');
INSERT INTO `iller` VALUES (80, 'Osmaniye');
INSERT INTO `iller` VALUES (81, 'Düzce');
COMMIT;

-- ----------------------------
-- Table structure for kategoriler
-- ----------------------------
DROP TABLE IF EXISTS `kategoriler`;
CREATE TABLE `kategoriler` (
  `kategori_id` int(11) NOT NULL AUTO_INCREMENT,
  `kategori_adi` varchar(45) COLLATE utf8_turkish_ci NOT NULL,
  `kategori_aciklama` varchar(200) COLLATE utf8_turkish_ci NOT NULL,
  PRIMARY KEY (`kategori_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

-- ----------------------------
-- Records of kategoriler
-- ----------------------------
BEGIN;
INSERT INTO `kategoriler` VALUES (1, 'Java', 'Java Dersleri');
INSERT INTO `kategoriler` VALUES (2, 'Spring MVC', 'Spring Dersleri');
INSERT INTO `kategoriler` VALUES (5, 'PHP', 'php açıklama');
INSERT INTO `kategoriler` VALUES (6, 'HTML5', '');
INSERT INTO `kategoriler` VALUES (7, 'Javascript', '');
COMMIT;

-- ----------------------------
-- Table structure for konular
-- ----------------------------
DROP TABLE IF EXISTS `konular`;
CREATE TABLE `konular` (
  `konu_id` int(11) NOT NULL AUTO_INCREMENT,
  `konu_baslik` varchar(45) COLLATE utf8_turkish_ci NOT NULL,
  `konu_aciklama` text COLLATE utf8_turkish_ci NOT NULL,
  `konu_ekleyen` varchar(45) COLLATE utf8_turkish_ci NOT NULL,
  `konu_tarih` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `konu_kategori` int(11) NOT NULL DEFAULT '0',
  `konu_durum` int(11) NOT NULL DEFAULT '1',
  `konu_hit` int(11) NOT NULL DEFAULT '0',
  `konu_resim` varchar(300) COLLATE utf8_turkish_ci NOT NULL,
  PRIMARY KEY (`konu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

-- ----------------------------
-- Records of konular
-- ----------------------------
BEGIN;
INSERT INTO `konular` VALUES (15, 'Java(Programlama Dili)', '<p><span style=\"color:#c0392b\"><span style=\"font-size:48px\">JAVA</span></span></p>\r\n\r\n<p><strong>Java</strong>,&nbsp;<a href=\"http://www.wikizero.net/index.php?q=aHR0cHM6Ly90ci53aWtpcGVkaWEub3JnL3dpa2kvU3VuX01pY3Jvc3lzdGVtcw\" title=\"Sun Microsystems\">Sun Microsystems</a>&nbsp;<a href=\"http://www.wikizero.net/index.php?q=aHR0cHM6Ly90ci53aWtpcGVkaWEub3JnL3dpa2kvTSVDMyVCQ2hlbmRpc2xpaw\" title=\"Mühendislik\">m&uuml;hendislerinden</a>&nbsp;<a href=\"http://www.wikizero.net/index.php?q=aHR0cHM6Ly90ci53aWtpcGVkaWEub3JnL3cvaW5kZXgucGhwP3RpdGxlPUphbWVzX0dvc2xpbmcmYWN0aW9uPWVkaXQmcmVkbGluaz0x\" title=\"James Gosling (sayfa mevcut değil)\">James Gosling</a>&nbsp;tarafından geliştirilmeye başlanmış a&ccedil;ık&nbsp;<a href=\"http://www.wikizero.net/index.php?q=aHR0cHM6Ly90ci53aWtpcGVkaWEub3JnL3dpa2kvS29k\" title=\"Kod\">kodlu</a>, nesneye y&ouml;nelik, zeminden bağımsız, y&uuml;ksek verimli, &ccedil;ok işlevli, y&uuml;ksek seviye, adım adım işletilen (yorumlanan-interpreted) bir&nbsp;<a href=\"http://www.wikizero.net/index.php?q=aHR0cHM6Ly90ci53aWtpcGVkaWEub3JnL3dpa2kvUHJvZ3JhbWxhbWFfZGlsbGVyaQ\" title=\"Programlama dilleri\">dildir</a>.</p>\r\n\r\n<p>Java, Sun Microsystems&#39;den James Gosling tarafından geliştirilen bir programlama dilidir (Sun Microsystem&#39;in şu anda Oracle Corporation ile bağlı ortaklığı bulunmaktadır) ve 1995 yılında Sun Microsystems&#39;in &ccedil;ekirdek bileşeni olarak piyasaya s&uuml;r&uuml;lm&uuml;şt&uuml;r. Bu dil C ve C++&#39;dan bir&ccedil;ok s&ouml;zdizim t&uuml;retmesine rağmen bu t&uuml;revler daha basit nesne modeli ve daha az d&uuml;ş&uuml;k seviye olanaklar i&ccedil;erir. Java uygulamaları bilgisayar mimarisine bağlı olmadan herhangi bir Java Virtual Machine (JVM)&#39;de &ccedil;alışabilen tipik bytecode&#39;dur (sınıf dosyası).</p>\r\n\r\n<p>Java&#39;nın sık kullanılan sloganlarından biri olan, &ccedil;evirisi &quot;bir defa yaz, her yerde &ccedil;alıştır&quot; olan &quot;write once, run anywhere&quot; (WORA),<sup><a href=\"http://www.wikizero.net/index.php?q=aHR0cHM6Ly90ci53aWtpcGVkaWEub3JnL3dpa2kvSmF2YV8ocHJvZ3JhbWxhbWFfZGlsaSkjY2l0ZV9ub3RlLTE\">[1]</a></sup>&nbsp;Java&#39;nın derlenmiş Java kodunun Java&#39;yı destekleyen b&uuml;t&uuml;n platformlarda tekrar derlenmeye ihtiyacı olmadan &ccedil;alışabileceğini ima eder.<sup><a href=\"http://www.wikizero.net/index.php?q=aHR0cHM6Ly90ci53aWtpcGVkaWEub3JnL3dpa2kvSmF2YV8ocHJvZ3JhbWxhbWFfZGlsaSkjY2l0ZV9ub3RlLTI\">[2]</a></sup>&nbsp;2016 yılında bildirilen 9 milyon geliştiricisi ile, &ouml;zellikle istemci sunucu web uygulamaları i&ccedil;in olmak &uuml;zere, kullanımda olan en pop&uuml;ler programlama dillerinden birisidir.<sup><a href=\"http://www.wikizero.net/index.php?q=aHR0cHM6Ly90ci53aWtpcGVkaWEub3JnL3dpa2kvSmF2YV8ocHJvZ3JhbWxhbWFfZGlsaSkjY2l0ZV9ub3RlLTM\">[3]</a></sup><sup><a href=\"http://www.wikizero.net/index.php?q=aHR0cHM6Ly90ci53aWtpcGVkaWEub3JnL3dpa2kvSmF2YV8ocHJvZ3JhbWxhbWFfZGlsaSkjY2l0ZV9ub3RlLTQ\">[4]</a></sup><sup><a href=\"http://www.wikizero.net/index.php?q=aHR0cHM6Ly90ci53aWtpcGVkaWEub3JnL3dpa2kvSmF2YV8ocHJvZ3JhbWxhbWFfZGlsaSkjY2l0ZV9ub3RlLTU\">[5]</a></sup><sup><a href=\"http://www.wikizero.net/index.php?q=aHR0cHM6Ly90ci53aWtpcGVkaWEub3JnL3dpa2kvSmF2YV8ocHJvZ3JhbWxhbWFfZGlsaSkjY2l0ZV9ub3RlLTY\">[6]</a></sup></p>\r\n\r\n<p>Java ilk &ccedil;ıktığında daha &ccedil;ok k&uuml;&ccedil;&uuml;k cihazlarda kullanılmak i&ccedil;in tasarlanmış ortak bir d&uuml;zlem dili olarak d&uuml;ş&uuml;n&uuml;lm&uuml;şt&uuml;. Ancak d&uuml;zlem bağımsızlığı &ouml;zelliği ve tekbi&ccedil;im k&uuml;t&uuml;phane desteği&nbsp;<a href=\"http://www.wikizero.net/index.php?q=aHR0cHM6Ly90ci53aWtpcGVkaWEub3JnL3dpa2kvQ19wcm9ncmFtbGFtYV9kaWxp\" title=\"C programlama dili\">C</a>&nbsp;ve&nbsp;<a href=\"http://www.wikizero.net/index.php?q=aHR0cHM6Ly90ci53aWtpcGVkaWEub3JnL3dpa2kvQyUyQiUyQg\" title=\"C++\">C++</a>&#39;tan &ccedil;ok daha &uuml;st&uuml;n ve g&uuml;venli bir yazılım geliştirme ve işletme ortamı sunduğundan, hemen her yerde kullanılmaya başlanmıştır. Şu anda &ouml;zellikle kurumsal alanda ve mobil cihazlarda son derece pop&uuml;ler olan Java &ouml;zellikle J2SE 1.4 ve 5 s&uuml;r&uuml;m&uuml; ile masa&uuml;st&uuml; uygulamalarda da yaygınlaşmaya başlamıştır. Java&#39;nın ilk s&uuml;r&uuml;m&uuml; olan Java 1.0 (1995) Java Platform 1 olarak adlandırıldı ve tasarlama amacına uygun olarak k&uuml;&ccedil;&uuml;k boyutlu ve kısıtlı &ouml;zelliklere sahipti. Daha sonra d&uuml;zlemin g&uuml;c&uuml; g&ouml;zlendi ve tasarımında b&uuml;y&uuml;k değişiklikler ve eklemeler yapıldı. Bu b&uuml;y&uuml;k değişikliklerden dolayı geliştirilen yeni d&uuml;zleme Java Platform 2 adı verildi ama s&uuml;r&uuml;m numarası 2 yapılmadı, 1.2 olarak devam etti. 2004 sonbaharında &ccedil;ıkan Java 5, ge&ccedil;miş 1.2, 1.3 ve 1.4 s&uuml;r&uuml;mlerinin ardından en &ccedil;ok gelişme ve değişikliği barındıran s&uuml;r&uuml;m oldu. Java SE 8 ise Java teknolojisinin g&uuml;n&uuml;m&uuml;z s&uuml;r&uuml;m&uuml;d&uuml;r.&nbsp;<a href=\"http://www.wikizero.net/index.php?q=aHR0cHM6Ly90ci53aWtpcGVkaWEub3JnL3dpa2kvMTNfS2FzJUM0JUIxbQ\" title=\"13 Kasım\">13 Kasım</a>&nbsp;<a href=\"http://www.wikizero.net/index.php?q=aHR0cHM6Ly90ci53aWtpcGVkaWEub3JnL3dpa2kvMjAwNg\" title=\"2006\">2006</a>&#39;da Java d&uuml;zlemi&nbsp;<a href=\"http://www.wikizero.net/index.php?q=aHR0cHM6Ly90ci53aWtpcGVkaWEub3JnL3dpa2kvR1BM\" title=\"GPL\">GPL</a>&nbsp;ruhsatıyla a&ccedil;ık kodlu hale gelmiştir.</p>\r\n', 'kaan', '2018-01-04 13:48:57', 1, 1, 0, '9970.jpg');
INSERT INTO `konular` VALUES (16, 'Spring MVC', '<p><span style=\"font-size:36px\"><strong><span style=\"color:#1abc9c\">Spring MVC</span></strong></span>&nbsp;</p>\r\n\r\n<p><strong>Model View Controller</strong>&nbsp;yapısını kullanarak Spring Framework ile birlikte web tabanlı projeler yapmaya imkan sağlamaktadır. Spring&rsquo;in bir mod&uuml;l&uuml; olan Spring MVC ile işlemleri kolaylaştırarak web projeleri yapabilmekteyiz.</p>\r\n\r\n<p>MVC yapısı ayrı bir yazı konusu olduğu i&ccedil;in kısa ve kabaca ş&ouml;yle a&ccedil;ıklayayım. Uygulama verileri&nbsp;<strong>Model</strong>katmanında, kullanıcının g&ouml;r&uuml;nt&uuml;lenmesini istediğimiz web sayfalarını&nbsp;<strong>View</strong>&nbsp;katmanında ve bunun arasındaki iş ve işlemlerin yapılacak katman ise&nbsp;<strong>Controller</strong>&nbsp;katmanıdır.</p>\r\n\r\n<p>Spring MVC&rsquo;nin &ccedil;alışma yapısına bakalım. Spring Framework bu freamework ile biz bir web sayfası yapacağız. Bu web sayfası g&uuml;n&uuml;n sonunda Java tarafından derlenecektir. Java tarafından derlenen her bu sayfa bir Servlet&rsquo;tir. Kısacası Spring MVC ile kodladığımız proje bir Servlete d&ouml;n&uuml;şmektedir.</p>\r\n', 'kaan', '2018-01-04 23:09:02', 2, 1, 0, '8931.jpg');
INSERT INTO `konular` VALUES (17, 'HTLM5 bazı taglar ve işlevleri', '<p><strong>DOCTYPE</strong></p>\r\n\r\n<p>DOCTYPE(D&ouml;k&uuml;man T&uuml;r&uuml;) kısacası sayfamızın ne olduğunu tanımladığımız tag. Mutlaka tanımlamamız gereken bir tag&rsquo;dır. &Ccedil;&uuml;nk&uuml; burda yapacağımız tanımlamaya g&ouml;re tarayıcı sayfamızı yorumlayacaktır.</p>\r\n\r\n<p>&Ouml;rnek Kullanımı:</p>\r\n\r\n<pre>\r\n&lt;!DOCTYPE html&gt;</pre>\r\n\r\n<p><strong>CHARSET</strong></p>\r\n\r\n<p>Tarayıcıların sayfamızı hangi karakter seti ile yorumlaması gerektiğini tanımladığımız tag.</p>\r\n\r\n<p>&Ouml;rnek Kullanımı:</p>\r\n\r\n<pre>\r\n&lt;meta charset=&quot;utf-8&quot;&gt;</pre>\r\n\r\n<p><strong>HEADER</strong></p>\r\n\r\n<p>Header tag&rsquo;ı bundan &ouml;nceki tagler den biraz farklı &ccedil;&uuml;nk&uuml; header tag&rsquo;i ile herhangi bir bilgiyi deklere etmiyoruz. Bir konteynır olarak tanımlıyoruz.</p>\r\n\r\n<p>Peki bu konyetnır&rsquo;ın i&ccedil;ine ne koyuyoruz? Genel de i&ccedil;erisine ana navigasyon linkleri konulur. Peki neden header tagı i&ccedil;erisine koyuyoruz? Semantic web(Anlamsal web) ge&ccedil;iş yapmamızı sağlıyor header tag&rsquo;i. Arama motorları bu taglari ne olduğunu bildiği i&ccedil;in i&ccedil;indeki elementlere bir anlam veriyor ve daha iyi bir arama algoritması kurabiliyor. Bu sayede daha fazla ziyaret&ccedil;i elde etmemizi sağlayabiliriz.</p>\r\n\r\n<p>&Ouml;rnek Kullanımı</p>\r\n\r\n<pre>\r\n&lt;header&gt;\r\n&lt;nav&gt;\r\n&lt;ul&gt;\r\n&lt;li&gt;&lt;a href=&quot;#&quot;&gt;Ana Sayfa&lt;/a&gt;&lt;/li&gt;\r\n&lt;li&gt;&lt;a href=&quot;#&quot;&gt;Kullanıcılar&lt;/a&gt;&lt;/li&gt;\r\n&lt;li&gt;&lt;a href=&quot;#&quot;&gt;Hakkımızda&lt;/a&gt;&lt;/li&gt;\r\n&lt;li&gt;&lt;a href=&quot;#&quot;&gt;İletişim&lt;/a&gt;&lt;/li&gt;\r\n&lt;/ul&gt;\r\n&lt;/nav&gt;\r\n&lt;/header&gt;</pre>\r\n\r\n<p><strong>NAV</strong></p>\r\n\r\n<p>Sitemizin navigasyonunun yer aldığını konteynir tag&rsquo;i.</p>\r\n\r\n<p>&Ouml;rnek Kullanımı</p>\r\n\r\n<pre>\r\n&lt;nav&gt;\r\n&lt;ul&gt;\r\n&lt;li&gt;&lt;a href=&quot;#&quot;&gt;Ana Sayfa&lt;/a&gt;&lt;/li&gt;\r\n&lt;li&gt;&lt;a href=&quot;#&quot;&gt;Kullanıcılar&lt;/a&gt;&lt;/li&gt;\r\n&lt;li&gt;&lt;a href=&quot;#&quot;&gt;Hakkımızda&lt;/a&gt;&lt;/li&gt;\r\n&lt;li&gt;&lt;a href=&quot;#&quot;&gt;İletişim&lt;/a&gt;&lt;/li&gt;\r\n&lt;/ul&gt;\r\n&lt;/nav&gt;</pre>\r\n\r\n<p><strong>ASIDE</strong></p>\r\n\r\n<p>Sayfada yer alan i&ccedil;erikle ilgili ancak &ouml;nemli bir bilgi yer aldığını anlatmaya &ccedil;alıştığımız konteynır tag&rsquo;i.</p>\r\n\r\n<p>&Ouml;rnek Kullanımı</p>\r\n\r\n<pre>\r\n&lt;aside&gt;\r\n&lt;p&gt;Buraya dikkat...&lt;/p&gt;\r\n&lt;/aside&gt;</pre>\r\n\r\n<p><strong>ARTICLE</strong></p>\r\n\r\n<p>Web sayfaları bildiğiniz &uuml;zere sadece i&ccedil;erikten meydana gelmez men&uuml;ler, reklamlar ve &ccedil;eşitli tanımlamalar da olur. Ama kullanıcı genelikle bunlarla ilgilenmez. İlgilendiği konu girdiği sayfada ki i&ccedil;eriktir. Bunu belirtiğimiz tag de article tag&rsquo;i dir.</p>\r\n\r\n<p>&Ouml;rnek Kullanım</p>\r\n\r\n<pre>\r\n&lt;article&gt;\r\nBu yazımda....\r\n&lt;/article&gt;</pre>\r\n', 'ali', '2018-01-04 23:18:37', 6, 1, 0, '9542.jpg');
COMMIT;

-- ----------------------------
-- Table structure for mesajlar
-- ----------------------------
DROP TABLE IF EXISTS `mesajlar`;
CREATE TABLE `mesajlar` (
  `mesaj_id` int(11) NOT NULL AUTO_INCREMENT,
  `mesaj_baslik` varchar(200) COLLATE utf8_turkish_ci NOT NULL,
  `mesaj_aciklama` varchar(1000) COLLATE utf8_turkish_ci NOT NULL,
  `mesaj_gonderen` varchar(45) COLLATE utf8_turkish_ci NOT NULL,
  `mesaj_kime` int(11) NOT NULL DEFAULT '0',
  `mesaj_tarih` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `mesaj_okunma` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`mesaj_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

-- ----------------------------
-- Records of mesajlar
-- ----------------------------
BEGIN;
INSERT INTO `mesajlar` VALUES (5, 'Script Sorusu', '<p>Sorunun cevabını <a id=\"https://www.w3schools.com/js/\" name=\"https://www.w3schools.com/js/\">bu</a>&nbsp;sitede anlatmışlar.</p>\r\n', 'kaan', 2, '2018-01-04 23:46:20', 1);
INSERT INTO `mesajlar` VALUES (6, 'Java', '<p>java mesaj</p>\r\n', 'kaan', 2, '2018-01-04 23:52:56', 1);
COMMIT;

-- ----------------------------
-- Table structure for resimler
-- ----------------------------
DROP TABLE IF EXISTS `resimler`;
CREATE TABLE `resimler` (
  `resim_id` int(11) NOT NULL AUTO_INCREMENT,
  `resim_yol` varchar(255) COLLATE utf8_turkish_ci DEFAULT NULL,
  PRIMARY KEY (`resim_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

-- ----------------------------
-- Table structure for uyeler
-- ----------------------------
DROP TABLE IF EXISTS `uyeler`;
CREATE TABLE `uyeler` (
  `uye_id` int(11) NOT NULL AUTO_INCREMENT,
  `uye_adi` varchar(45) COLLATE utf8_turkish_ci NOT NULL,
  `uye_parola` varchar(45) COLLATE utf8_turkish_ci NOT NULL,
  `uye_eposta` varchar(200) COLLATE utf8_turkish_ci NOT NULL,
  `uye_tarih` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `uye_rutbe` int(11) NOT NULL DEFAULT '0',
  `uye_onay` int(11) NOT NULL DEFAULT '0',
  `uye_hakkimda` varchar(200) COLLATE utf8_turkish_ci NOT NULL,
  `uye_sehir` varchar(45) COLLATE utf8_turkish_ci NOT NULL,
  `uye_dogum` varchar(45) COLLATE utf8_turkish_ci NOT NULL,
  `uye_facebook` varchar(45) COLLATE utf8_turkish_ci NOT NULL,
  `uye_twitter` varchar(45) COLLATE utf8_turkish_ci NOT NULL,
  `uye_resim` varchar(200) COLLATE utf8_turkish_ci NOT NULL,
  PRIMARY KEY (`uye_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

-- ----------------------------
-- Records of uyeler
-- ----------------------------
BEGIN;
INSERT INTO `uyeler` VALUES (1, 'kaan', '81dc9bdb52d04dc20036dbd8313ed055', 'kaan@gmail.com', '2017-12-24 16:54:22', 1, 1, 'kaan hakkimda', 'İstanbul', '12/04/1994', 'https://www.facebook.com', 'https://twitter.com/?lang=tr', '3923.jpg');
INSERT INTO `uyeler` VALUES (2, 'ali', '81dc9bdb52d04dc20036dbd8313ed055', 'ali@hotmail.com', '2017-12-24 16:59:21', 0, 1, 'ali hakkinda', 'Adana', '01/09/1990', 'https://www.facebook.com', 'https://www.twitter.com', '9490.jpg');
INSERT INTO `uyeler` VALUES (3, 'osman', '81dc9bdb52d04dc20036dbd8313ed055', 'osman@gmail.com', '2017-12-31 14:25:57', 0, 1, 'osman hakkımda', 'Adana', '12/04/1194', 'https://www.facebook.com', 'https://www.twitter.com', '3923.jpg');
INSERT INTO `uyeler` VALUES (4, 'ayşe', '81dc9bdb52d04dc20036dbd8313ed055', 'ayse@outlook.com', '2017-12-31 14:33:29', 0, 0, 'ayse', 'Ağrı', '12/04/1994', 'https://www.facebook.com', 'https://www.twitter.com', '2572.jpg');
COMMIT;

-- ----------------------------
-- Table structure for yorumlar
-- ----------------------------
DROP TABLE IF EXISTS `yorumlar`;
CREATE TABLE `yorumlar` (
  `yorum_id` int(11) NOT NULL AUTO_INCREMENT,
  `yorum_ekleyen` int(11) NOT NULL,
  `yorum_mesaj` varchar(1000) COLLATE utf8_turkish_ci NOT NULL,
  `yorum_tarih` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `yorum_konu_id` int(11) NOT NULL DEFAULT '0',
  `yorum_onay` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`yorum_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

-- ----------------------------
-- Records of yorumlar
-- ----------------------------
BEGIN;
INSERT INTO `yorumlar` VALUES (8, 2, '<p>&Ccedil;ok yardımcı oldu teşekk&uuml;rler.</p>\r\n', '2018-01-04 23:51:08', 17, 1);
COMMIT;

-- ----------------------------
-- Procedure structure for arama
-- ----------------------------
DROP PROCEDURE IF EXISTS `arama`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `arama`(IN ara VARCHAR(45))
BEGIN
SELECT *,  date(konu_tarih) as tarih  FROM konular as k INNER JOIN  kategoriler as kat ON k.konu_kategori=kat.kategori_id and date(konu_tarih) WHERE k.konu_durum = 1 and k.konu_baslik  LIKE CONCAT('%',ara,'%');
END;
;;
delimiter ;

-- ----------------------------
-- Procedure structure for devam
-- ----------------------------
DROP PROCEDURE IF EXISTS `devam`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `devam`(IN id varchar(45))
BEGIN
 SELECT *, date(konu_tarih) as tarih FROM konular as k INNER JOIN  kategoriler as kat ON k.konu_kategori=kat.kategori_id and date(konu_tarih)  WHERE konu_durum=1 and k.konu_id=id ;
END;
;;
delimiter ;

-- ----------------------------
-- Procedure structure for kategoriGetir
-- ----------------------------
DROP PROCEDURE IF EXISTS `kategoriGetir`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `kategoriGetir`()
BEGIN
SELECT * FROM kategoriler;
END;
;;
delimiter ;

-- ----------------------------
-- Procedure structure for kategoriKonuGetir
-- ----------------------------
DROP PROCEDURE IF EXISTS `kategoriKonuGetir`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `kategoriKonuGetir`(IN id VARCHAR(45))
BEGIN
SELECT *, date(konu_tarih) as tarih FROM konular as k INNER JOIN  kategoriler as kat ON k.konu_kategori=kat.kategori_id and date(konu_tarih)  WHERE konu_durum=1 and kat.kategori_id=id ;
END;
;;
delimiter ;

-- ----------------------------
-- Procedure structure for klGiris
-- ----------------------------
DROP PROCEDURE IF EXISTS `klGiris`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `klGiris`(IN kladi varchar(45), IN klparola varchar(45))
BEGIN

SELECT * FROM uyeler WHERE uye_adi=kladi and uye_parola=klparola and uye_onay=1;

END;
;;
delimiter ;

-- ----------------------------
-- Procedure structure for konuEkle
-- ----------------------------
DROP PROCEDURE IF EXISTS `konuEkle`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `konuEkle`(IN baslik VARCHAR(45), IN resim VARCHAR(200),  IN kategori INT(11), IN aciklama VARCHAR(300),  IN ekleyen VARCHAR(45))
BEGIN

INSERT INTO konular SET

                                 konu_baslik =baslik,
                                 konu_resim =resim,
                                 konu_kategori = kategori,
                                 konu_aciklama = aciklama,
                                 konu_ekleyen = ekleyen;  

END;
;;
delimiter ;

-- ----------------------------
-- Procedure structure for konuGetir
-- ----------------------------
DROP PROCEDURE IF EXISTS `konuGetir`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `konuGetir`()
BEGIN
		SELECT *, date(konu_tarih) as tarih FROM konular as k INNER JOIN  kategoriler as kat ON k.konu_kategori=kat.kategori_id and date(konu_tarih)  WHERE konu_durum=1 ORDER BY konu_tarih DESC ;
END;
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
