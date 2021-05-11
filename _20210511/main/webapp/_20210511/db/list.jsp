<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
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
//  // 1. StudentDAO 객체 생성 (= db연결, statement객체 생성)
// 	StudentDAO dao = new StudentDAO();
//  // 2. select() 호출
//  	List<StudentVO> list = dao.select();
//  	request.setAttribute("list", list);
//  // 3. 리턴값(리스트) 출력
//  	List<StudentVO> list2 = (List<StudentVO>)request.getAttribute("list");
//  	for (StudentVO vo : list2) { 
 %>
<%-- 	<%=vo.getStudno() %> <%=vo.getName() %> <%=vo.getId() %> <%=vo.getGrade() %> <%=vo.getJumin() %><br> --%>
<% 
// } 
%>

<%
// 1. StudentDAO 객체 생성 (= db연결, statement객체 생성)
	StudentDAO dao = new StudentDAO();	
// 2. select() 호출
	List<StudentVO> list = dao.select3();
 	request.setAttribute("list", list);
 	
// ──────────위의 것이 자바에서 작성되어 JSP로 넘어온 상황이라면──────────
 
// 3. 리턴값(리스트) 출력
	List<StudentVO> list2 = (List<StudentVO>)request.getAttribute("list");
	for (int i = 0; i < list2.size(); i++) {
		StudentVO vo = list2.get(i);
		for (int j = 0; j < vo.getList().size(); j++) {
			String value = vo.getList().get(j);
			out.print(value + "\t");
		}
		out.print("<br>");
	}
%>

<br>

<%
	List<Map<String, Object>> listmap = dao.select2();
	request.setAttribute("listmap", listmap);
// ──────────────────────────────────────────────────
	List<Map<String, Object>> listmap2 = (List<Map<String, Object>>)request.getAttribute("listmap");
	for (Map<String, Object> map : listmap2) {
		Set<String> key = map.keySet();
		Iterator<String> ir = key.iterator();
		
		while(ir.hasNext()){
			out.print(map.get(ir.next()) + "\t");
		}
		out.print("<br>");
	}
%>

</body>
</html>