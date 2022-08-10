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
				<td>${post.subject}</td>
				<td></td>
				<td>${post.countView}</td>
				<td></td>
			</tr>
		</tbody>
		</c:forEach>
	</table>
</div>
<div class="d-flex justify-content-end">
		<a href="/post/post_create_view" id="createBtn" type="button" class="btn btn-primary text-light">작성</a>
</div>

<script>

	
</script>
