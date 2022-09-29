package baekjoon.투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main2470V2 {

	static int N;
	static int[] A;
	static StringBuilder sb = new StringBuilder();

	private static void go() {
		int best_sum = Integer.MAX_VALUE;
		int v1 = 0, v2 = 0, L = 1, R = N;

		while (L < R) {
			int sum = A[L] + A[R];
			if (Math.abs(sum) < best_sum) {
				best_sum = Math.abs(sum);
				v1 = A[L];
				v2 = A[R];
			}

			if (sum > 0) {
				R--;
			} else {
				L++;
			}
		}
		sb.append(v1).append(' ').append(v2);
		System.out.println(sb);
	}

	public static void main(String[] args) throws Exception {
		input();
		go();
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
		Arrays.sort(A, 1, N + 1);
	}

}
