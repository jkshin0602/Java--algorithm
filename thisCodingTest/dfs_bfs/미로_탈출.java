package book.nadongbin.dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;

public class 미로_탈출 {

	private static int[] dy = {-1, 0, 1, 0};
	private static int[] dx = {0, 1, 0, -1};

	public static int solution(int N, int M, int[][] map) {
		int[][] visited = new int[N][M];
		bfs(map, visited);
		return visited[N - 1][M - 1];
	}

	private static void bfs(int[][] map, int[][] visited) {
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(0, 0));
		visited[0][0] = 1;

		while (!q.isEmpty()) {
			Pair p = q.poll();
			for (int i = 0; i < 4; i++) {
				int ny = p.y + dy[i];
				int nx = p.x + dx[i];
				if (isNotMap(ny, nx, map) || visited[ny][nx] > 0) {
					continue;
				}
				q.add(new Pair(ny, nx));
				visited[ny][nx] = visited[p.y][p.x] + 1;
			}
		}
	}

	private static boolean isNotMap(int y, int x, int[][] map) {
		return y < 0 || x < 0 || y >= map.length || x >= map[0].length || map[y][x] == 0;
	}

	private static class Pair {
		int y, x;

		public Pair(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	public static void main(String[] args) {
		System.out.println(solution(5, 6,
			new int[][] {{1, 0, 1, 0, 1, 0}, {1, 1, 1, 1, 1, 1}, {0, 0, 0, 0, 0, 1}, {1, 1, 1, 1, 1, 1},
				{1, 1, 1, 1, 1, 1}}));
	}
}
