package baekjoon.DFS와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main3055 {

	static int R, C;
	static char[][] map;
	static int[][] cnt, water;
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		input();
		go();
	}

	private static void go() {
		waterBfs();
		bfs();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 'D') {
					if (cnt[i][j] == -1)
						System.out.println("KAKTUS");
					else
						System.out.println(cnt[i][j]);
				}
			}
		}
	}

	private static void waterBfs() {
		Queue<Pair> q = new LinkedList<>();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				water[i][j] = -1;
				visited[i][j] = false;
				if (map[i][j] == '*') {
					q.add(new Pair(i, j));
					water[i][j] = 0;
					visited[i][j] = true;
				}
			}
		}

		while (!q.isEmpty()) {
			Pair p = q.poll();
			for (int i = 0; i < 4; i++) {
				int ny = p.y + dy[i];
				int nx = p.x + dx[i];
				if (isMap(ny, nx))
					continue;
				if (map[ny][nx] != '.')
					continue;
				if (visited[ny][nx])
					continue;
				q.add(new Pair(ny, nx));
				visited[ny][nx] = true;
				water[ny][nx] = water[p.y][p.x] + 1;
			}
		}
	}

	private static void bfs() {
		Queue<Pair> q = new LinkedList<>();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				cnt[i][j] = -1;
				visited[i][j] = false;
				if (map[i][j] == 'S') {
					q.add(new Pair(i, j));
					visited[i][j] = true;
					cnt[i][j] = 0;
				}
			}
		}

		while (!q.isEmpty()) {
			Pair p = q.poll();
			for (int i = 0; i < 4; i++) {
				int ny = p.y + dy[i];
				int nx = p.x + dx[i];
				if (isMap(ny, nx))
					continue;
				if (map[ny][nx] != '.' && map[ny][nx] != 'D')
					continue;
				if (water[ny][nx] != -1 && water[ny][nx] <= cnt[p.y][p.x] + 1)
					continue;
				if (visited[ny][nx])
					continue;
				q.add(new Pair(ny, nx));
				visited[ny][nx] = true;
				cnt[ny][nx] = cnt[p.y][p.x] + 1;
			}
		}
	}

	private static boolean isMap(int ny, int nx) {
		return ny < 0 || ny >= R || nx < 0 || nx >= C;
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		cnt = new int[R][C];
		water = new int[R][C];
		visited = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = s.charAt(j);
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
