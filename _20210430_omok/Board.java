package cloudstudying._20210430_omok;

public class Board {
	int size;
	String[][] map;

	Board(int size) {
		this.size = size;
		map = new String[size][size];
		for (int row = 0; row < size; row++) {
			for (int col = 0; col < size; col++) {
				map[row][col] = ".";
			}
		}
	}

	public void print() {

//		행 표시 숫자 + 보드 프린트
		for (int row = 0; row < size; row++) {
			System.out.printf("%2d", row);
			for (int col = 0; col < size; col++) {
				System.out.print(" " + map[row][col]);
			}
			System.out.println();
		}

//		열 표시 공백
		for (int i = 0; i < Integer.toString(size).length(); i++) {
			System.out.print(" ");
		}
//		열 표시 알파벳
		for (int i = 0; i < size; i++) {
			System.out.print(" " + (char)(65 + i));
		}
		System.out.println();
	}
}