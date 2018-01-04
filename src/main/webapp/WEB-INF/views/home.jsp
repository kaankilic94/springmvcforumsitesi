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
          <c:if test="${not empty liste }">
          <c:forEach items="${liste}" var="item">
          
          <div class="card mb-4">
            
            <div class="card-body">
              <h2><c:out value="${item.getKbaslik() }"></c:out></h2>
			   <p>Kategori: <a href='<s:url value="/kategori/${item.getKkategoriId() }"></s:url>'><c:out value="${item.getKkategori()}"></c:out></a> Yazar: <a href='<s:url value="/profil/${item.getKekleyen()}"></s:url>'> <c:out value="${item.getKekleyenadi()}"></c:out></a>
                 Okunma: <c:out value="${item.getKhit()}"></c:out> Yorum : <c:out value="${item.getKyorumsayisi() }"></c:out> <span class="glyphicon glyphicon-time" style="float: right"> <c:out value="${item.getKtarih()}"></c:out></span> </p>
               <hr>
               <img class="img-responsive" style="width: 100%; height: auto;" src="<c:out value="http://localhost:8080/resimler/${item.getKresim()}"></c:out>" alt="">
    
               <hr>
               <p class="tasma_engelle"><c:out value="${item.getKaciklama()}"></c:out>...</p>
               <a class="btn btn-primary" href='<s:url value="/devam/${item.getKbaslik()}-${item.getKid()}"></s:url>'>Daha Fazla <span class="glyphicon glyphicon-chevron-right"></span></a>

            </div>
            
          </div>
          </c:forEach>
          </c:if>
          
         <!-- sayfalama --> 
          <div class= "well"><c:forEach  items="${sayfalama}" var="item">
        <c:if test="${item == sayfa }"><c:out value="${item}"></c:out> </c:if>
        <c:if test="${item != sayfa }"><a href='<s:url value="/${item}"></s:url>'><c:out value="${item}"></c:out> </a></c:if>
      </c:forEach>
      
      <c:if test="${sayfa != son }">
      <a style="float:right" href='<s:url value="/${son}"></s:url>'>son</a>
      </c:if>
      <c:if test="${sayfa != 1 }">
      <a style="float:left" href='<s:url value="/1"></s:url>'>ilk</a>
      </c:if>
		<!-- sayfalama --> 
	
    
      </div>


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
