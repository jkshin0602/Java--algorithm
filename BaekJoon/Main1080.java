package baekjoon.그리디;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main1080 {

	static int[][] A, B;
	static int N, M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		A = new int[N][M];
		B = new int[N][M];

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				A[i][j] = s.charAt(j) + '0';
			}
		}
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				B[i][j] = s.charAt(j) + '0';
			}
		}

		System.out.println(get());

	}

	static int get() {
		int ans = 0;

		if (check())
			return 0;
		if (N < 3 || M < 3)
			return -1;

		for (int i = 0; i < N - 2; i++) {
			for (int j = 0; j < M - 2; j++) {
				if (A[i][j] != B[i][j]) {
					go(j, i);
					ans++;
				}
				if (check()) {
					return ans;
				}
			}
		}
		return -1;
	}

	static void go(int x, int y) {
		for (int i = y; i < y + 3; i++) {
			for (int j = x; j < x + 3; j++) {
				A[i][j] ^= 1;
			}
		}
	}

	static boolean check() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (A[i][j] != B[i][j])
					return false;
			}
		}
		return true;
	}
}
