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

<h2>글 상세</h2>
<hr>
<%
BoardDAO dao = new BoardDAO();

String boardno = request.getParameter("boardno");
int boardnoInt = Integer.parseInt(boardno);

BoardVO vo = dao.selectOne(boardnoInt);
%>

<h2>[<%=vo.getBoardno()%>] <%=vo.getTitle() %></h2>
<p><i>작성일 : <%=vo.getRegdate() %> / 수정일 : <%=vo.getDatemodified() %></i></p>
<p><%=vo.getContent() %></p>

<br>
<a href="index.jsp">목록</a>
<a href="modify.jsp?boardno=<%=boardno%>">수정</a>
<a href="delete_check.jsp?boardno=<%=boardno%>">삭제</a>


</body>
</html>