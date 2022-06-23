$(document).ready(function() {
	$('#summernote').summernote({
       placeholder: 'Hello Bootstrap 4',
       tabsize: 2,
       height: 300,
    });
    
    $('#btn-write').bind("click", () => {
		alert("작성버튼 눌림");
		write.savewrite();
	});  
});

let write = {
	savewrite: function(){
		let board = {
			title: $('#title').val(),
			content: $('#summernote').val()
		}
		console.log(board);
		$.ajax({
			type: "POST",
			url: "/api/board/write",
			contentType: "application/json; charset=utf-8",
			data: JSON.stringify(board),
			dataType: "json"
		}).done(function(data){
			if(data.status != 406){
				alert("포스팅 성공");
			}else{
				alert(data.message);
			}
		}).fail(function(){
			
		})
	}
}


 
