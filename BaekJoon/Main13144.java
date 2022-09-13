package baekjoon.투포인터;

import java.util.*;
import java.io.*;

class Main13144 {

	static int N;
	static int[] A, C;

	public static void main(String[] args) throws Exception {
		input();
		go();

	}

	private static void go() {
		long ans = 0;
		for (int L = 1, R = 0; L <= N; L++) {

			while (R + 1 <= N && C[A[R + 1]] == 0) {
				R++;
				C[A[R]]++;
			}
			ans += R - L + 1;

			C[A[L]]--;
		}
		System.out.println(ans);
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		A = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		C = new int[100_000 + 1];
	}
}
