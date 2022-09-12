package baekjoon.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main2110 {

	static int N, C;
	static int[] A;

	private static boolean determination(int D) {
		int cnt = 1, last = A[1];
		for (int i = 2; i <= N; i++) {
			if (A[i] - last >= D) {
				cnt++;
				last = A[i];
			}
		}
		return cnt >= C;
	}

	private static void go() {
		int L = 1, R = 1_000_000_000, ans = 0;
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

	public static void main(String[] args) throws Exception {
		input();
		go();
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		A = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			A[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(A);
	}
}
