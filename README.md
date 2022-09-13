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
## DB
### 관계 테이블
![image](https://user-images.githubusercontent.com/83809806/189813399-b64920b4-812c-4914-8cae-4d15956ce16a.png)


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

### message
- 쪽지 보내기 기능
- 내가 받은 메세지 페이지 나열
- 내가 준 메세지 페이지 나열

### notice
- 이미지 포함 달력에 공지일정 추가 기능(관리자만 이용 가능)
- 이미지 포함 삭제 기능(관리자만 이용 가능)
- 해당 날짜 제목 선택시 상세 페이지 이동

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
- 게시물 작성 할때 이미지를 같이 넣을수 
