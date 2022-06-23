<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="layout/header.jsp" %>
<!-- https://codevang.tistory.com/197 jsp 태그 -->   
<main class="container">
<!-- https://www.tutorialspoint.com/jsp/jsp_standard_tag_library.htm jsp 문서 -->
	<c:forEach var="board" items="${boards.content}">
		<div class="card col-md-12 m-2">
			<div class="card-body">
				<h4 class="card-title">${board.title}</h4>
				<a href="/board/${board.id}" class="btn btn-primary">상세보기</a>
			</div>
		</div>
	</c:forEach>
	<br/>
	<ul class="pagination justify-content-center">
		<c:choose>
			<c:when test="${boards.first}">
				<li class="page-item disabled"><a class="page-link " href="/list?page=${boards.pageable.pageNumber - 1}">Previous</a></li>
			</c:when>
			<c:otherwise>
				<li class="page-item"><a class="page-link" href="/list?page=${boards.pageable.pageNumber - 1}">Previous</a></li>
			</c:otherwise>
		</c:choose>
		
		<c:choose>
			<c:when test="${boards.last}">
				<li class="page-item disabled"><a class="page-link " href="/list?page=${boards.pageable.pageNumber + 1}">Next</a></li>
			</c:when>
			<c:otherwise>
				<li class="page-item"><a class="page-link" href="/list?page=${boards.pageable.pageNumber + 1}">Next</a></li>
			</c:otherwise>
		</c:choose>
	</ul>
</main>

<%@ include file="layout/footer.jsp" %>
	