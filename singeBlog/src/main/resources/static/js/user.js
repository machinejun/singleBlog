let index = {
	
	init: function() {
		$("#btn-join").bind("click", () => {
			alert("회원가입 버튼 눌림")
			this.join();
			
		});
		
		$("#btn-login").bind("click", () => {
			alert("로그인 버튼 눌림")
			this.login();
		})
		
	},
	
	join: function() {
		let user = {
			username: $("#username").val(),
			password: $("#password").val(),
			email: $("#email").val()
		}
		console.log(user);
		
		$.ajax({
			type: "POST",
			url: "/api/user/join",
			contentType: "application/json; charset=utf-8",
			data: JSON.stringify(user),
			dataType: "json"			
		}).done(function(data){
			if(data.status == 400){
				alert("회원가입 실패\n" + data.message)
			}else{
				alert("회원가입 완료")
				location.href="/"
			}
		}).fail(function(err){
			alert("회원가입 실패")
		});
	},
	
	login: function(){
		let user = {
			username: $("#username").val(),
			password: $("#password").val()
		}
		console.log(user)
		
		$.ajax({
			type: "POST",
			url: "/api/user/login",
			contentType: "application/json; charset=utf-8",
			data: JSON.stringify(user),
			dataType: "json"
		}).done(function(data) {
			if(data.status == 406){
				alert("로그인 실패\n" + data.message)
			}else{
				alert("로그인 완료")
				location.href="/"
			}
		}).fail(function() {
			alert("로그인 실패")
		})
	}
	
	
	
}

index.init();