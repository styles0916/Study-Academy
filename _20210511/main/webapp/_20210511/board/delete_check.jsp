<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>삭제하시겠습니까?</h2>
<hr>
<form action="delete.jsp?boardno=<%=request.getParameter("boardno") %>" method="post">
	<input type="submit" value="삭제실행">
</form>

<form action="detail.jsp?boardno=<%=request.getParameter("boardno") %>" method="post">
	<input type="submit" value="삭제취소">
</form>

</body>
</html>