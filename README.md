# Autocrypt 과제 전형

# Application
Autocrypt 과제 전형 요구사항에 입각한 게시판 서비스입니다.

Spring security inMemoryAuthentication을 통해 user1, user2 계정을 사용할 수 있으며 패스워드는 test 입니다.
Test를 위해 inmemory 기반 DB H2 적용하였습니다.

#API

| 기능       | uri              | method | request                                 |
| ---------- | ---------------- |------- |-------------------------------------- |
| 회원가입    | /user            | post   | {<br> "username" : "username" <br> "password" : "password" <br> "nickname" : "닉네임" <br>} |
| 로그인      | /user/login      | post   | {<br> "username" : "username" <br> "password" : "password" <br>} |
| 게시글 목록 | /board           | get    |            |
| 게시글 작성 | /board           | post   | {<br> "title" : "제목" <br> "content" : "글 내용" <br> "private" : "false" <br>} <br> (private : 비밀글 설정 여부)|
| 게시글 수정 | /board           | put    | {<br> "boardId" : 1 <br> "title" : "제목" <br> "content" : "글 내용" <br> "private" : "false" <br>} <br> (private : 비밀글 설정 여부) |
| 게시글 삭제 | /board/{boardid} | delete |             |

