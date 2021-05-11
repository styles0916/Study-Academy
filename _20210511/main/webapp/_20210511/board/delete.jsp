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
<%
BoardDAO dao = new BoardDAO();

int result = dao.delete(Integer.parseInt(request.getParameter("boardno")));

if (result > 0) {
	response.sendRedirect("index.jsp");
} else {
	out.print("삭제 실패");
}
%>

<br>
<a href="lndex.jsp">목록</a>

</body>
</html>