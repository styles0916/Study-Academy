<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="_20210511.board.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
</head>
<body>

<h2>글 수정</h2>
<hr>

<%
BoardDAO dao = new BoardDAO();

String boardno = request.getParameter("boardno");
int boardnoInt = Integer.parseInt(boardno);

BoardVO vo = dao.selectOne(boardnoInt);
%>

<form action="update.jsp" method="post">
	<input type="text" name="title" value="<%=vo.getTitle()%>"><br>
	<p><textarea rows="10" cols="30" name="content"><%=vo.getContent().replace("<br>", "\r\n")%></textarea></p>
	<input type="submit" value="modify">
	<input type="hidden" name="boardno" value="<%=boardno%>">
</form>

<form action="detail.jsp" method="post">
	<input type="submit" value="cancel">
	<input type="hidden" name="boardno" value="<%=boardno%>">
</form>

</body>
</html>