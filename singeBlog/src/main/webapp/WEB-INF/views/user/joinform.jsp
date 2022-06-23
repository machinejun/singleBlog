<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>
<br/>
<br/>
<br/>   
	<div class="container p-3 bg-primary text-white">
		<div class="input-group flex-nowrap">
  			<span class="input-group-text" id="addon-wrapping">아이디</span>
  			<input type="text" id="username" class="form-control" placeholder="아이디" aria-label="Username" aria-describedby="addon-wrapping">
		</div>
		<br/>
		<div class="input-group flex-nowrap">
  			<span class="input-group-text" id="addon-wrapping">비밀번호</span>
  			<input type="text"  id="password" class="form-control" placeholder="비밀번호" aria-label="Username" aria-describedby="addon-wrapping">
		</div>
		<br/>
		<div class="input-group flex-nowrap">
  			<span class="input-group-text" id="addon-wrapping">이메일</span>
  			<input type="text"  id="email" class="form-control" placeholder="이메일" aria-label="Username" aria-describedby="addon-wrapping">
		</div>
		<br/>
		<br/>
		<button id="btn-join" type="button">회원가입</button>			
	</div>
<script src="/js/user.js"></script>
<%@ include file="../layout/footer.jsp" %>   