<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <div>
	    <div class="d-flex justify-content-center">
			<h1>회원가입</h1>
		</div>
		<div class="d-flex justify-content-center">
			<div>
				아이디
				<div class="d-flex">
					<input id="loginId" type="text" class="form-control mr-3 mb-3">
					<button id="chk_duplicated_id" class="btn btn-success mb-3">중복확인</button>
				</div>
				<div>
			 	<div id="idCheckLength" class="small text-danger d-none">ID을 4자 이상 입력하세요</div>
				<div id="idCheckduplicated" class="small text-danger d-none">이미 사용중인 아이디 입니다.</div>
				<div id="idCheckOk" class="small text-success d-none">사용 가능한 아이디 입니다.</div></td>
			 	</div>
				비밀번호<input id="password" type="password" class="form-control mb-3">
				<div id="passwordCheckLength" class="small text-danger d-none">비밀번호가 위험합니다</div>
				<div id="passwordCheckduplicated" class="small text-danger d-none">이미 사용중인 아이디 입니다.</div>
				<div id="passwordCheckOk" class="small text-success d-none">사용 가능한 아이디 입니다.</div></td>
				비밀번호 확인<input id="duplicatedPassword" password" type="password" class="form-control mb-3">
				<div id="duplicatedPasswordCheckLength" class="small text-danger d-none">ID을 4자 이상 입력하세요</div>
				<div id="duplicatedPasswordCheckduplicated" class="small text-danger d-none">이미 사용중인 아이디 입니다.</div>
				<div id="duplicatedPasswordCheckOk" class="small text-success d-none">사용 가능한 아이디 입니다.</div></td>
				이름<input type="text" class="form-control">
				닉네임
				<div class="d-flex">
					<input id="nickName" type="text" class="form-control mr-3 mb-3">
					<button id="chk_duplicated_nickname" class="btn btn-success mb-3">중복확인</button>
				</div>
				<div id="nickNameCheckLength" class="small text-danger d-none">ID을 4자 이상 입력하세요</div>
				<div id="nickNameCheckduplicated" class="small text-danger d-none">이미 사용중인 아이디 입니다.</div>
				<div id="nickNameCheckOk" class="small text-success d-none">사용 가능한 아이디 입니다.</div></td>
				이메일<input type="text" class="form-control mb-3">
				휴대전화<input type="text" class="form-control mb-3">
				<div class="d-flex justify-content-end">
					<button id="sign_up"type="button" class="btn btn-primary mt-3" id="signUpBtn">회원가입</button>
				</div>
			</div>
		</div>
	</div>

<script>
$(document).ready(function(){
	let chkId = false;
	let chkNickName = false;
	$("#chk_duplicated_id").on('click',function(){
		let loginId = $("#loginId").val().trim();
		$("#idCheckLength").addClass('d-none');
		$("#idCheckduplicated").addClass('d-none');
		$("#idCheckOk").addClass('d-none');
		if(loginId == ""){
			alert("아이디를 입력해주세요");
			return;	
		}
		if(loginId.length < 4){
			$("#idCheckLength").removeClass('d-none');
			return;
		}
		
		$.ajax({
			url : "/user/chk_duplicated_id"			
			,data : { "loginId" : loginId}
			,success : function(data){
				if(data.result == true){
					$("#idCheckduplicated").removeClass('d-none');
				}else if(data.result == false){
					$("#idCheckOk").removeClass('d-none');
					chkId = true;
					console.log(chkId);
				}
			}
			,error : function(e){
				alert("서버 에러");
			}
		});
	});
	
	$("#chk_duplicated_nickname").on('click',function(){
		let nickName = $("#nickName").val().trim();
		$("#nickNameCheckLength").addClass('d-none');
		$("#nickNameCheckduplicated").addClass('d-none');
		$("#nickNameCheckOk").addClass('d-none');
		if(nickName == ""){
			alert("닉네임을 입력해주세요");
			return;	
		}
		if(nickName.length < 4){
			$("#nickNameCheckLength").removeClass('d-none');
			return false;
		}
		$.ajax({
			url : "/user/chk_duplicated_nickName"			
			,data : { "nickName" : nickName}
			,success : function(data){
				if(data.result == true){
					$("#nickNameCheckduplicated").removeClass('d-none');
				}else if(data.result == false){
					$("#nickNameCheckOk").removeClass('d-none');
					chkNickName = false;
				}
			}
			,error : function(e){
				alert("서버 에러");
			}
		});
	});
	$("#password").on('change', function(){
		let password = $("#password").val();
		if(password == ""){
			$("#nickNameCheckOk").removeClass('d-none');
		}
	});
	
	$("#sign_up").on('click',function(){
		let password = $("#password").val();
		let duplicatedPassword = $("#duplicatedPassword").val();
		let name = $("#name").val().trim();
		if(chkId == false){
			alert("아이디 중복확인을 눌러주세요");
			return;
		}
		
		if(chkNickName == false){
			alert("닉네임 중복확인을 눌러주세요");
			return;
		}
		
		if(chkNickName == false){
			alert("닉네임 중복확인을 눌러주세요");
			return;
		}
		
		if(password == ""){
			alert("패스워드를 입력해주세요");
			return;
		}
		if(duplicatedPassword == ""){
			alert("패스워드를 다시 입력해주세요");
			return;
		}

		
	});
});

</script>
