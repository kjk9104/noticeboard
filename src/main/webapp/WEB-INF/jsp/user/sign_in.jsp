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
		<a href="/user/sign_up_view"  class="btn btn-secondary ml-3" >회원가입</a> 
	</div>
	<div class="d-flex justify-content-end mt-3"> 
<!-- 	<button data-whatever="@mdo"  >쪽지 보내기</button> -->
			<button  type="button" class="btn btn-danger" data-toggle="modal" data-target="#forgotIDPW">아이디 비밀번호 찾기</button> 
	</div>
	</div>
</div>
<!-- 아이디 비밀번호 찾기  -->
<div class="modal fade" id="forgotIDPW">
		<div class="modal-dialog modal-dialog-centered">
			<div class="modal-content">
		      <div class="modal-body d-flex justify-content-center form-control">
	          	<button type="button" class="btn btn-success form-control" data-toggle="modal" data-target="#findID"  data-dismiss="modal">아이디 찾기</button>
		      </div> 
		      <div class="modal-body d-flex justify-content-center">
		 		<button type="button" class="btn btn-primary form-control" data-toggle="modal" data-target="#findPW" data-dismiss="modal">비밀번호 찾기</button>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-secondary" data-dismiss="modal">닫기</button>
		      </div> 
		     </div>
		</div>
</div>

<!-- 아이디 찾기  -->
<div class="modal" id="findID">
	<div class="modal-dialog modal-dialog-centered">
		<div class="modal-content">
			<div class="modal-body">
				이름을 입력해주세요<input class="form-control">
				전화번호를 입력해주세요<input class="form-control">
			</div>
			<div class="modal-footer">
		        <button type="button" class="btn btn-success">찾기</button>
		        <button type="button" class="btn btn-secondary" data-dismiss="modal">닫기</button>
		 	</div>
		</div>
		 
	</div>
</div>

<!-- 비밀번호 찾기  -->
<div class="modal" id="findPW">
	<div class="modal-dialog modal-dialog-centered">
		<div class="modal-content">
			<div class="modal-body">
				아이디를 입력해주세요<input class="form-control">
				이메일을 입력해주세요<input class="form-control">
			</div>
			<div class="modal-footer">
		        <button type="button" class="btn btn-success">찾기</button>
		        <button type="button" class="btn btn-secondary" data-dismiss="modal">닫기</button>
		 	</div>
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
					location.href = "/post/post_list_view?offset=0&&selectBox='최신순'"
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