package book.nadongbin.dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;

public class 음료수_얼려_먹기 {

	private static int[] dy = {-1, 0, 1, 0};
	private static int[] dx = {0, 1, 0, -1};

	public static int solution(int[][] map) {
		int ans = 0;
		boolean[][] visited = new boolean[map.length][map[0].length];

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if (map[i][j] == 0 && !visited[i][j]) {
					bfs(new Pair(i, j), visited, map);
					ans++;
				}
			}
		}

		return ans;
	}

	private static void bfs(Pair start, boolean[][] visited, int[][] map) {
		Queue<Pair> q = new LinkedList<>();
		q.add(start);
		visited[start.y][start.x] = true;

		while (!q.isEmpty()) {
			Pair p = q.poll();
			for (int i = 0; i < 4; i++) {
				int ny = p.y + dy[i];
				int nx = p.x + dx[i];
				if (isNotMap(ny, nx, map) || visited[ny][nx]) {
					continue;
				}
				q.add(new Pair(ny, nx));
				visited[ny][nx] = true;
			}
		}
	}

	private static boolean isNotMap(int y, int x, int[][] map) {
		return y < 0 || x < 0 || y >= map.length || x >= map[0].length || map[y][x] == 1;
	}

	private static class Pair {
		int y, x;

		public Pair(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	public static void main(String[] args) {
		System.out.println(solution(new int[][] {{0, 0, 1, 1, 0}, {0, 0, 0, 1, 1}, {1, 1, 1, 1, 1}, {0, 0, 0, 0, 0}}));
	}
}
