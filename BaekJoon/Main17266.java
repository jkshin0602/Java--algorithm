package baekjoon.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main17266 {

	static int N, M;
	static int[] A;

	public static void main(String[] args) throws Exception {
		input();
		go();
	}

	private static void go() {
		int L = 0, R = N, ans = N;
		while (L <= R) {
			int mid = (L + R) / 2;
			if (determination(mid)) {
				ans = mid;
				R = mid - 1;
			} else {
				L = mid + 1;
			}
		}
		System.out.println(ans);
	}

	private static boolean determination(int h) {
		int last = 0;
		for (int i = 1; i <= M; i++) {
			if (A[i] - last <= h) {
				last = h + A[i];
			} else {
				return false;
			}

		}
		return last >= N;
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		A = new int[M + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= M; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
	}
}
