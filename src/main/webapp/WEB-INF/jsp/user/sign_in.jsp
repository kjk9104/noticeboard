<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="d-flex justify-content-center">
	<h1>로그인</h1>
</div>
<div class="d-flex justify-content-center">
	<div class=idInput >
	<div class="mb-3 row">
		<label for="staticEmail" class="col-sm-2 col-form-label">Email</label>
		<div class="col-sm-10">
			<input type="text"  class="form-control"
				id="login_id" placeholder="아이디를 입력해주세요">
		</div>
	</div>
	<div class="mb-3 row">
		<label for="inputPassword" class="col-sm-2 col-form-label">Password</label>
		<div class="col-sm-10">
			<input type="password" class="form-control" id="login_password" " placeholder="비밀번호를 입력해주세요">
		</div>
	</div>
	<div class="d-flex justify-content-end"> 
		<button id="sign_in" type="button" class="btn btn-primary">로그인</button> 
		<a href="/user/sign_up_view"  class="btn btn-secondary ml-3">회원가입</a> 
	</div>
	</div>
</div>
<script>
$(document).ready(function(){
	$("#sign_in").on('click',function(){
		let loginId = $("#login_id").val().trim();
		let loginPassword = $("#login_password").val();
		
		$.ajax({
			type : "POST"
			,url : "/user/sign_in"
			,data : {
				"loginId" : loginId
				,"loginPassword" : loginPassword
			}
			,success :  function(data){
				if(data.result == "success"){
					location.href = "/post/post_list_view?offset=0"
				}else{
					alert(data.errorMessage);
				}
			}
			,error : function(e){
				alert("서버 에러입니다.");
			}
		});
	
	})

});


</script>