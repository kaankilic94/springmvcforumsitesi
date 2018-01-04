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
         
         
         
             <c:if test="${not empty mesajokuls }">
            <c:forEach items="${mesajokuls}" var="item">
            
            <div class="well">
            <span style="font-weight: bold;">Başlık: </span>${item.getMbaslik()}
            
            <span style=" float: right;">
                   <span style="font-weight: bold;">Gönderen:&nbsp;</span>${item.getMgonderen() }</span>
            
            
            <hr>
            ${item.getMaciklama()}</div>
            
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
