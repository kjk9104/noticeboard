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
					<select id="selectBox">
						<option value="최신순"<c:if test="${selected eq '최신순'}">selected</c:if>>최신순</option>
						<option value="조회수"<c:if test="${selected eq '조회수'}">selected</c:if>>조회수</option>
					</select>
				</th>
				<th>제목</th>
				<th>이름</th>
				<th>조회수</th>
				<th>추천수</th>
			</tr>
		</thead>
		<c:forEach var="postList" items="${postList}" varStatus="status">
		<tbody>
			<tr>
				<td>${status.count}</td>
				<td><a href="/post/post_detail_view?postId=${postList.post.id}">${postList.post.subject}</a></td>
				<td>${postList.user.nick_name}</td>
				<td>${postList.post.countView}</td>
				<td>${postList.likeSize}</td>
			</tr>
		</tbody>
		</c:forEach>
	</table>
</div>
<div class="d-flex justify-content-center">
<a id="beforeBtn" class="btn" href="#" data-page-id="${page}">이전</a>


<c:forEach var="postList" begin="${startNum}" end="${endtNum}" varStatus="status">
	<c:if test="${page eq status.index}">
		<a class="offset btn btn-outline-primary mr-3" href="/post/post_list_view?offset=${status.index-1}&&selectBox=${selected}">${status.index}</a>
	</c:if>
	<c:if test="${page ne status.index}">
		<a class="offset btn mr-3" href="/post/post_list_view?offset=${status.index-1}&&selectBox=${selected}">${status.index}</a>
	</c:if>
</c:forEach>
	<a id="afterBtn" class="btn" href="#" data-page-id="${page}"data-totalpage="${totalpage}">다음</a>
</div>
<div class="d-flex justify-content-end">
		<a href="/post/post_create_view" id="createBtn" type="button" class="btn btn-primary text-light">작성</a>
</div>
<div class ="d-flex justify-content-center">
	<div class="input-group serchBox">
	  <input type="text" class="form-control" placeholder="검색어를 입력해주세요">
	  <div class="input-group-append">
	    <button class="btn btn-outline-secondary searchBtn" type="button">검색</button>
  	</div>
</div>
</div>

<!--지워야 될 항목들 테스트를 위한 공간  -->



<!-- 지워야 될 항목들 테스트를 위한 공간 -->


<script>
$(document).ready(function(){
	// 이전버튼 클릭시
	$("#beforeBtn").on('click', function(){
		let page = $('#beforeBtn').data('page-id');
		let selected = $('#selectBox').val();
		if(page<=0){
			page = 1;
		}
		location.href="/post/post_list_view?offset="+(page-1)+"&&selectBox="+(selected);
	});
	// 다음버튼 클릭시
	$("#afterBtn").on('click', function(){
		let page = $('#afterBtn').data('page-id');
		let totalpage = $('#afterBtn').data('totalpage');
		let selected = $('#selectBox').val();
		console.log(page);
		console.log(totalpage);
		console.log(selected);
		let pageNum = page+1;
		if(pageNum >= totalpage){
			pageNum = totalpage;
		}
		location.href="/post/post_list_view?offset="+(pageNum)+"&&selectBox="+(selected);
	});
	
	// 셀렉트 박스 최신수 조회수 추천수 
	$("#selectBox").on('change',function(){
		let page = $('#afterBtn').data('page-id');
		let selected = $(this).val();

		location.href="/post/post_list_view?offset="+(page)+"&&selectBox="+(selected);
		
	});
	
	$(".searchBtn").on('click',function(){
		let page = $('#afterBtn').data('page-id');
		let selected = $(this).val();
		let searchWord = $(this).parents().siblings('input').val();
		searchWord = "%25"+searchWord+"%25";
		
		location.href = "/post/post_list_view?offset="+(page)+"&&selectBox=최신순&&searchWord="+(searchWord);
	});
	
	
	
});
	
</script>
