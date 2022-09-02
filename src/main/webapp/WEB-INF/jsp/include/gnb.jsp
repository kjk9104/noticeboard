<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>   
 <div class="d-flex justify-content-between"> 
	  <h1>사내 게시판</h1>
	  <div id="nav_box" class="d-flex justify-content-between">
	  	<a class="navbar-brand text-light" href="/post/post_list_view?offset=0">게시판</a>
	  	<a class="navbar-brand text-light" href="/message/message_receive_list_view">쪽지</a>
	  	<a class="navbar-brand text-light" href="/notice/notice_list_view">공지일정</a>
	  </div>
	  <div class="d-flex mt-4">
		  <c:if test="${not empty userNickname}">
		  	 ${userNickname} <a href="/user/sign_out">로그 아웃</a>
		  </c:if>
	  </div>
  </div>