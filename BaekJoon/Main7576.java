package baekjoon.DFS와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main7576 {

	static int M, N, ans = Integer.MAX_VALUE;
	static int[][] map, visited;
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	static Queue<Pair> q = new LinkedList<>();

	public static void main(String[] args) throws Exception {
		input();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) {
					q.add(new Pair(i, j));
					visited[i][j]++;
				}
			}
		}
		ans = BFS();
		System.out.println(ans);
	}

	private static int BFS() {
		int max = 0;
		while (!q.isEmpty()) {
			Pair p = q.poll();
			for (int i = 0; i < 4; i++) {
				int ny = dy[i] + p.y;
				int nx = dx[i] + p.x;
				if (isMap(ny, nx))
					continue;
				q.add(new Pair(ny, nx));
				visited[ny][nx] = visited[p.y][p.x] + 1;
				max = Math.max(max, visited[ny][nx]);
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0 && visited[i][j] == -1)
					return -1;

			}
		}
		return max;
	}

	private static boolean isMap(int py, int px) {
		return py < 0 || px < 0 || py >= N || px >= M || map[py][px] != 0 || visited[py][px] > -1;
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		bool();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	private static void bool() {
		visited = new int[N][M];
		for (int i = 0; i < N; i++) {
			Arrays.fill(visited[i], -1);
		}
	}

	static class Pair {
		int y, x;

		public Pair(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

}
