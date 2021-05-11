package _20210511.board;

import java.sql.Timestamp;

public class BoardVO {
	private int boardno;
	private String title;
	private String content;
	private Timestamp regdate;
	private Timestamp datemodified;
	public int getBoardno() {
		return boardno;
	}
	public void setBoardno(int boardno) {
		this.boardno = boardno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getRegdate() {
		return regdate;
	}
	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}
	public Timestamp getDatemodified() {
		return datemodified;
	}
	public void setDatemodified(Timestamp datemodified) {
		this.datemodified = datemodified;
	}
}
