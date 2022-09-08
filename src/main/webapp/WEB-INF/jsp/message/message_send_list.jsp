<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>    
    
<div id="message_nav" class="row d-flex justify-content-end">   
	<div> 
		<div class="mt-3">
			<a href="message_receive_list_view">받은 메세지함</a>
		</div>
			<hr>
		<div  class="mt-3">
			<a href="message_send_list_view">보낸 메세지함</a>
		</div>
	</div>
	<button type="button" class="btn btn-primary align-self-end" data-toggle="modal" data-target="#exampleModal" data-whatever="@mdo">쪽지 보내기</button>
</div>



<h1 class="d-flex justify-content-center mb-5">보낸 메세지 함</h1>
<div class="d-flex justify-content-center">
	<table id="msg_table" class="table">
		<thead>
			<tr>
				<th>보낸사람</th>
				<th>쪽지 내용</th>
			</tr>
		</thead>
	<c:forEach var="message" items="${MessageList}">
		<tbody>
			<tr>
				<td>${message.user_nickName}</td>
				<td>${message.talk}</td>
			</tr>
		</tbody>
	</c:forEach>
	</table>
</div>

<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">쪽지</h5>
      </div>
      <div class="modal-body">
        <form>
          <div class="form-group">
            <label for="recipient-name" class="col-form-label">유저 닉네임</label>
            <input type="text" class="form-control" id="recipient-name">
            <div class="d-flex justify-content-end mt-3">
            	<div id="falseNickname" class="small text-danger d-none">존재 하지 않는 닉네임 입니다.</div>
				<div id="trueNickname" class="small text-success d-none">존재하는 닉네임 입니다.</div>
            </div>
          </div>
          <div class="form-group">
            <label for="message-text" class="col-form-label">쪽지 내용</label>
            <textarea class="form-control" id="message-text"></textarea>
          </div>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" id="sendMsg">쪽지 보내기</button>
        <button type="button" class="btn btn-secondary" data-dismiss="modal">닫기</button>
      </div>
    </div>
  </div>
</div>



<script>
$(document).ready(function(){
	
	// 닉네임 있는지 검사
	let chkNick = true;
	$("#recipient-name").on('change',function(){
		let userNickname = $(this).val().trim();
		$("#trueNickname").addClass('d-none');
		$("#falseNickname").addClass('d-none');
		
		$.ajax({
			type : "post"
			,url : "/message/chkNick"
			,data : {"userNickname" : userNickname}
			,success : function(data){
				if(data.result == "success"){
					chkNick= false;
					$("#trueNickname").removeClass('d-none');
				}else{
					$("#falseNickname").removeClass('d-none');
				}
			}
			,errer(e){
				alert("통신 오류");
			}
		});
	});
	
	// 쪽지 보내기
	$("#sendMsg").on('click',function(){
		let otherNickname = $("#recipient-name").val().trim();
		let msg = $("#message-text").val();
		
		if(otherNickname === ""){
			alert("닉네임을 입력해주세요");
			return;
		}
		
		if(chkNick){
			alert("닉네임을 확인해주세요");
			return;
		}
		
		if(msg === ""){
			alert("메세지를 입력해주세요 입력해주세요");
			return;
		}
		
		$.ajax({
			type : "post"
			,url : "/message/sendMsg"
			,data : {
				"otherNickname" : otherNickname
				,"msg" : msg
			}
			,success : function(data){
				if(data.result == "success"){
					alert("쪽지를 보냈습니다.");
					location.reload(true);
				}else{
					alert("서버 오류");
				}
			}
			,erorr : function(e){
				alert("통신 오류");
			}
		});
	});
	
	
	
	
	
});
</script>	