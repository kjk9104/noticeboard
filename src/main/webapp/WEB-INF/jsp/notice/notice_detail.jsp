<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="d-flex justify-content-center">
	<div class="post_detail"> 
		<div class="d-flex">
			<h3 class="mr-5">제목</h3> <span>${notice.subject}</span> 
		</div>
		<div class="post_content d-flex">
			<h3 class="mr-5">내용</h3> <span>${notice.content}</span>
		</div>
		<c:if test="${userNickname eq '관리자'}">
		<div class="d-flex justify-content-end">
			<button id="delBtn" class="btn btn-dager">삭제</button>
		</div>
		</c:if>
	</div>
</div>

<script>
$(document).ready(function(){
	$("#delBtn").on('click', function(){
		let id ="${notice.id}"
		
		$.ajax({
			type : "delete"
			,url : "/notice/delete"
			,data : {
				"id" : id
			}
			,success : function(data){
				if(data.result =="success"){
					location.href="/notice/notice_list_view"
				}else{
					alert("서버에러");
				}
			}
			,error : function(e){
				alert("통신 에러");
			}
		});
		
		
	});
	
	
	
	
	
});
</script>
