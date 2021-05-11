package _20210511.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class StudentDAO {

	Connection conn;
	Statement stmt;
	ResultSet rs;

//	생성자 : 초기화, db 연결, statement 객체 생성.
	public StudentDAO() {

		try {
			Class.forName("org.mariadb.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/javauser", "javadb", "javadb1234");

			stmt = conn.createStatement();

		} catch (Exception e) {

			System.out.println(e.getMessage());

		} finally {

		}
	}

//	등록
	public int insert(StudentVO vo) throws Exception {
		String sql = "INSERT INTO student";
		sql += "(studno, name, id, grade, jumin)";
		sql += "VALUES ";
		sql += "(" + vo.getStudno() + ", '" + vo.getName() + "', '" + vo.getId() + "', ";
		sql += " " + vo.getGrade() + ", '" + vo.getJumin() + "')";

		int r = stmt.executeUpdate(sql); // 처리된 갯수 리턴

		return r;
	}

//	상세
	public StudentVO selectOne(int studno) throws Exception {
		rs = stmt.executeQuery("SELECT * FROM student WHERE studno =" + studno);
		StudentVO vo = null;
		if (rs.next()) {
			vo = new StudentVO();
			vo.setStudno(rs.getInt("studno"));
			vo.setName(rs.getString("name"));
			vo.setId(rs.getString("id"));
			vo.setGrade(rs.getInt("grade"));
			vo.setJumin(rs.getString("jumin"));
		}
		return vo;
	}

//	목록
	public List<StudentVO> select() throws Exception {
		rs = stmt.executeQuery("SELECT * FROM student");
		List<StudentVO> list = new ArrayList<>();
		StudentVO vo = null;

		while (rs.next()) {
			vo = new StudentVO();
			vo.setStudno(rs.getInt("studno"));
			vo.setName(rs.getString("name"));
			vo.setId(rs.getString("id"));
			vo.setGrade(rs.getInt("grade"));
			vo.setJumin(rs.getString("jumin"));
			list.add(vo);
		}
		return list;
	}

//	목록 ver.2
	public List<Map<String, Object>> select2() throws Exception {
		rs = stmt.executeQuery("SELECT * FROM student");
		List<Map<String, Object>> list = new ArrayList<>();
		
		while (rs.next()) {
		
			Map<String, Object> map = new HashMap<>();

			for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {

				map.put(rs.getMetaData().getColumnLabel(i + 1), rs.getString(rs.getMetaData().getColumnLabel(i + 1)));
			}
			
			list.add(map);
		
		}
		return list;
	}

	public List<StudentVO> select3() throws Exception {
		rs = stmt.executeQuery("SELECT * FROM student");
		List<StudentVO> list = new ArrayList<>();
		StudentVO vo = null;

		while (rs.next()) {
			vo = new StudentVO();

			for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {

				vo.getList().add(rs.getString(i + 1));

			}

			list.add(vo);
		}
		return list;
	}

//	수정
	public int update(StudentVO vo) throws Exception {
//		UPDATE student SET name = '김길동', id = 'kim', jumin = '210101' WHERE studno = 999999
		return stmt.executeUpdate(
				"UPDATE student SET " + "name = '" + vo.getName() + "', id = '" + vo.getId() + "', grade = '"
						+ vo.getGrade() + "', jumin = '" + vo.getJumin() + "' WHERE studno = " + vo.getStudno());
	}

//	삭제
	public int delete(int studno) throws Exception {
//		UPDATE student SET name = '김길동', id = 'kim', jumin = '210101' WHERE studno = 999999
		return stmt.executeUpdate("DELETE FROM student WHERE studno = " + studno);
	}

	public void close() {
		try {
			conn.close();
		} catch (Exception e) {
		}
		try {
			stmt.close();
		} catch (Exception e) {
		}
		try {
			rs.close();
		} catch (Exception e) {
		}
	}

}
