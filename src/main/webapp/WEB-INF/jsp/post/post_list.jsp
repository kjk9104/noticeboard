<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="d-flex justify-content-center">
	<div class="title"> <h1>자유 게시판</h1> </div>
	<table class="table">
	
		<thead>
			<tr>
				<th>
					<select>
						<option>최신순</option>
						<option>조회수</option>
						<option>추천수</option>
					</select>
				</th>
				<th>제목</th>
				<th>이름</th>
				<th>조회수</th>
				<th>추천수</th>
			</tr>
		</thead>
		<c:forEach var="post" items="${postList}" varStatus="status">
		<tbody>
			<tr>
				<td>${status.count}</td>
				<td><a href="/post/post_detail_view?postId=${post.id}">${post.subject}</a></td>
				<td></td>
				<td>${post.countView}</td>
				<td></td>
			</tr>
		</tbody>
		</c:forEach>
	</table>
</div>
<div class="d-flex justify-content-center">
<a id="beforeBtn" class="btn" href="#" data-page-id="${page}">이전</a>
<c:forEach var="postList" begin="1" end="${totalpage}" varStatus="status">
	<c:if test="${page eq status.count-1}">
		<a class="offset btn btn-outline-primary mr-3" href="/post/post_list_view?offset=${status.count-1}">${status.count}</a>
	</c:if>
	<c:if test="${page ne status.count-1}">
		<a class="offset btn mr-3" href="/post/post_list_view?offset=${status.count-1}">${status.count}</a>
	</c:if>
</c:forEach>
<a id="afterBtn" class="btn" href="#" data-page-id="${page}"data-totalpage="${totalpage}">다음</a>
</div>
<div class="d-flex justify-content-end">
		<a href="/post/post_create_view" id="createBtn" type="button" class="btn btn-primary text-light">작성</a>
</div>

<script>
$(document).ready(function(){
	$("#beforeBtn").on('click', function(){
		let page = $('#beforeBtn').data('page-id');
		if(page<=0){
			page = 1;
		}
		location.href="/post/post_list_view?offset="+(page-1);
	});
	
	$("#afterBtn").on('click', function(){
		let page = $('#afterBtn').data('page-id');
		let totalpage = $('#afterBtn').data('totalpage');
		let pageNum = page+1;
		if(pageNum >= totalpage){
			page = totalpage-1;
		}
		location.href="/post/post_list_view?offset="+(page);
	});
});
	
</script>
