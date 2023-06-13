package book.nadongbin.문제.BFS_DFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 감시_피하기 {

	private static int[] dy = {-1, 0, 1, 0};
	private static int[] dx = {0, 1, 0, -1};
	private static List<Pair> student = new ArrayList<>();

	public static void solution(char[][] map) {

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				if (map[i][j] == 'S') {
					student.add(new Pair(i, j));
				}
			}
		}

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				if (map[i][j] == 'X') {
					map[i][j] = 'O';
					dfs(map, 1);
					map[i][j] = 'X';
				}
			}
		}

		System.out.println("NO");

	}

	private static void dfs(char[][] map, int cnt) {
		if (cnt == 3) {
			bfs(map);
			return;
		}
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				if (map[i][j] == 'X') {
					map[i][j] = 'O';
					dfs(map, cnt + 1);
					map[i][j] = 'X';
				}
			}
		}
	}

	private static void bfs(char[][] map) {
		Queue<Pair> q = new LinkedList<>();
		boolean[][] visited = new boolean[map.length][map.length];

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				if (map[i][j] == 'T') {
					q.add(new Pair(i, j));
					visited[i][j] = true;
				}
			}
		}

		while (!q.isEmpty()) {
			Pair p = q.poll();

			for (int i = 0; i < 4; i++) {
				int ny = p.y + dy[i];
				int nx = p.x + dx[i];

				while (0 <= ny && ny < map.length && 0 <= nx && nx < map.length) {
					if (map[ny][nx] != 'O') {
						visited[ny][nx] = true;
						ny += dy[i];
						nx += dx[i];
					} else {
						break;
					}
				}
			}
		}

		if (check(visited)) {
			System.out.println("YES");
			System.exit(0);
		}
	}

	private static boolean check(boolean[][] visited) {
		for (Pair s : student) {
			if (visited[s.y][s.x]) {
				return false;
			}
		}

		return true;
	}

	private static class Pair {
		int y, x;

		public Pair(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	public static void main(String[] args) {
		solution(new char[][] {{'X', 'S', 'X', 'X', 'T'}, {'T', 'X', 'S', 'X', 'X'}, {'X', 'X', 'X', 'X', 'X'},
			{'X', 'T', 'X', 'X', 'X'}, {'X', 'X', 'T', 'X', 'X'}});

		solution(new char[][] {{'S', 'S', 'S', 'T'}, {'X', 'X', 'X', 'X'}, {'X', 'X', 'X', 'X'}, {'T', 'T', 'T', 'X'}});

	}
}
