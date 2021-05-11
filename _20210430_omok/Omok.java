package cloudstudying._20210430_omok;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Omok {
	public static void main(String[] args) {
		Player user = new Player("사용자", "●");
		Player computer = new Player("컴퓨터", "○");
		Board board = new Board(19);
		play(board, user, computer);
	}

	private static void play(Board board, Player user, Player computer) {
		board.print();

		Scanner sc = new Scanner(System.in);
		StringTokenizer st;

		String s; // 좌표를 받기위한 문자열 선언

		int a = 0; // 입력 받은 문자열 최종 행 번호
		int b = 0; // 입력 받은 문자열 최종 열 번호

		String[] list = new String[5]; // 검수를 위한 배열
		String result; // 배열을 문자열화 해서 비교하기위함
		String win1 = "[" + user.stone + ", " + user.stone + ", " + user.stone + ", " + user.stone + ", " + user.stone
				+ "]";
		String win2 = "[" + computer.stone + ", " + computer.stone + ", " + computer.stone + ", " + computer.stone
				+ ", " + computer.stone + "]";

		Player player1;
		Player player2;

		int count = 1;

		while (true) {

			if (count % 2 != 0) {
				player1 = user;
				player2 = computer;
			} else {
				player1 = computer;
				player2 = user;
			}

			while (true) {

				try {
					System.out.print(player1.name + " (예 : 행 열) > ");
					s = sc.nextLine();

					if (s.toUpperCase().equals("EXIT")) {
						System.out.println("종료합니다.");
						return;
					}

					st = new StringTokenizer(s, " ");
					a = Integer.parseInt(st.nextToken());
					b = (int) st.nextToken().toUpperCase().charAt(0);
					b -= 65;

					if (board.map[a][b].equals(player2.stone)) {
						System.out.println("상대방의 돌이 놓여있습니다.");
						continue;
					} else if (board.map[a][b].equals(player1.stone)) {
						System.out.println("자신의 돌이 놓여있습니다.");
						continue;
					} else {
						board.map[a][b] = player1.stone;
						board.print();
						break;
					}

				} catch (Exception e) {
					System.out.println("잘못 입력하였습니다.");
					continue;
				}

			}

//			[승패 검수]
//			행 검수
			for (int row = 0; row < board.size; row++) {
				for (int col = 0; col < board.size - 4; col++) {
					for (int i = 0; i < list.length; i++) {
						list[i] = board.map[row][col + i];
					}

					result = Arrays.toString(list);

					if (result.equals(win1) || result.equals(win2)) {
						System.out.println(player1.name + " 승리!");
						return;
					}
				}
			}

//			열 검수
			for (int col = 0; col < board.size; col++) {
				for (int row = 0; row < board.size - 4; row++) {
					for (int i = 0; i < list.length; i++) {
						list[i] = board.map[row + i][col];
					}

					result = Arrays.toString(list);

					if (result.equals(win1) || result.equals(win2)) {
						System.out.println(player1.name + " 승리!");
						return;
					}
				}
			}

//			대각선 검수 1
			for (int row = 0; row < board.size - 4; row++) {
				for (int col = 0; col < board.size - 4; col++) {
					for (int i = 0; i < list.length; i++) {
						list[i] = board.map[row + i][col + i];
					}

					result = Arrays.toString(list);

					if (result.equals(win1) || result.equals(win2)) {
						System.out.println(player1.name + " 승리!");
						return;
					}
				}
			}

//			대각선 검수 2
			for (int row = 0; row < board.size - 4; row++) {
				for (int col = board.size - 1; col >= 4; col--) {
					for (int i = 0; i < list.length; i++) {
						list[i] = board.map[row + i][col - i];
					}

					result = Arrays.toString(list);

					if (result.equals(win1) || result.equals(win2)) {
						System.out.println(player1.name + " 승리!");
						return;
					}
				}
			}
			count++;
		}
	}
}
