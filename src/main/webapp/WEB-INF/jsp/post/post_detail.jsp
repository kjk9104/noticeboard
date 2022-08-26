<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="d-flex justify-content-center">
	<div class="post_detail"> 
		<div class="d-flex">
			<h3 class="mr-5">제목</h3> <span>${post.post.subject}</span> 
		</div>
		<div class="post_content d-flex">
			<h3 class="mr-5">내용</h3> <span>${post.post.content}</span>
		</div>
		<c:if test="${userId eq post.user.id}">
			<div class="d-flex justify-content-end m-3">
				<a id="updatePostBtn" type="button" href="/post/post_update_view?postId=${post.post.id}" class="btn btn-light">수정</a>
				<button id="delPostBtn" type="button" data-post-id="${post.post.id}" class="ml-3 btn btn-secondary">삭제</button>
			</div>
		</c:if>
		<!-- 댓글 쓰기  -->
		<div class="d-flex">
			<label class="col-sm-2 col-form-label"><h3>댓글</h3></label>
			<input id="comment" class="form-control input-sm">
			<button id="commentBtn" type="button" data-post-id="${post.post.id}" class="btn btn-secondary">입력</button>
		</div> 
		<!-- 댓글 리스트  -->
		<c:forEach var="comment" items="${post.commentView}">
		<div>
			<div class="d-flex">
				<label class="col-sm-2 col-form-label"><h3>${comment.user.nick_name}</h3></label>
				<span>${comment.comment.content}</span>
				<a class="comment_comentBtn ml-3 mr-3"href="#">답글</a>
				<c:if test="${userId eq comment.user.id || userId eq post.user.id}">
					<a class="commentDelBtn" data-comment-id="${comment.comment.id}" href="#">삭제</a>
				</c:if>
			</div>
			<!-- 답글 리스트  -->
			<div class='comment_comment_box d-none'>
				<div class="d-flex mb-3">
					<label class='col-sm-2 col-form-label'>
						<h3></h3>
					</label>
					<div>
						<c:forEach var="commentComment" items="${comment.commentComment}">
							▶${commentComment.user.nick_name} :
							 ${commentComment.commentComment.content} </br>
						</c:forEach>
					</div>
					
				</div>	
			</div>
			<!-- 답글 입력창  -->
			<div class='comment_commentDiv d-none'>
				<div class="d-flex">
					<input type='text' class='form-control' placeholder='답글입력'>
					<a class='add_comment_comment btn btn-primary text-light' data-comment-id='${comment.comment.id}'>입력</a>
				</div>
			</div>
		</div> 
		</c:forEach>
		<div class="d-flex justify-content-end mt-3">
			<a href="/post/post_list_view?offset=0" class="btn btn-info">목록</a>
		</div>
	</div>
	
</div>
<script>
$(document).ready(function(){
	// 게시물 삭제 버튼
	$("#delPostBtn").on('click', function(){
		alert("게시물이 삭제 되었습니다.");
		let postId= $(this).data('post-id');
		 
		$.ajax({
			type : "delete"
			,url : "/post/delete"
			,data : {
				"postId" : postId
			}
			,success :  function(data){
				if(data.result == "success"){
					location.href="/post/post_list_view?offset=0"
				}else{
					alert("삭제에 실패했습니다.");
				}
			}
			,error : function(e){
				alert("통신이 실패 했습니다.");
			}
			
		});
	});
	

	// 댓글입력
	$("#commentBtn").on('click',function(){
		let content = $("#comment").val();
		let postId = $(this).data('post-id');
		
		if(comment == ""){
			alert("댓글을 입력해주세요");
		}
		
		$.ajax({
			type : "POST"
			,url : "/comment/create"
			,data : {
				"postId" : postId
				,"content" : content
			}
			,success :  function(data){
				if(data.result == "success"){
					location.reload(true);
				} 
			}
			, error: function(e){
				alert("통신이 실패 했습니다.");
			}
		});
	});
	// 댓글 삭제
	$(".commentDelBtn").on('click', function(e){
		e.preventDefault();
		let commentId = $(this).data('comment-id');
			$.ajax({
			type : "DELETE"
			,url : "/comment/delete"
			,data : {
				"commentId" : commentId
			}
			,success :  function(data){
				if(data.result == "success"){
					location.reload(true);
				} 
			}
			, error: function(e){
				alert("통신이 실패 했습니다.");
			}
		});
	});
	
	
	// 답글(대 댓글) 달기
	let comment_commentBoolen = true;
	$(".comment_comentBtn").on('click', function(e){
		e.preventDefault();
		if(comment_commentBoolen){
			$(this).parent('div').siblings('div').removeClass('d-none');
			$(this).parent('div').after("");
			comment_commentBoolen = false;
		}else{
			$('.comment_comment_box').addClass('d-none');
			$('.comment_commentDiv').addClass('d-none');
			comment_commentBoolen = true;
			return;
		}
	});
	
	// 답글(대 댓글) 입력
	$(".add_comment_comment").on('click', function(){
		let commentId = $(this).data('comment-id');
		let commentComment = $(this).siblings('input').val();
			$.ajax({
				url : "/comment/comment_create"
				,data : {
					"commentId" : commentId
					,"commentComment" : commentComment
				}
				,success :  function(data){
					if(data.result == "success"){
						location.reload(true);
					} 
				}
				, error: function(e){
					alert("통신이 실패 했습니다.");
				}
			});
	});
	
	

	
});
</script>