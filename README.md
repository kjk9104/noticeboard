# noticeboard
<u></u>
## 프로젝트 이유
- 배운것들을 대부분 표현 할 수 있는 사이트를 만들기 위해 게시판 사이트를 선택

## 누가 이용할 수 있는가
- 회사 내에서 간단하게 사용 할수 있는 사이트

## 어떤 기술을 썻는가?
### Front
- HTML
- CSS
- JavaScript



### Back
##### Language
- JAVA

##### FrameWork
- Spring Boot
- JSP

##### DataBase
- MySQL

##### Server
- AWS
#### 사용 API
- Fullcalendar

## 진행 일정
- 8/2 ~ 8/26
- DB 설계
  - 3일
- URL 설계
  - 1일
  
  
- 회원가입 로그인 페이지 마크업
  - 1일
- 회원가입(아이디 및 닉네임 중복확인 기능) 및 로그인 기능 구현
  - 1일
  
  
- 게시판 생성 기능 및 마크업
  - 1일
- 게시판 수정 및 삭제 기능 및 마크업
  - 1일 
- 게시판 리스트 불러오기 기능 및 마크업, 상세 페이지 마크업
  - 1일
- 게시판 상세 페이지 댓글 달기 답글(대댓글) 달기 기능 구현
  - 4일
- 게시판 상세 페이지 댓글 삭제 및 관련 답글(대댓글) 삭제 기능 구현 및 게시판 삭제시 관련 댓글 대댓글 삭제 
  - 2일
- 게시판 상세 페이지 추천 상세 페이지 이동시 조회수 증가 기능
  - 1일
- 제목+내용 순으로 검색 기능
  - 1일
- 최신순 목록으로 나열 기능, 조회수 목록으로 나열 기능
  - 1일

- 쪽지 (닉네임을 찾아) 보내기 기능, 내가 받은 쪽지함, 내가 준 쪽지함  및 마크업
  - 1
  
  
- fullcalendar API를 이용해 공지 일정 추가 삭제 및 마크업(관리자만 이용 가능)
  - 2일
- 해당 날짜 제목 선택시 상세 페이지 이동
  - 1일

- test 기간
  - 3일
총 25일 소요

## 버전
1.0v

## DB
### 관계 테이블
![image](https://user-images.githubusercontent.com/83809806/189837319-888f20d4-7b00-4db6-b414-a24a8ff1877d.png)


### user table
![image](https://user-images.githubusercontent.com/83809806/189807625-157cf177-a18f-435a-a81e-b84ac3b772fe.png)
### post table
![image](https://user-images.githubusercontent.com/83809806/189807769-b8d23941-3338-4dc0-8c05-1da55cc2cfbc.png)
### comment table
![image](https://user-images.githubusercontent.com/83809806/189807832-ec27d072-f144-4f06-bb5b-e8a05c7018f6.png)
### comment_comment table
![image](https://user-images.githubusercontent.com/83809806/189807880-87e86227-ebc5-4b9e-863e-4cc560d30367.png)
### like table
![image](https://user-images.githubusercontent.com/83809806/189807956-18d700ea-bfb0-4f88-9ffc-4f8f6d5878bf.png)
### message table
![image](https://user-images.githubusercontent.com/83809806/189808015-ca8149bb-f898-4c87-8cb0-5ecfc6d716a2.png)
### notice table
![image](https://user-images.githubusercontent.com/83809806/189808108-7f7e70fd-2b6a-4bf7-a7ad-ae9cd17cdc71.png)


## 기능 설명
### user
- 회원가입 기능
- 로그인 기능
- 로그 아웃 기능

### post
- 이미지 포함 게시물 생성 기능
- 이미지 포함 게시물{관련 댓글 답글(대 댓글)} 삭제 기능
- 이미지 포함 게시물 수정 기능
- 제목 클릭시 해당 상세 페이지 이동
- 댓글 달기 기능 
- 댓글 {관련 답글(대댓글)} 삭제 기능
- 답글(대 댓글) 달기 기능
- 답글(대 댓글) 삭제
- 게시물 추천기능
- 게시물 상세페이지 이동시 조회수 증가
- 제목+내용 검색 기능
- 최신순 목록으로 나열 기능(기본 페이지)
- 조회수 목록으로 나열 기능

### - 페이징 처리를 위해 리스트를 db에 limit 5  설정 offset 값을 갖고와 밑에 페이징 숫자 누를때 마다 offset 값 변경하여 페에징 처리 완료.
![image](https://user-images.githubusercontent.com/83809806/189815236-1b88f335-8b73-4f10-951f-3c535a7ec733.png)
### - 이 이후 다음 페이지 누를시 
![image](https://user-images.githubusercontent.com/83809806/189815305-ecc30feb-3d08-4418-962a-7af10317ca80.png)
### - 페이징 처리는 조건문을 걸어 offset%5 == 0 일떄 밑에 리스트를 jstl에서 index 다음 부분부터 보여주면 된다.
### - 제목과 내용을 통해 검색이 가능


### message
- 쪽지 보내기 기능
- 내가 받은 메세지 페이지 나열
- 내가 준 메세지 페이지 나열

### notice
- 이미지 포함 달력에 공지일정 추가 기능(관리자만 이용 가능)
- 이미지 포함 삭제 기능(관리자만 이용 가능)
- 해당 날짜 제목 선택시 상세 페이지 이동
### - 관리자만 수정 삭제 권한 부여 일반 유저들은 상세 페이지만 확인 가능
### - jstl 문법을 활용 하여 게시물 list를 fullcalender에 뿌림

## 트러블 슈팅
답글(대댓글) 기능을 만들때 post_id 를 통해 댓글 목록을 갖고 와서 다시 클래스에 user 정보 댓글 정보 대댓글 list 정보를 담는 것이 복잡함
페이징 처리를 위해 계산을 하는것이 

## 향후 추가할 만한 요소
- 게시판 좋아요 순으로 나열
- 새로고침으로 조회수 up 막기
- 아이디 찾기 및 비밀번호 재 설정 기능
- 이메일 인증 기능
- 친구 목록 및 추가 삭제 메세지 보내기 기능
- get 방식으로 들어갈수 있는 수정 페이지 권한이 있는 사람만들어 갈수 있게 만들기
- 이름으로 검색 가능
- 메세지 함 삭제 기능 (쌍방에서 삭제시 데이터 베이스에서 삭제)
- 메세지 상세 페이지 만들기
- 게시물 작성 할때 이미지를 같이 넣을수 있도록
- 게시물 유저 닉네임으로 검색 
- 메제시 올시 알람기능

## AWS 서버
http://54.153.105.204:8080/user/sign_in_view
## 기획서
https://ovenapp.io/project/E54dNnlEFfRynjzfmU6CaQEqceVRJuJ2#B4RJh

## 느낀점 
아직 기획서에 나온만큼 다 하지는 못했지만 향후 버전을 올리면서 위에 언급했던 기능들을 추가할 예정이다.
이 프로젝트를 통해서 상상으로 코딩했던 것들이 실제로는 구현을 하기에는 많은 무리가 있다는걸 깨닳았고 
조금더 촘촘히 생각을 할수 있는 계기가 되었다 향후 새로운 프로젝트를 한다면 이번보다 좀 더 빠르고 촘촘히 할 수 있을 것 같다.

