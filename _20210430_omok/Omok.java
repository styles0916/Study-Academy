package cloudstudying._20210430_omok;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Omok {
	public static void main(String[] args) {
		Player user = new Player("�����", "��");
		Player computer = new Player("��ǻ��", "��");
		Board board = new Board(19);
		play(board, user, computer);
	}

	private static void play(Board board, Player user, Player computer) {
		board.print();

		Scanner sc = new Scanner(System.in);
		StringTokenizer st;

		String s; // ��ǥ�� �ޱ����� ���ڿ� ����

		int a = 0; // �Է� ���� ���ڿ� ���� �� ��ȣ
		int b = 0; // �Է� ���� ���ڿ� ���� �� ��ȣ

		String[] list = new String[5]; // �˼��� ���� �迭
		String result; // �迭�� ���ڿ�ȭ �ؼ� ���ϱ�����
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
					System.out.print(player1.name + " (�� : �� ��) > ");
					s = sc.nextLine();

					if (s.toUpperCase().equals("EXIT")) {
						System.out.println("�����մϴ�.");
						return;
					}

					st = new StringTokenizer(s, " ");
					a = Integer.parseInt(st.nextToken());
					b = (int) st.nextToken().toUpperCase().charAt(0);
					b -= 65;

					if (board.map[a][b].equals(player2.stone)) {
						System.out.println("������ ���� �����ֽ��ϴ�.");
						continue;
					} else if (board.map[a][b].equals(player1.stone)) {
						System.out.println("�ڽ��� ���� �����ֽ��ϴ�.");
						continue;
					} else {
						board.map[a][b] = player1.stone;
						board.print();
						break;
					}

				} catch (Exception e) {
					System.out.println("�߸� �Է��Ͽ����ϴ�.");
					continue;
				}

			}

//			[���� �˼�]
//			�� �˼�
			for (int row = 0; row < board.size; row++) {
				for (int col = 0; col < board.size - 4; col++) {
					for (int i = 0; i < list.length; i++) {
						list[i] = board.map[row][col + i];
					}

					result = Arrays.toString(list);

					if (result.equals(win1) || result.equals(win2)) {
						System.out.println(player1.name + " �¸�!");
						return;
					}
				}
			}

//			�� �˼�
			for (int col = 0; col < board.size; col++) {
				for (int row = 0; row < board.size - 4; row++) {
					for (int i = 0; i < list.length; i++) {
						list[i] = board.map[row + i][col];
					}

					result = Arrays.toString(list);

					if (result.equals(win1) || result.equals(win2)) {
						System.out.println(player1.name + " �¸�!");
						return;
					}
				}
			}

//			�밢�� �˼� 1
			for (int row = 0; row < board.size - 4; row++) {
				for (int col = 0; col < board.size - 4; col++) {
					for (int i = 0; i < list.length; i++) {
						list[i] = board.map[row + i][col + i];
					}

					result = Arrays.toString(list);

					if (result.equals(win1) || result.equals(win2)) {
						System.out.println(player1.name + " �¸�!");
						return;
					}
				}
			}

//			�밢�� �˼� 2
			for (int row = 0; row < board.size - 4; row++) {
				for (int col = board.size - 1; col >= 4; col--) {
					for (int i = 0; i < list.length; i++) {
						list[i] = board.map[row + i][col - i];
					}

					result = Arrays.toString(list);

					if (result.equals(win1) || result.equals(win2)) {
						System.out.println(player1.name + " �¸�!");
						return;
					}
				}
			}
			count++;
		}
	}
}
