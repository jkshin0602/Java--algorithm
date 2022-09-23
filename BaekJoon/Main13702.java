package baekjoon.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main13702 {

	static int N, K;
	static int[] A;

	public static void main(String[] args) throws Exception {
		input();
		go();
	}

	private static void go() {
		long L = 1, R = -1, ans = 0;
		for (int i = 1; i <= N; i++) {
			R = Math.max(R, A[i]);
		}
		while (L <= R) {
			long mid = (L + R) / 2;
			if (determination(mid)) {
				ans = mid;
				L = mid + 1;
			} else {
				R = mid - 1;
			}
		}
		System.out.println(ans);
	}

	private static boolean determination(long mid) {
		long sum = 0;
		for (int i = 1; i <= N; i++) {
			sum += A[i] / mid;
		}
		return sum >= K;
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		A = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			A[i] = Integer.parseInt(br.readLine());
		}
	}
}
