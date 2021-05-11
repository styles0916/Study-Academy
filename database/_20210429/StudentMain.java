package chapter_sp.database._20210429;

import java.util.List;
import java.util.Map;

public class StudentMain {

	public static void main(String[] args) throws Exception {

//		객체를 만드는 순간 접속이 되는 것
		StudentDAO dao = new StudentDAO();

		StudentVO vo = new StudentVO();
		vo.setStudno(999999);
		vo.setName("홍길동");
		vo.setId("hong");
		vo.setGrade(1);
		vo.setJumin("200101");

//		◆ INSERT ◆
//		int r = dao.insert(vo);
//		if (r > 0) {
//			System.out.println(r);
//			System.out.println("정상적으로 등록되었습니다.");
//		} else {
//			System.out.println("등록 실패");
//		}
		
//		◆ 상세 ◆
//		StudentVO data = dao.selectOne(999999);
//		System.out.println("학번 : " + data.getStudno());
//		System.out.println("이름 : " + data.getName());
//		System.out.println("아이디 : " + data.getId());
//		System.out.println("학년 : " + data.getGrade());
//		System.out.println("주민번호 : " + data.getJumin());
		
//		◆ SELECT ◆
//		List<StudentVO> list = dao.select();
//		for (StudentVO v : list) {
//			System.out.println(v.getStudno() + " " + v.getName() + " " + v.getId() + " " + v.getGrade() + " " + v.getJumin());
//		}
		
//		◆ UPDATE ◆
//		vo = new StudentVO();
//		vo.setStudno(999999);
//		vo.setName("김길동");
//		vo.setId("kim");
//		vo.setGrade(2);
//		vo.setJumin("210101");
//		int r = dao.update(vo);
//		if (r > 0) {
//			System.out.println(r);
//			System.out.println("정상적으로 수정되었습니다.");
//		} else {
//			System.out.println("수정 실패");
//		}
		
//		◆ DELETE ◆
//		if(dao.delete(999999) > 0) {
//			System.out.println("정상적으로 삭제되었습니다.");
//		} else {
//			System.out.println("삭제 실패");
//		}
		
//		◆ SELECT ver.2 ◆
		List<Map<String, Object>> list2 = dao.select2();
		
		for (Map<String, Object> m : list2) {
			System.out.println(m.get("studno") + " " + m.get("name") + " " + m.get("id") + " " + m.get("grade") + " " + m.get("jumin"));
		}

		
		dao.close();
	}

}
