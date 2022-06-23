<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="layout/header.jsp"%>
<br/><br/>
<div class="container p-3 bg-white text-black m-8" style="height: 500px;">
	<div class="input-group flex-nowrap">
  		<span class="input-group-text" id="addon-wrapping">제목</span>
  		<input id="title" type="text" class="form-control" placeholder="제목입력" aria-label="Username" aria-describedby="addon-wrapping">
	</div>
	<br/>
	<div id="summernote" ></div>
	<br/>
	
	<button id="btn-write" type="button">작성</button>			
</div>




<script src="/js/board.js"></script>
<%@ include file ="layout/footer.jsp"%>
