package baekjoon.DFS와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main7569 {

	static int M, N, H;
	static int[][][] map, isVisited;
	static Queue<Point> q = new LinkedList<>();
	static int[] dz = {-1, 0, 0, 0, 0, 1};
	static int[] dy = {0, -1, 0, 1, 0, 0};
	static int[] dx = {0, 0, 1, 0, -1, 0};

	public static void main(String[] args) throws Exception {
		input();
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if (map[i][j][k] == 1) {
						q.add(new Point(i, j, k));
						isVisited[i][j][k]++;
					}
				}
			}
		}
		System.out.println(BFS());
	}

	private static int BFS() {
		int max = 0;
		while (!q.isEmpty()) {
			Point p = q.poll();
			for (int i = 0; i < 6; i++) {
				int nz = p.z + dz[i];
				int ny = p.y + dy[i];
				int nx = p.x + dx[i];
				if (isMap(nz, ny, nx))
					continue;
				q.add(new Point(nz, ny, nx));
				isVisited[nz][ny][nx] = isVisited[p.z][p.y][p.x] + 1;
				max = Math.max(max, isVisited[nz][ny][nx]);
			}
		}
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if (map[i][j][k] == 0 && isVisited[i][j][k] == -1) {
						return -1;
					}
				}
			}
		}
		return max;
	}

	private static boolean isMap(int nz, int ny, int nx) {
		return nz < 0 || nz >= H || ny < 0 || ny >= N || nx < 0 || nx >= M || map[nz][ny][nx] != 0
			|| isVisited[nz][ny][nx] > -1;
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H][N][M];
		isVisited = new int[H][N][M];
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					isVisited[i][j][k] = -1;
				}
			}
		}
		for (int i = H - 1; i >= 0; i--) {
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < M; k++) {
					map[i][j][k] = Integer.parseInt(st.nextToken());
				}
			}
		}
	}

	private static class Point {
		int z, y, x;

		public Point(int z, int y, int x) {
			this.z = z;
			this.y = y;
			this.x = x;
		}
	}
}
