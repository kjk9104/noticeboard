<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  
  <!-- 서머노트를 위해 추가해야할 부분 -->
  <script src="/static/summernote-0.8.18-dist/summernote-lite.js"></script>
  <script src="/static/summernote-0.8.18-dist/lang/summernote-ko-KR.min.js"></script>
  <link rel="stylesheet" href="/static/summernote-0.8.18-dist/summernote-lite.min.css">
<title>SummerNoteExample</title>
</head>
<body>
	<div class="container">
	  <textarea class="summernote" name="editordata"></textarea>    
	  <div class="d-flex justify-content-end">
		<button id="sendBtn" class="btn btn-success">전송</button>
	  </div>
	</div>
	
</body>
<script>
$(document).ready(function(){
	$('.summernote').summernote({
		 height: 300,                 // 에디터 높이
		  minHeight: null,             // 최소 높이
		  maxHeight: null,             // 최대 높이
		  focus: true,                  // 에디터 로딩후 포커스를 맞출지 여부
		  lang: "ko-KR",					// 한글 설정
		  placeholder: '최대 2048자까지 쓸 수 있습니다',	//placeholder 설정
			callbacks: {	//여기 부분이 이미지를 첨부하는 부분
				onImageUpload : function(files) {
				console.log(files);
				},
// 				onPaste: function (e) {
// 					var clipboardData = e.originalEvent.clipboardData;
// 					if (clipboardData && clipboardData.items && clipboardData.items.length) {
// 						var item = clipboardData.items[0];
// 						if (item.kind === 'file' && item.type.indexOf('image/') !== -1) {
// 							e.preventDefault();
// 						}
// 					}
// 				}
			}
		});

	
	/**
	* 이미지 파일 업로드
	*/
	function uploadSummernoteImageFile(file, editor) {
		console.log(file);
		console.log(editor);
	};
	
	
	$('.summernote').summernote('backColor', 'red');

});

</script>
</html>