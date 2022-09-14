package baekjoon.투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main1253 {

	static int N;
	static int[] A;

	public static void main(String[] args) throws Exception {
		input();
		go();
	}

	private static boolean check(int target_idx) {
		int L = 1, R = N;
		int target = A[target_idx];
		while (L < R) {
			if (L == target_idx)
				L++;
			else if (R == target_idx)
				R--;
			else {
				if (A[L] + A[R] > target)
					R--;
				else if (A[L] + A[R] == target)
					return true;
				else
					L++;
			}
		}
		return false;
	}

	private static void go() {
		int ans = 0;
		for (int i = 1; i <= N; i++) {
			if (check(i))
				ans++;
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
		Arrays.sort(A, 1, N + 1);
	}
}
