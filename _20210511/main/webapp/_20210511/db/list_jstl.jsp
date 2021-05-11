<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ page import="_20210511.student.*" %>    
 <%@ page import="java.util.*" %> 
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
//1. StudentDAO 객체 생성 (= db연결, statement객체 생성)
	StudentDAO dao = new StudentDAO();
//2. select() 호출
	List<StudentVO> list = dao.select();
	request.setAttribute("list", list);

// ──────────위의 것이 없다면──────────
// ── jstl로 쓰는 것이 훨씬 간단하긴 함 ──

// 3. 리턴값(리스트) 출력
%>

<c:forEach var="vo" items="${list }">
	${vo.studno } ${vo.name } ${vo.id } ${vo.grade } ${vo.jumin }<br>
</c:forEach>

<br>

<%
	list = dao.select3();
	request.setAttribute("list2", list);
%>

<c:forEach var="vo" items="${list2 }">
	<c:forEach var="volist" items="${vo.list }">
		${volist }
	</c:forEach><br>
</c:forEach>

</body>
</html>