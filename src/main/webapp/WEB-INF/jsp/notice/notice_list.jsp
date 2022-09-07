<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<h1>공지 일정</h1>
	<div id="noticeCreateBtn" class="d-flex justify-content-end mb-3">
	<c:if test="${userNickname eq '관리자'}">
    	<button class="btn">일정 추가</button>
    </c:if>
    </div>
    <div class="d-flex justify-content-center">
	    <div id="calendar">
	    </div>
    </div>
<script>
$(document).ready(function(){
	let noticeList = "${noticeList.size()}";
	
	$("#noticeCreateBtn").on('click',function(){
		location.href = "/notice/notice_create_view";
	});
	$("#nonBtn").on('click',function(){
		let noticeList = "${noticeList.size()}";
		var arr = new Array();
		<c:forEach var="notice" items="${noticeList}">
			arr.push({
				subject : "${notice.subject}"
				,start_schedule : "${notice.start_schedule}"
				,end_schedule : "${notice.end_schedule}"
			})
		</c:forEach>
	console.log(arr[0].subject);
	});

	$("#calendar").fullCalendar({
		<c:if test="${userNickname eq '관리자'}">
	        editable : true,
	    </c:if>
	        navLink : true,
	        eventLimit : true,
	        events : [
	       	 <c:forEach var="notice" items="${noticeList}">
		         {
		             title  : "${notice.subject}",
		             start  : '<fmt:formatDate value="${notice.start_schedule}" pattern="yyyy-MM-dd"/>',
		             end    : '<fmt:formatDate value="${notice.end_schedule}" pattern="yyyy-MM-dd"/>',
		             url : "/notice/notice_detail_view?id=${notice.id}"
		         },
		     </c:forEach>
	      	]
	 });
// 	}
});
</script>