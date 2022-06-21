package baekjoon.DFS와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1012 {

	static int T, M, N, K;
	static int[][] map;
	static boolean[][] visited;
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	static Queue<Pair> q = new LinkedList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			input(br);
			int ans = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 1 && !visited[i][j]) {
						BFS(i, j);
						ans++;
					}
				}
			}
			System.out.println(ans);
		}
	}

	private static void BFS(int y, int x) {
		q.add(new Pair(y, x));
		visited[y][x] = true;
		while (!q.isEmpty()) {
			Pair p = q.poll();
			for (int i = 0; i < 4; i++) {
				int ny = p.y + dy[i];
				int nx = p.x + dx[i];
				if (isMap(ny, nx))
					continue;
				q.add(new Pair(ny, nx));
				visited[ny][nx] = true;
			}
		}

	}

	private static void DFS(int y, int x) {
		visited[y][x] = true;
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if (isMap(ny, nx))
				continue;
			DFS(ny, nx);
		}
	}

	private static boolean isMap(int ny, int nx) {
		return ny < 0 || nx < 0 || ny >= N || nx >= M || visited[ny][nx] || map[ny][nx] == 0;
	}

	private static void input(BufferedReader br) throws IOException {
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[y][x] = 1;
		}
	}

	private static class Pair {
		int y, x;

		public Pair(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}
