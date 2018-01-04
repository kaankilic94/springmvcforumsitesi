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
            
          <c:if test="${ not empty id }">
<iframe src='http://localhost:8080/resim/index.php?resim_id=<c:out value="${ id }"></c:out>' style="width: 100%; height: 500px;" frameborder="0"></iframe>
</c:if>
        
          

          <!-- Pagination -->
          <ul class="pagination justify-content-center mb-4">
            <li class="page-item">
              <a class="page-link" href="#">&larr; Older</a>
            </li>
            <li class="page-item disabled">
              <a class="page-link" href="#">Newer &rarr;</a>
            </li>
          </ul>

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
