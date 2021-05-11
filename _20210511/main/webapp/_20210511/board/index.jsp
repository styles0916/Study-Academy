<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="_20210511.board.*" %>
<%@ page import="java.util.*" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
</head>
<body>

<h2>글 목록</h2>
<hr>
<%
BoardDAO dao = new BoardDAO();
List<BoardVO> list = dao.select();
for (int i = 0; i < list.size(); i++) {
%>
	<%=list.get(i).getBoardno() %> 
	<a href="detail.jsp?boardno=<%=list.get(i).getBoardno()%>"><%=list.get(i).getTitle() %></a>
	<i><%=list.get(i).getRegdate() %> / <%=list.get(i).getDatemodified() %></i><br>
<% 
} 
%>

<br>
<a href="write.jsp">글쓰기</a>

</body>
</html>