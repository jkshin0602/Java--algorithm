package baekjoon.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main2343 {

	static int N, M;
	static int[] A, tmp;

	public static void main(String[] args) throws Exception {
		input();
		go();
	}

	private static void go() {
		int L = A[1], R = 1_000_000_000, ans = 0;
		for (int i = 1; i <= N; i++)
			L = Math.max(L, A[i]);

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

	private static boolean determination(int mid) {
		int cnt = 1, sum = 0;
		for (int i = 1; i <= N; i++) {
			if (sum + A[i] > mid) {
				cnt++;
				sum = A[i];
			} else {
				sum += A[i];
			}
		}
		return cnt <= M;
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		A = new int[N + 1];
		tmp = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
			tmp[i] = tmp[i - 1] + A[i];
		}
	}
}
