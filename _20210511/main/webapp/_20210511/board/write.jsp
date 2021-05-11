<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
</head>
<body>

<h2>글 쓰기</h2>
<hr>
<form action="insert.jsp" method="post">
	<input type="text" name="title"><br>
	<p><textarea rows="10" cols="30" name="content"></textarea></p>
	<input type="submit" value="write">
</form>

<br>
<a href="index.jsp">목록</a>

</body>
</html>