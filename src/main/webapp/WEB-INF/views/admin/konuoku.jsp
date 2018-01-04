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
       Konu Oku
     </h1>
     
     <c:if test="${not empty konuoku }">
     
     <img style=" width:100px; height:100px; -webkit-border-radius:10px; -moz-border-radius:10px; border-radius:100px;" src='<s:url value="http://localhost:8080/resimler/${konuoku.getKresim() }"></s:url>'>
     <p><c:out value="${konuoku.getKaciklama()}" escapeXml="false"></c:out> </p>

     </c:if>
						   
    </div>
  </div>

</body>

</html>
