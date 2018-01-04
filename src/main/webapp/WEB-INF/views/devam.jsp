<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- turkish  -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ page session="false" %>
<!DOCTYPE html>
<html lang="en">

  <head>
  
  <!-- turkish  -->
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <!-- turkish  -->

   <!-- <meta charset="utf-8"> --> 
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Blog Home - Start Bootstrap Template</title>

    <!-- Bootstrap core CSS -->
    <link href='<s:url value="/resources/vendor/bootstrap/css/bootstrap.min.css"></s:url>' rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href='<s:url value="/resources/css/blog-home.css"></s:url>' rel="stylesheet">
    
    <script type="text/javascript"
	src='<s:url value="/resources/ckeditor/ckeditor.js"></s:url>'></script>
    
     <style>
    .well{min-height:20px;padding:19px;margin-bottom:20px;
	background-color:#f5f5f5;border:1px solid #e3e3e3;border-radius:4px;
	-webkit-box-shadow:inset 0 1px 1px rgba(0,0,0,.05);box-shadow:inset 0 1px 1px rgba(0,0,0,.05)}
    .well blockquote{border-color:#ddd;border-color:rgba(0,0,0,.15)}
    .well-lg{padding:24px;border-radius:6px}.
    .well-sm{padding:9px;border-radius:3px}
    </style>
    
  </head>

  <body>

   <jsp:include page="${ request.contextPath }/navbar"></jsp:include>
   
   

    <!-- Page Content -->
    <div class="container">
    
   
    

      <div class="row">

        <!-- Blog Entries Column -->
        <div class="col-md-8">
        
        
          <h1 class="my-4">Java19 Forum</h1>
          <br>
            
          
          <!-- Blog Post -->
          <c:if test="${not empty lsdvm }">
          
          <div class="card mb-4">
            
            <div class="card-body">
              <h2><c:out value="${lsdvm.get(0).getKbaslik() }"></c:out></h2>
			   <p>Kategori: <a href='<s:url value="/kategori/${lsdvm.get(0).getKkategoriId()}"></s:url>'><c:out value="${lsdvm.get(0).getKkategori()}"></c:out></a> Yazar: <a href='<s:url value="/profil/${lsdvm.get(0).getKid()}"></s:url>'> <c:out value="${lsdvm.get(0).getKekleyen()}"></c:out></a>
                 Okunma: <c:out value="${lsdvm.get(0).getKhit()}"></c:out> Yorum : <c:out value="${lsdvm.get(0).getKyorumsayisi() }"></c:out> <span class="glyphicon glyphicon-time" style="float: right"> <c:out value="${lsdvm.get(0).getKtarih()}"></c:out></span> </p>
               <hr>
               <img class="img-responsive" style="width: 100%; height: auto;" src="<c:out value="http://localhost:8080/resimler/${lsdvm.get(0).getKresim()}"></c:out>" alt="">
    
               <hr>
               <p class="tasma_engelle"><c:out value="${lsdvm.get(0).getKaciklama()}" escapeXml="false"></c:out></p>
               

            </div>
            
          </div>
          </c:if>
          
          <hr>
          
          <c:if test="${not empty yorumls }">
          <c:forEach items="${yorumls}" var="item">
            <div  class="well">
            <img style=" width:40px; height:40px; -webkit-border-radius:10px; -moz-border-radius:10px; border-radius:100px;" src='<s:url value="http://localhost:8080/resimler/${item.getYkresim() }"></s:url>'>
           <h6> <a href='<s:url value="/profil/${item.getYkid() }"></s:url>'><c:out value="${item.getYekleyen()}"></c:out> </a> <span style="float: right"> Tarih: <c:out value="${item.getYtarih()}"></c:out> </span> </h6><hr>
            <p><c:out value="${item.getYmesaj()}" escapeXml="false"></c:out> </p>
        </div>
          </c:forEach>
          </c:if>
          
        
          <c:if test="${yorumcount == 0}">
          <div  class="well">Bu konuya henüz yorum yapılmamış.</div>
		  </c:if>
		  
		  <c:if test="${durum == true }">
		  <div class="card mb-4">
            
            <div class="card-body">
		 	<form action ='<s:url value="/yorumgonder/${konuid}"></s:url>' method="post">
		 	<label>Yorum Gönder:</label><br>
            <textarea name="yorum" class="ckeditor" rows="5" id="comment"></textarea><br/>
            <input type="submit" class="form-control">
		 	</form>
		 	
		 	</div>
		 	</div>
		  </c:if>
		  
		  <c:if test="${durum == false}">
		  
		  <div  class="well">Yorum atabilmek için lütfen giriş yapınız.</div>
		  
		  </c:if>
		  
		  
        </div>

      <jsp:include page="${ request.contextPath }/sidebar"></jsp:include>

      </div>
      <!-- /.row -->

    </div>
    <!-- /.container -->
    

 
 <script>
    setTimeout(function() {  
    	$('#myDiv').delay(3000).hide('slow');  
	});
   
 
 </script>

     <jsp:include page="${ request.contextPath }/footer"></jsp:include>
  </body>

</html>
