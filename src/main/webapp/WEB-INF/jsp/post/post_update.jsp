<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>게시물 수정</h1>
<div class="d-flex justify-content-center">
	<div class="post_content">
		<h3>제목</h3>
			<div class="d-flex justify-content-center">
				<input id="subject" type="text" class="form-control" value="${post.subject}">
			</div>
		<h3>내용</h3>
		<textarea id="content" rows="20" cols="135">${post.content}</textarea>
		<div class="d-flex justify-content-between">
			<input id="file" type="file" accept=".jpg,.png,.gif,.jpeg" value="${post.imge_path}">
			<button id="postListBtn" type="button" class="btn btn-dark mb-2">목록</button>
		</div>
		<div class="d-flex justify-content-end">
			<button id="savaBtn" type="button" class="btn btn-primary mr-3" data-post-id="${post.id}">수정</button>
			<button id="clearBtn" type="button" class="btn btn-secondary">모두지우기</button>
		</div>
	</div>
</div>
<script>
$(document).ready(function(){
	// 목록 버튼
	$("#postListBtn").on('click', function(){
		location.href = "/post/post_list_view?offset=0";
	});
	// 모두 지우기
	$("#clearBtn").on('click', function(){
		$('#subject').val("");
		$('#content').val("");
	});
	// 저장 버튼
	$("#savaBtn").on('click', function(){
		
		let postId = $("#savaBtn").data('post-id');
		let subject = $('#subject').val();
		let content = $('#content').val();
		let file = $('#file').val();
		
		
		if(subject.length < 1){
			alert("제목을 입력하세요");
			return;
		}
		
		if(content == ""){
			alert("내용을 입력하세요");
			return;
		}
		// 이미지 확장자 검증 - 파일이 업로드 된 경우
		
		if(file != ""){
			let ext = file.split(".").pop().toLowerCase(); // 파일경로에서 .으로 나누고 배열에 저장 후 마지막 문자열 가져오고 소문자로 변경
			if($.inArray(ext, ["gif","jpeg","jpg","png"]) == -1) {
				alert("gif, jpeg, jpg, png 파일만 업로드 할 수 있습니다.");
				$('#file').val(""); // 파일을 비운다.
				return;
			}
		}
		
		let formData = new FormData();
		formData.append("postId", postId); 
		formData.append("subject", subject); 
		formData.append("content", content);
		formData.append("file", $('#file')[0].files[0]); 
		
		console.log(postId);
		console.log(subject);
		console.log(content);
		console.log(file);
		$.ajax({
			type : "put"
			, url : "/post/update"
			, data : formData
			, enctype: "multipart/form-data"	 // 파일 업로드 필수 설정
			, processData: false			// 데이터의 들어가는 것을 String으로 만들어 주는 것을 꺼줌, 파일 업로드 필수 설정
			, contentType: false			//	파일 업로드 필수 설정
			, success : function(data){
				if(data.result == "success"){
					alert("메모가 저장되었습니다.");
					location.href = "/post/post_list_view?offset=0";
				} else {
					alert(data.errorMessage);
				}
			} 
			, error : function(e){
				alert("통신에 실패 했습니다.");
			}
		});
	});
 	
});

</script>