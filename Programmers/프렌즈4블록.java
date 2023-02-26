package programmers;

import java.util.ArrayList;
import java.util.List;

public class 프렌즈4블록 {

	//같은 블록은 여러 2x2에 포함 가능
	//지워지는 조건에 만족하는 2x2 모양이 여러 개 있다면 한번에 지워짐
	//지워진 후에 위에 있는 블록이 아래로 떨어져 빈 공간을 채움

	public static int solution(int m, int n, String[] board) {

		char[][] map = init(m, n, board);

		while (true) {
			boolean[][] check = new boolean[m][n];
			findRemovableBlock(m, n, map, check);

			List<Character>[] list = new ArrayList[n];
			for (int i = 0; i < n; i++) {
				list[i] = new ArrayList<>();
			}

			downBlockCheck(m, n, map, check, list);

			if (isContinue(check)) {
				break;
			}

			map = blockDown(m, n, list);
		}

		int ans = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (isAlpha(map, i, j)) {
					ans++;
				}
			}
		}

		return m * n - ans;
	}

	private static char[][] blockDown(int m, int n, List<Character>[] list) {
		char[][] map = new char[m][n];
		for (int i = 0; i < n; i++) {
			for (int j = m - 1; j >= 0; j--) {
				if (!list[i].isEmpty()) {
					map[j][i] = list[i].get(0);
					list[i].remove(0);
				}
			}
		}
		return map;
	}

	private static void downBlockCheck(int m, int n, char[][] map, boolean[][] check, List<Character>[] list) {
		for (int i = 0; i < n; i++) {
			for (int j = m - 1; j >= 0; j--) {
				if (!check[j][i]) {
					list[i].add(map[j][i]);
				}
			}
		}
	}

	private static void findRemovableBlock(int m, int n, char[][] map, boolean[][] check) {
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i + 1 >= m || j + 1 >= n) {
					continue;
				}
				if (isAlpha(map, i, j) && isBlock(map, i, j)) {
					aroundBlockCheck(i, j, map, check);
					aroundBlockCheck(i + 1, j, map, check);
					aroundBlockCheck(i, j + 1, map, check);
					aroundBlockCheck(i + 1, j + 1, map, check);
				}
			}
		}
	}

	private static boolean isContinue(boolean[][] check) {
		for (int i = 0; i < check.length; i++) {
			for (int j = 0; j < check[i].length; j++) {
				if (check[i][j]) {
					return false;
				}
			}
		}

		return true;
	}

	private static void aroundBlockCheck(int y, int x, char[][] map, boolean[][] check) {
		if (y + 1 >= map.length || x + 1 >= map[0].length) {
			return;
		}
		if (isBlock(map, y, x)) {
			check[y][x] = true;
			check[y + 1][x] = true;
			check[y][x + 1] = true;
			check[y + 1][x + 1] = true;
		}
	}

	private static boolean isAlpha(char[][] map, int y, int x) {
		return map[y][x] >= 'A' && map[y][x] <= 'Z';
	}

	private static boolean isBlock(char[][] map, int y, int x) {
		return map[y][x] == map[y + 1][x] &&
			map[y][x] == map[y][x + 1] &&
			map[y][x] == map[y + 1][x + 1];
	}

	private static char[][] init(int m, int n, String[] board) {
		char[][] map = new char[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = board[i].charAt(j);
			}
		}

		return map;
	}

	public static void main(String[] args) {
		System.out.println(solution(4, 5, new String[] {"CCBDE", "AAADE", "AAABF", "CCBBF"}));
		System.out.println(solution(6, 6, new String[] {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"}));
	}
}
