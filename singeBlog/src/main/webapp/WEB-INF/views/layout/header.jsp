<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix= "c" uri ="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
    />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
    
    <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
	<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
    
</head>
<body>
	<nav
      class="navbar navbar-expand-md bg-success navbar-dark"
    >
      <!-- Brand -->
      <a
        class="navbar-brand"
        href="/"
        >JunicBlog</a>
      <!-- Toggler/collapsibe Button -->
      <button
        class="navbar-toggler"
        type="button"
        data-toggle="collapse"
        data-target="#collapsibleNavbar">
        <span
          class="navbar-toggler-icon"></span>
      </button>

      <!-- Navbar links -->
      <div
        class="collapse navbar-collapse"
        id="collapsibleNavbar"
      >
        <ul class="navbar-nav">
        	<c:choose>
        		<c:when test="${empty sessionScope.principal}">
        			<li class="nav-item">
                		<a
                  		class="nav-link"
                  		href="/user/loginform"
                  		>로그인</a>
              		</li>
              		<li class="nav-item">
                		<a
                  		class="nav-link"
                  		href="/user/joinform"
                  		>회원가입</a>
              		</li>
        		</c:when>
	        	<c:otherwise>
	        		<li class="nav-item">
		                <a
		                  class="nav-link"
		                  href="/user/writeform"
		                  >글쓰기</a>
		            </li>
		            <li class="nav-item">
		                <a
		                  class="nav-link"
		                  href="/user/logout"
		                  >로그아웃</a>
	              	</li>
	        	</c:otherwise>
        	</c:choose>
              
        </ul>
      </div>
    </nav>