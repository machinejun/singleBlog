<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="layout/header.jsp" %>
<div class="container">
	<form>
		<div class="form-group">
			<label for="title">Title : </label>
			<input type="text" value ="${board.title}" placeholder="title" id="title" class="form-control">	
		</div>
		
		<div class="form-group">
			<label for="content">Content : </label>
			<textarea id="content" class="form-control summernote" rows="5" >${board.content}</textarea>
		</div>
		<button type="button" onclick="updateBoard(${board.id})" class="btn btn-primary">글수정하기</button>
	</form>
</div>

<!-- fetch() 쓰는 방법 
	
-->
<script>
	function updateBoard(id){
		console.log("id : " + id);
		let title = document.querySelector("#title").value;
		let content = document.querySelector("#content").value;
		
		console.log(title);
		console.log(content);
		
		let board = {
			id: id,
			title: title,
			content: content
		}

		fetch("/board/" + id,{
			method: "PUT",
			headers: {
				'content-type': 'application/json; charset=utf-8'
			},
			body: JSON.stringify(board)
		})
		.then(res => res.text())
		.then(res => {
			if(res == "ok"){
				alert("수정 성공");
				location.href="/";
			}else {
				alert("수정 실패");
			}
				
		});

	}// end of saveBoard
	
    $('.summernote').summernote({
       placeholder: 'Hello Bootstrap 4',
       tabsize: 2,
       height: 300
    });      
</script>
    
<%@ include file="layout/footer.jsp" %>
