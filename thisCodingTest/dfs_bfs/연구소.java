package book.nadongbin.문제.BFS_DFS;

import java.util.LinkedList;
import java.util.Queue;

public class 연구소 {

	private static int[] dy = {-1, 0, 1, 0};
	private static int[] dx = {0, 1, 0, -1};
	private static int ans;

	//0 : 빈칸, 1 : 벽, 2: 바이러스
	public static int solution(int N, int M, int[][] map) {
		ans = 0;

		int[][] arr = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = map[i][j];
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					arr[i][j] = 1;
					dfs(1, arr);
					arr[i][j] = 0;
				}
			}
		}

		return ans;
	}

	private static void dfs(int cnt, int[][] arr) {
		if (cnt == 3) {
			bfs(arr);
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i][j] == 0) {
					arr[i][j] = 1;
					dfs(cnt + 1, arr);
					arr[i][j] = 0;
				}
			}
		}
	}

	private static void bfs(int[][] arr) {
		int[][] virus = new int[arr.length][arr[0].length];
		boolean[][] visited = new boolean[arr.length][arr[0].length];

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				virus[i][j] = arr[i][j];
			}
		}

		Queue<Pair> q = new LinkedList<>();

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (virus[i][j] == 2) {
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

				if (isNotMap(arr, visited, ny, nx)) {
					continue;
				}

				if (virus[ny][nx] == 0) {
					virus[ny][nx] = 2;
					q.add(new Pair(ny, nx));
					visited[ny][nx] = true;
				}
			}
		}

		ans = Math.max(ans, count(virus));
	}

	private static int count(int[][] virus) {
		int cnt = 0;

		for (int i = 0; i < virus.length; i++) {
			for (int j = 0; j < virus[0].length; j++) {
				if (virus[i][j] == 0) {
					cnt++;
				}
			}
		}

		return cnt;
	}

	private static boolean isNotMap(int[][] arr, boolean[][] visited, int ny, int nx) {
		return ny < 0 || nx < 0 || ny >= arr.length || nx >= arr[0].length || visited[ny][nx];
	}

	private static class Pair {

		int y, x;

		public Pair(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	public static void main(String[] args) {
		System.out.println(solution(7, 7, new int[][] {
			{2, 0, 0, 0, 1, 1, 0},
			{0, 0, 1, 0, 1, 2, 0},
			{0, 1, 1, 0, 1, 0, 0},
			{0, 1, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 1, 1},
			{0, 1, 0, 0, 0, 0, 0},
			{0, 1, 0, 0, 0, 0, 0},
		}));
	}

}
