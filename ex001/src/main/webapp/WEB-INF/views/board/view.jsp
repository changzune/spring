<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>게시판 글보기</h3>
페이지 : ${page }
글번호: ${vo.no } <br>
제목: ${requestScope.vo.title }<br>
내용: ${vo.content }<br>
작성자: ${vo.writer }<br>

<a href="update.do">글 수정</a>
<form action = "delete.do" method="post">
<button>글삭제</button>
</form>
<a href="list.do">리스트</a>
</body>
</html>