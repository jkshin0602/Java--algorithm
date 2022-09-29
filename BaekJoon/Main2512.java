package baekjoon.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main2512 {

	static int N, M;
	static int[] A, tmp;

	public static void main(String[] args) throws Exception {
		input();
		go();
	}

	private static void go() {
		int L = 0, R = 0, ans = 0;
		for (int i = 1; i <= N; i++)
			R = Math.max(R, A[i]);
		while (L <= R) {
			int mid = (L + R) / 2;
			if (determination(mid)) {
				ans = mid;
				L = mid + 1;
			} else {
				R = mid - 1;
			}
		}
		System.out.println(ans);
	}

	private static boolean determination(int mid) {
		int sum = 0;
		for (int i = 1; i <= N; i++) {
			sum += Math.min(mid, A[i]);
		}
		return sum <= M;
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		A = new int[N + 1];
		tmp = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		M = Integer.parseInt(br.readLine());
	}
}
