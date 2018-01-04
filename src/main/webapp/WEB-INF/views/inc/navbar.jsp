<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>

 <!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
      <div class="container">
        <a class="navbar-brand" href='<s:url value="/1"></s:url>' ">Anasayfa</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
           
          <c:if test="${durum == false }">
            <li class="nav-item">
              <a class="nav-link" href='<s:url value="/kayit"></s:url>'>Kayıt Ol</a>
            </li>
          </c:if>
          
           <c:if test="${durum == true }">
            <li class="nav-item">
              <a class="nav-link" href='<s:url value="/paroladegis"></s:url>'>Parola Değiştir</a>
            </li>
          </c:if>
          </ul>
        </div>
      </div>
    </nav>
    