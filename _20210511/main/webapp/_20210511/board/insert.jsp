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
BoardVO vo = new BoardVO();

vo.setTitle(request.getParameter("title"));
vo.setContent(request.getParameter("content").replace("\r\n", "<br>"));

int result = dao.insert(vo);

if (result > 0) {
	response.sendRedirect("index.jsp");
} else {
	out.print("쓰기 실패");
}
%>

<br>
<a href="lndex.jsp">목록</a>

</body>
</html>