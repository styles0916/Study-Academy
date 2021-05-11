package chapter_sp.database._20210429;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DataBaseEx {

	public static void main(String[] args) {

		/*
		 * ◆ DB 처리 순서 ◆
		 * 
		 * 1. 드라이버(클래스) 로드 
		 * 2. DB에 접속(host / ip / id / password / db명) 
		 * 3. SQL 실행 할 객체가 있어야 한다. 
		 * 4. SQL 실행 
		 * 5. SQL 실행 결과 처리 
		 * 6. close()
		 *
		 */

//		데이터베이스 접속(Connection) 객체 선언
		Connection conn = null;

//		SQL을 실행하기 위한 객체 선언
		Statement stmt = null;

//		SQL 실행 결과를 담을 객체 선언
		ResultSet rs = null;

		try {
//			1. 드라이버 로드
			Class.forName("org.mariadb.jdbc.Driver");

//			2. DB 접속
			conn = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/javadb", "root", "root1234");

//			3. statement 객체 생성
			stmt = conn.createStatement();

//			4. SQL 실행
			rs = stmt.executeQuery("SELECT * FROM student");
//			stmt.executeUpdate() -> INSERT, UPDATE, DELETE 대신 사용
			
//			5. 결과 출력
			while (rs.next()) { // true, false를 리턴하고, 커서를 이동시킴
				System.out.println(rs.getString("name")); // 컬럼명
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		} finally {
			try {conn.close();} catch (Exception e) {}
			try {stmt.close();} catch (Exception e) {}
			try {rs.close();} catch (Exception e) {}
		}
	}
}
