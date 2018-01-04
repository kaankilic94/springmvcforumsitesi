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
        Yorum Oku
     </h1>
     
     <c:if test="${not empty yorumoku }">
     
      <div  class="well">
            <img style=" width:40px; height:40px; -webkit-border-radius:10px; -moz-border-radius:10px; border-radius:100px;" src='<s:url value="http://localhost:8080/resimler/${yorumoku.getYkresim() }"></s:url>'>
           <h4> <c:out value="${yorumoku.getYekleyen()}"></c:out> <span style="float: right"> Tarih: <c:out value="${yorumoku.getYtarih() }"></c:out>  </span> </h4><hr>
            <p><c:out value="${yorumoku.getYmesaj() }" escapeXml="false"></c:out></p>
        </div>
     </c:if>
						   
    </div>
  </div>

</body>

</html>
