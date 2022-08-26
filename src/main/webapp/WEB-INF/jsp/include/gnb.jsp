<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>    
  <h1>사내 게시판</h1>
  <div class="d-flex justify-content-end">
	  <c:if test="${not empty userNickname}">
	  	 ${userNickname} <a href="/user/sign_out">로그 아웃</a>
	  </c:if>
  </div>