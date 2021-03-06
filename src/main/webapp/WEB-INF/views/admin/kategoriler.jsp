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
        Kategoriler <a style="float:right;"href='<s:url value="/kategoriekle"></s:url>'>Kategori Ekle</a>
     </h1>
     
     
     
     <table class="table table-hover">
            <thead>
            <tr>
                <th>Kategori Adı</th>
                <th>Kategori Açıklama</th>
                <th>Düzenle</th>
                <th>Sil</th>
            </tr>
            </thead>
           

                    <tbody>
                     <c:forEach items="${kategoriler }" var="item">
                    <tr>
                       
                        <td><c:out value="${item.getKatadi()}"></c:out> </td>
                        <td><c:out value="${item.getKataciklama()}"></c:out></td>
                        <td><a href='<s:url value="/kategoriduzenle/${item.getKatid()}"></s:url>'>duzenle</a></td>
                       
                        <td>
                            <form style="display: inline;" action='<s:url value="/kategoriler"></s:url>' method="post">
                                <input type="checkbox"  name="silkat" value="${item.getKatid()}">
                               
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
