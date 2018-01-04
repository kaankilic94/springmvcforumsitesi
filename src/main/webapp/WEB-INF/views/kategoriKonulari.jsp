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
          <c:if test="${not empty kategoriKonu }">
          <c:forEach items="${kategoriKonu}" var="item">
          
          <div class="card mb-4">
            
            <div class="card-body">
              <h2><c:out value="${item.getKbaslik() }"></c:out></h2>
			   <p>Kategori: <a href=""><c:out value="${item.getKkategori()}"></c:out></a> Yazar: <a href='<s:url value="/profil/${item.getKid()}"></s:url>'> <c:out value="${item.getKekleyen()}"></c:out></a>
                 Okunma: <c:out value="${item.getKhit()}"></c:out> Yorum : 5 <span class="glyphicon glyphicon-time" style="float: right"> <c:out value="${item.getKtarih()}"></c:out></span> </p>
               <hr>
               <img class="img-responsive" style="width: 100%; height: auto;" src="<c:out value="http://localhost:8080/resimler/${item.getKresim()}"></c:out>" alt="">
    
               <hr>
               <p class="tasma_engelle"><c:out value="${item.getKaciklama()}"></c:out>...</p>
               <a class="btn btn-primary" href='<s:url value="/devam/${item.getKbaslik()}-${item.getKid()}"></s:url>'>Daha Fazla <span class="glyphicon glyphicon-chevron-right"></span></a>

            </div>
            
          </div>
          </c:forEach>
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
