<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>





        <!-- Sidebar Widgets Column -->
        <div class="col-md-4">

          <!-- Search Widget -->
          
    <br>       
    <c:if test="${durum == true }">
    <div class="card-header">
        <h4>Uye: <c:out value="${isim}"></c:out> </h4><hr>
        <div class="row">
            <div class="col-lg-12">
                <ul class="list-unstyled">
                
                    <c:if test="${klrutbe == 1 }">
                    <li><a href='<s:url value="/yonetim"></s:url>'>Moderatör Paneli</a></li> <hr>
                    </c:if>
                    <li><a href='<s:url value="/profil/${klid}"></s:url>'>Profil</a> </li><hr>
                    <li><a href='<s:url value="/konuekle"></s:url>'>Konu Ekle</a></li><hr>
                    <li><a href='<s:url value="/mesajkutusu/${klid}"></s:url>'>Mesajlar </a><c:out value="${count}"></c:out></li><hr>
                    
                    <li><a href='<s:url value="/cikis"></s:url>'>Çıkış</a></li>
                </ul>
            </div>
            <!-- /.col-lg-6 -->

            <!-- /.col-lg-6 -->
        </div>
        <!-- /.row -->
    </div>
    </c:if>
    <c:if test="${durum == false }">
     <div class="card my-4">
            <h5 class="card-header">Kullanıcı Girişi</h5>
            
            <div class="card-body">
            
              <div style="font-size: 80%; color: black" id="myDiv">
              	<p style=" border-radius: 5px; background-color: #ffefef;"><c:out value="${kontrol}"></c:out></p>
              </div>
              
              <form  action='<s:url value="/"></s:url>' method="post">
              
                <input type="text" class="form-control" placeholder="Kullanıcı Adı" name="kullanici_adi"></br>
                <input type="password" class="form-control" placeholder="Parola" name="kullanici_parola"></br>
               
                  
                  <button  style="float: right;" class="btn btn-info" type="submit">Giriş</button>
                  
               
              
              </form>
             
            </div>
          </div>
    
    </c:if>
          
          
        
          
          <!-- Search Widget -->
          <div class="card my-4">
            <h5 class="card-header">Arama</h5>
            <div class="card-body">
             <form action='<s:url value="/ara"></s:url>' method=post>
              <div class="input-group">
                <input name= "yazi" type="text" class="form-control" placeholder="Ara..">
                <span class="input-group-btn">
                  <button class="btn btn-secondary" type="submit">Git!</button>
                </span>
              </div>
             </form>
            </div>
          </div>

          <!-- Categories Widget -->
          <div class="card my-4">
            <h5 class="card-header">Kategoriler</h5>
            <div class="card-body">
              <div class="row">
   
                <c:if test="${not empty katListe }">
                
                <c:forEach items="${katListe}" var="item">
                
                <div class="col-lg-6">
                  <ul class="list-unstyled mb-0">
                    <li>
                      <a href="<s:url value="/kategori/${item.getKatid()}"></s:url>"><c:out value="${item.getKatadi()}"></c:out> </a>
                    </li>
                    
                 
                  </ul>
                </div>
                
                </c:forEach>
                
                </c:if>
                
              </div>
            </div>
          </div>

          <!-- Side Widget -->
          <div class="card my-4">
            <h5 class="card-header">Side Widget</h5>
            <div class="card-body">
              You can put anything you want inside of these side widgets. They are easy to use, and feature the new Bootstrap 4 card containers!
            </div>
          </div>

        </div>