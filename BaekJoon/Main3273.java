package baekjoon.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main3273 {

	static int N, X, ans;
	static int[] a;

	public static void main(String[] args) throws Exception {
		input();
		go();
		System.out.println(ans);
	}

	private static void go() {
		int L = 0, R = N - 1;
		while (L < R) {
			if (a[L] + a[R] == X) {
				ans++;
				L++;
				R--;
			} else if (a[L] + a[R] > X) {
				R--;
			} else if (a[L] + a[R] < X) {
				L++;
			}
		}
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		a = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		X = Integer.parseInt(br.readLine());
		Arrays.sort(a);
	}
}
