package baekjoon.ready;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main20115 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] x = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			x[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(x);

		double answer = x[N - 1];
		for (int i = N - 2; i >= 0; i--) {
			double result = (double)x[i] / 2;
			answer += result;
		}

		System.out.printf("%.1f", answer);
	}
}
