<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="d-flex justify-content-center">
	<div>
		<div class="mt-3">아이디 : ${user.login_id}</div>
		<div class="mt-3">비밀번호 : <button class="btn btn-outline-danger" data-toggle="modal" data-target="#change_ps_btn">변경</button></div>
		<div class="mt-3">이름 : ${user.name}</div>
		<div class="mt-3">닉네임 : ${user.nick_name}</div>
		<div class="mt-3">이메일 : ${user.eMail}</div>
		<div class="mt-3">휴대전화 : ${user.phone_num}</div>
	</div>
</div>
<div class="d-flex justify-content-end mt-5">
	<button type="button" id="user_del" class="btn btn-danger" data-user-id="${user.id}">회원 탈퇴</button>
</div>

<div id="change_ps_btn" class="modal fade">
	<div class="modal-dialog modal-dialog-centered">
		<div class="modal-content">
			<div class="modal-bady m-3">
				기존 비밀번호를 입력해주세요
				<input type="password" id="now_pw" class="form-control">
			</div>
			<div class="modal-footer">
				<button id="put_click" class="btn btn-success">입력</button>
			</div>
		</div>
	</div>
</div>
<script>
$(document).ready(function(){
	$("#user_del").on("click", function(){
		let userId = $('#user_del').data("user-id");
		
		$.ajax({
			type : "delete"
			,url : "/user/delete"
			,data : { "userId" : userId }
			,success : function(data){
				if(data.ruselt == "success"){
					location.href("/user/sign_in_view")
					alert("탈퇴 되었습니다.");
				}else{
					alert("서버에 문제가 있습니다. 관리자에게 문의해주세요");
				}
			}
			,error : function(e){
				alert("통신의 실패했습니다.");
			}
		})
	});
});
</script>