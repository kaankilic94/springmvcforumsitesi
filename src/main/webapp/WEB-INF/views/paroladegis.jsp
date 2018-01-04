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

<title>Blog Home - Start Bootstrap Template</title>

<!-- Bootstrap core CSS -->
<link
	href='<s:url value="/resources/vendor/bootstrap/css/bootstrap.min.css"></s:url>'
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href='<s:url value="/resources/css/blog-home.css"></s:url>'
	rel="stylesheet">
<script type="text/javascript"
	src='<s:url value="/resources/ckeditor/ckeditor.js"></s:url>'></script>

<style>
.styled-select {
	background: url(http://i62.tinypic.com/15xvbd5.png) no-repeat 96% 0;
	height: 29px;
	overflow: hidden;
	width: 240px;
}

.styled-select select {
	background: transparent;
	border: none;
	font-size: 14px;
	height: 29px;
	padding: 5px;
	/* If you add too much padding here, the options won't show in IE */
	width: 268px;
}

.styled-select.slate {
	background: url(http://i62.tinypic.com/2e3ybe1.jpg) no-repeat right
		center;
	height: 34px;
	width: 240px;
}

.styled-select.slate select {
	border: 1px solid #ccc;
	font-size: 16px;
	height: 34px;
	width: 268px;
}

.slate {
	background-color: #ddd;
}

.slate select {
	color: #000;
}
</style>

</head>

<body>

	<jsp:include page="${ request.contextPath }/navbar"></jsp:include>



	<!-- Page Content -->
	<div class="container">




		<div class="row">

			<!-- Blog Entries Column -->
			<div class="col-md-8">


				<h1 class="my-4">Profil Düzenle</h1>
				<br>
				
				<div class="card mb-4">

					<div class="card-body">
					
						
						
                <form action='<s:url value="/paroladegis"></s:url>' method="post">
                    <div class="form-group">
                        <div style="font-size: 80%; color: black" id="parolaDiv">
              	<p style=" border-radius: 5px; background-color: #ffefef;"><c:out value="${parolamesaj}"></c:out></p>
              </div>


                        <label for="parolaeski">Eski Parola: <span style="color: red">*</span></label>
                        <input id="parolaeski" name="parolaeski" value="" type="password" class="form-control">
                        
                        <label for="parolayeni">Yeni Parola: <span style="color: red">*</span></label>
                        <input id="parolayeni" name="parolayeni" value="" type="password" class="form-control">
                        
                        <label for="parolayenitekrar">Yeni Parola Tekrar: <span style="color: red">*</span></label>
                        <input id="parolayenitekrar" name="parolayenitekrar" value="" type="password" class="form-control"> <br>

                        


                        <button  type="submit" class="form-control">Gönder</button>
                    </div>
                </form>
					
				
					
					</div>

				</div>

			</div>

			<jsp:include page="${ request.contextPath }/sidebar"></jsp:include>

		</div>
		<!-- /.row -->

	</div>
	<!-- /.container -->



	<script>
		setTimeout(function() {
			$('#parolaDiv').delay(3000).hide('slow');
		});
	</script>

	<jsp:include page="${ request.contextPath }/footer"></jsp:include>
</body>

</html>
