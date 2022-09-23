package baekjoon.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main1300 {

	static int N, K;

	public static void main(String[] args) throws Exception {
		input();
		go();
	}

	private static void go() {
		long L = 1, R = (long)N * N, ans = 0;
		while (L <= R) {
			long mid = (L + R) / 2;
			if (determination(mid)) {
				ans = mid;
				R = mid - 1;
			} else {
				L = mid + 1;
			}
		}
		System.out.println(ans);
	}

	private static boolean determination(long mid) {
		long cnt = 0;
		for (int i = 1; i <= N; i++) {
			cnt += Math.min(N, mid / i);
		}

		return cnt >= K;
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
	}
}

