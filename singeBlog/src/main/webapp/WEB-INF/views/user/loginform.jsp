<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>
<br/>
<br/>
<br/>   
	<div class="container p-3 bg-primary text-white">
		<div class="input-group flex-nowrap">
  			<span class="input-group-text" id="addon-wrapping">아이디</span>
  			<input id="username" type="text" class="form-control" placeholder="Username" aria-label="Username" aria-describedby="addon-wrapping">
		</div>
		<br/>
		<div class="input-group flex-nowrap">
  			<span class="input-group-text" id="addon-wrapping">비밀번호</span>
  			<input id="password" type="text" class="form-control" placeholder="Username" aria-label="Username" aria-describedby="addon-wrapping">
		</div>
		<br/>
		<br/>
		<br/>
		<button id="btn-login" type="button">로그인</button>			
	</div>
<script src="/js/user.js"></script>	
<%@ include file="../layout/footer.jsp" %>   