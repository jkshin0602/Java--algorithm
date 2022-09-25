package baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main11057 {

	static int N;
	static int[][] D;

	public static void main(String[] args) throws Exception {
		input();
		go();
	}

	// D[i][last] : 길이가 i이며 last로 끝나는 오르막 수의 개수
	// D[i][j] = D[i-1][0] ... D[i-1][j]
	private static void go() {
		init();
		for (int i = 2; i <= N; i++) {
			for (int j = 0; j <= 9; j++) {
				for (int k = 0; k <= j; k++) {
					D[i][j] += D[i - 1][k];
					D[i][j] %= 10007;
				}
			}
		}
		int ans = 0;
		for (int i = 0; i <= 9; i++) {
			ans += D[N][i];
			ans %= 10007;
		}

		System.out.println(ans);
	}

	private static void init() {
		for (int i = 0; i < 10; i++) {
			D[1][i] = 1;
		}
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		D = new int[N + 1][10];
	}
}
