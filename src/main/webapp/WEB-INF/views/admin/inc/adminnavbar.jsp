<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>


<nav class="navbar navbar-inverse navbar-fixed-left">
    <div class="container">
      <div class="navbar-header">
        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
          <span class="sr-only">Toggle navigation</span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href='<s:url value="/yonetim"></s:url>'>Admin Paneli</a>
      </div>
      <div id="navbar" class="navbar-collapse collapse">
        <ul class="nav navbar-nav">
          <li><a href='<s:url value="/uyeler"></s:url>'>Uyeler</a></li>
          <li><a href='<s:url value="/konular"></s:url>'>Konular</a></li>
          <li><a href='<s:url value="/kategoriler"></s:url>'>Kategoriler</a></li>
          <li><a href='<s:url value="/yorumlar"></s:url>'>Yorumlar</a></li>
          <li><a href='<s:url value="/1"></s:url>'>Çıkış</a></li>
         
        </ul>
 
      </div>
    </div>
  </nav>