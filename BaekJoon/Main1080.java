package baekjoon.ready;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main1080 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][M];
		int[][] object = new int[N][M];

		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = input.charAt(j) - '0';
			}
		}

		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < M; j++) {
				object[i][j] = input.charAt(j) - '0';
			}
		}

		int answer = go(N, M, map, object);
		System.out.println(answer);
	}

	private static int go(int N, int M, int[][] map, int[][] object) {
		int ans = 0;

		if (check(map, object)) {
			return 0;
		}

		if (N < 3 || M < 3) {
			return -1;
		}

		for (int i = 0; i < N - 2; i++) {
			for (int j = 0; j < M - 2; j++) {
				if (map[i][j] != object[i][j]) {
					reverse(j, i, map);
					ans++;
				}
				if (check(map, object)) {
					return ans;
				}
			}
		}

		return -1;
	}

	private static void reverse(int x, int y, int[][] map) {
		for (int i = y; i < y + 3; i++) {
			for (int j = x; j < x + 3; j++) {
				map[i][j] ^= 1;
			}
		}
	}

	private static boolean check(int[][] map, int[][] object) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if (map[i][j] != object[i][j]) {
					return false;
				}
			}
		}

		return true;
	}
}
