<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사내 게시판</title>
	<!-- jquery : bootstrap, datepicker -->
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>  
	
	<!-- bootstrap -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	
	<!-- fullcalendar  -->
	<link rel='stylesheet' href='/static/fullcalendar/fullcalendar.css'/>
    <script src='/static/lib/jquery.min.js'></script>
    <script src='/static/lib/moment.min.js'></script>
    <script src='/static/fullcalendar/fullcalendar.js'></script>
    
    <!-- datepicker 라이브러리 -->
	<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	
	<!-- 서머노트를 위해 추가해야할 부분 -->
  	<script src="/static/summernote-0.8.18-dist/summernote-lite.js"></script>
  	<script src="/static/summernote-0.8.18-dist/lang/summernote-ko-KR.min.js"></script>
  	<link rel="stylesheet" href="/static/summernote-0.8.18-dist/summernote-lite.min.css">
  	
	<!-- 스타일 시트  -->
	<link rel="stylesheet" type="text/css" href="/static/css/style.css">
	
</head>
<body>
	<div id="wrap">
		<header class="bg-dark bg-opacity-25">
			<jsp:include page="../include/gnb.jsp"/>
		</header>
		<section class="content">
			<jsp:include page="../${viewName}.jsp"/>
		</section>
		<footer class="bg-dark border d-flex flex-wrap align-content-center">
			<jsp:include page="../include/footer.jsp"/>
		</footer>
	</div>
</body>
</html>