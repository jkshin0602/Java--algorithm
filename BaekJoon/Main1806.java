package baekjoon.투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main1806 {

	static int S, N;
	static int[] A;

	private static void go() {
		int R = 0, sum = 0, ans = N + 1;
		for (int L = 1; L <= N; L++) {
			sum -= A[L - 1];

			while (R + 1 <= N && sum < S) {
				R++;
				sum += A[R];
			}

			if (sum >= S) {
				ans = Math.min(ans, R - L + 1);
			}
		}
		if (ans == N + 1) {
			ans = 0;
		}
		System.out.println(ans);
	}

	public static void main(String[] args) throws Exception {
		input();
		go();
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		A = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
	}
}



