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
				<div id="idCheckOk" class="small text-success d-none">사용 가능한 아이디 입니다.</div>
			 	</div>
				비밀번호<input id="password" type="password" class="form-control mb-3">
				<div id="passwordCheckLength" class="small text-danger d-none">최소 6자 이상 비밀번호를 사용해주세요</div>
				<div id="passwordCheckString" class="small text-danger d-none">영문과 숫자를 조합해주세요</div>
				<div id="passwordCheckCharacters" class="small text-warning d-none">특수문자를 포함한것이 안전합니다.</div>
				<div id="passwordCheckOk" class="small text-success d-none">안전합니다.</div>
				비밀번호 확인<input id="duplicatedPassword" password" type="password" class="form-control mb-3">
				<div id="duplicatedPasswordCheckLength" class="small text-danger d-none">최소 6자 이상 비밀번호를 사용해주세요</div>
				<div id="duplicatedPasswordCheckduplicated" class="small text-danger d-none">불일치 합니다</div>
				<div id="duplicatedPasswordCheckOk" class="small text-success d-none">일치 합니다</div>
				이름<input id="name" type="text" class="form-control">
				닉네임
				<div class="d-flex">
					<input id="nickName" type="text" class="form-control mr-3 mb-3">
					<button id="chk_duplicated_nickname" class="btn btn-success mb-3">중복확인</button>
				</div>
				<div id="nickNameCheckduplicated" class="small text-danger d-none">이미 사용중인 닉네임 입니다.</div>
				<div id="nickNameCheckOk" class="small text-success d-none">사용 가능한 닉네임 입니다.</div>
				이메일<input id="eMail" type="text" class="form-control mb-3">
				휴대전화<input id="phoneNum" type="text" class="form-control mb-3">
				<div class="text-primary">-없이 입력해주세요</div>
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
	let chkpassword = false;
	
	
	// 아이디 중복확인 이벤트
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
	
	
	// 닉네임 중복확인 이벤트
	$("#chk_duplicated_nickname").on('click',function(){
		let nickName = $("#nickName").val().trim();
		$("#nickNameCheckduplicated").addClass('d-none');
		$("#nickNameCheckOk").addClass('d-none');
		if(nickName == ""){
			alert("닉네임을 입력해주세요");
			return;	
		}
		$.ajax({
			url : "/user/chk_duplicated_nickName"			
			,data : { "nickName" : nickName}
			,success : function(data){
				if(data.result == true){
					$("#nickNameCheckduplicated").removeClass('d-none');
				}else if(data.result == false){
					$("#nickNameCheckOk").removeClass('d-none');
					chkNickName = true;
				}
			}
			,error : function(e){
				alert("서버 에러");
			}
		});
	});
	
	// 패스워드 이벤트
	$("#password").on('keyup',function(){
		$("#passwordCheckLength").addClass('d-none');
		$("#passwordCheckCharacters").addClass('d-none');
		$("#passwordCheckOk").addClass('d-none');
		$("#passwordCheckString").addClass('d-none');
		
		let password = $("#password").val();
		
		let pattern_spc = /[~!@#$%^&*()_+|<>?:{}]/; 
		let pattern_eng = /[a-zA-Z]/;
		
		if(password.length < 6){
			$("#passwordCheckLength").removeClass('d-none');
			return;
		}
		if(pattern_eng.test(password) == false){
			$("#passwordCheckString").removeClass('d-none');
			return;
		}
		if(pattern_spc.test(password) == false){
			$("#passwordCheckCharacters").removeClass('d-none');
			chkpassword = true;
			return;
		}
			chkpassword = true;
			$("#passwordCheckOk").removeClass('d-none');
	});
	
	$("#duplicatedPassword").on('keyup',function(){
		$("#duplicatedPasswordCheckLength").addClass('d-none');
		$("#duplicatedPasswordCheckduplicated").addClass('d-none');
		$("#duplicatedPasswordCheckOk").addClass('d-none');
		
		let password = $("#password").val();
		let duplicatedPassword = $("#duplicatedPassword").val();
		
		if(duplicatedPassword.length < 6){
			$("#duplicatedPasswordCheckLength").removeClass('d-none');
			return;
		}
		if(duplicatedPassword === password){
			$("#duplicatedPasswordCheckOk").removeClass('d-none');
			return;
		}
		if(duplicatedPassword !== password){
			$("#duplicatedPasswordCheckduplicated").removeClass('d-none');
			return;
		}
	});
	
	// 회원가입 버튼 이벤트
	$("#sign_up").on('click',function(){
		let loginId = $("#loginId").val().trim();
		let password = $("#password").val();
		let duplicatedPassword = $("#duplicatedPassword").val();
		let name = $("#name").val().trim();
		let nickName = $("#nickName").val().trim();
		let eMail = $("#eMail").val().trim();
		let phoneNum = $("#phoneNum").val().trim();
		
		let reg_email = /^([0-9a-zA-Z_\.-]+)@([0-9a-zA-Z_-]+)(\.[0-9a-zA-Z_-]+){1,2}$/;
		var pattern_num = /[0-9]/;	
		
		if(chkId == false){
			alert("아이디 중복확인을 눌러주세요");
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
		if(password !== duplicatedPassword){
			alert("패스워드가 일치하지 않습니다. 확인해주세요");
			return;
		}
		if(chkpassword == false){
			alert("패스워드를 확인해주세요");
			return;
		}
		if(name == ""){
			alert("이름을 입력해 주세요");
			return;
		}
		if(eMail == ""){
			alert("이메일을 입력해주세요");
			return;
		}
		if(reg_email.test(eMail) == false){
			alert("이메일 형식에 맞지 않습니다.");
			return;
		}
		if(phoneNum == ""){
			alert("전화번호를 입력해주세요");
			return;
		}
		if(phoneNum.includes('-')){
			alert("하이픈 '-' 제거 해주세요 를 입력해주세요");
			return;
		}
		if(pattern_num.test(phoneNum) == false){
			alert("숫자만 입력해주세요");
			return;
		}
		
	 	$.ajax({
	 		type : "POST"
	 		,url : "/user/sign_up"
	 		,data : {
	 			"loginId" : loginId
	 			,"password" : password
	 			,"name" : name
	 			,"nickName" : nickName
	 			,"eMail" : eMail
	 			,"phoneNum" : phoneNum
	 		}
	 		,success : function(data){
	 			if(data.result == "success"){
	 				alert("회원가입이 완료 되었습니다.");
	 				location.href = "https://www.google.com/"
	 			}
	 		}
	 		,error : function(e){
	 			alert("서버 오류입니다.");
	 		}
	 	});
		
	});
});

</script>
