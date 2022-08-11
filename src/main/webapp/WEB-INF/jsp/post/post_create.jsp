<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>게시물 작성</h1>
<div class="content">
	<h3>제목</h3>
<div class="d-flex justify-content-center">
	<input type="text" class="form-control">
</div>
	<h3>내용</h3>
	<textarea rows="10" cols="100"></textarea>
	<input id="file" type="file" accept=".jpg,.png,.gif,.jpeg">
	<button id="postListBtn" type="button" class="btn btn-dark">목록</button>
			<div>
				<button id="clearBtn" type="button" class="btn btn-secondary">모두지우기</button>
				<button id="savaBtn" type="button" class="btn btn-primary">저장</button>
			</div>
</div>