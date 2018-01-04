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
        Yorumlar
     </h1>
     
      <table class="table table-hover">
            <thead>
            <tr>
                <th>Oku</th>
                <th>Onay</th>
                <th>Konu Baslık</th>
                <th>Uye Adı</th>
                <th>Tarih</th>
               
                <th>Sil</th>
            </tr>
            </thead>
           

                    <tbody>
                     <c:forEach items="${yorumlar }" var="item">
                    <tr>
                       
                        <td> <a href='<s:url value="/yorumoku/${item.getYid()}"></s:url>'>Oku</a></td>
                        
                        <td><c:if test="${item.getYonay() == 1}">
                        <a href='<s:url value="/yorumonay/${item.getYid()}"></s:url>'><span class="fa fa-check"  style='color: green'></span></a>
                        </c:if>
                        <c:if test="${item.getYonay() == 0}">
                        <a href='<s:url value="/yorumonay/${item.getYid()}"></s:url>'><span class="fa fa-times" style='color: red'></span></a>
                        </c:if></td>
                        
                        <td><c:out value="${item.getYorumkonuadi()}"></c:out></td>
                        <td><c:out value="${item.getYekleyen() }"></c:out> </td>
                        <td><c:out value="${item.getYtarih() }"></c:out> </td>
                       
                       
                        <td>
                            <form style="display: inline;" action='<s:url value="/yorumlar"></s:url>' method="post">
                                <input type="checkbox"  name="silyorum" value="${item.getYid()}">
                               
                        </td>

                    </tr>
                    </c:forEach>
                    </tbody>
                     
        
</table>

      <button onclick="return confirm('Silmek istediğinizden eminmisiniz?');" type="submit" class="btn btn-primary">Sil</button>
						   </form>
 

						   
    </div>
  </div>

</body>

</html>
