package baekjoon.DFS와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main14502 {

	static int N, M, answer = Integer.MIN_VALUE;
	static int[][] map, arr;
	static boolean[][] visited;
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};

	public static void main(String[] args) throws Exception {
		input();
		go();
		System.out.println(answer);
	}

	private static void go() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 0) {
					map[i][j] = 1;
					dfs(1);
					map[i][j] = 0;
				}
			}
		}
	}

	// 바이러스 퍼트리기
	private static void bfs() {
		int[][] virus = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				virus[i][j] = map[i][j];
			}
		}
		Queue<Pair> q = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (virus[i][j] == 2) {
					q.add(new Pair(i, j));
				}
			}
		}

		while (!q.isEmpty()) {
			Pair poll = q.poll();
			int x = poll.x;
			int y = poll.y;
			for (int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				if (ny < 0 || nx < 0 || ny >= N || nx >= M)
					continue;
				if (virus[ny][nx] == 0) {
					virus[ny][nx] = 2;
					q.add(new Pair(ny, nx));
				}
			}
		}

		count(virus);
	}

	private static void count(int[][] virus) {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (virus[i][j] == 0) {
					cnt++;
				}
			}
		}
		answer = Math.max(cnt, answer);
	}

	private static void dfs(int cnt) {
		if (cnt == 3) {
			bfs();
			return;
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					map[i][j] = 1;
					dfs(cnt + 1);
					map[i][j] = 0;
				}
			}
		}
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		arr = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = map[i][j] = Integer.parseInt(st.nextToken());
			}
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
