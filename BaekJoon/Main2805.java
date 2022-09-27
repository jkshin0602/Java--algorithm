package baekjoon.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main2805 {

	static int N, M;
	static int[] h;



	private static boolean determination(int H) {
		long sum = 0;
		for (int i = 1; i <= N; i++) {
			if (h[i] > H) {
				sum += h[i] - H;
			}
		}
		return sum >= M;
	}

	private static void go() {
		long L = 0, R = 2_000_000_000, ans = 0;

		while (L <= R) {
			long mid = (L + R) / 2;
			if (determination((int)mid)) {
				ans = mid;
				L = mid + 1;
			} else {
				R = mid - 1;
			}
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
		M = Integer.parseInt(st.nextToken());
		h = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			h[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(h);
	}
}



