package baekjoon.DFS와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//단지 번호 붙이기
// https://www.acmicpc.net/problem/2667
public class Main2667 {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static int N, cnt;
	private static List<Integer> ans = new ArrayList<>();
	private static int[] dy = {-1, 0, 1, 0};
	private static int[] dx = {0, 1, 0, -1};
	private static int[][] map;
	private static boolean[][] visited;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		input();
		go();
		print();
	}

	private static void print() {
		Collections.sort(ans);
		sb.append(ans.size()).append('\n');
		for (Integer a : ans) {
			sb.append(a).append('\n');
		}
		System.out.println(sb);
	}

	private static void go() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 0 || visited[i][j])
					continue;
				cnt = 0;
				DFS(i, j);
				ans.add(cnt);
			}
		}
	}

	private static void input() throws IOException {
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < s.length(); j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
	}

	private static int DFS(int y, int x) {
		visited[y][x] = true;
		cnt++;
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if (isMap(ny, nx) || visited[ny][nx] || map[ny][nx] == 0)
				continue;
			visited[ny][nx] = true;
			DFS(ny, nx);
		}
		return cnt;
	}

	private static boolean isMap(int ny, int nx) {
		return ny >= N || nx >= N || ny < 0 || nx < 0;
	}
}
