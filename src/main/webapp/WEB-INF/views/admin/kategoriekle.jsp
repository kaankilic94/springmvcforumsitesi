<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- turkish  -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html lang="en">

<head>

<!-- turkish  -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- turkish  -->

<!-- <meta charset="utf-8"> -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Admin Paneli</title>

<jsp:include page="${ request.contextPath }/scriptlink"></jsp:include>
	

</head>

<body>

<jsp:include page="${ request.contextPath }/adminnavbar"></jsp:include>
  <div class="container">

    <div class="jumbotron">
      <h1>
        Kategori Ekle
     </h1>
     
    <form action='<s:url value="/kategoriekle"></s:url>' method="post">
    
     <label for="adi">Kategori Adı: </label>
     <input type="text" class="form-control" id="adi" name="katadi" >
     <br>
     <label for="aciklama">Kategori Açıklama: </label>
     <input type="text" class="form-control" id="aciklama" name="kataciklama">
     <br>
     <input class="btn btn-primary" type="submit">
    
    </form>
     

						   
    </div>
  </div>

</body>

</html>
