package baekjoon.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main1654 {

	static int K, N;
	static int[] lan;
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws Exception {
		input();
		go();
	}

	private static void go() {
		long L = 1;
		long R = max;

		while (L <= R) { // upper-bound : 조건에맞는 최대값 찾기, lower-bound : 조건에 맞는 최소값 찾기
			long mid = (L + R) / 2;
			long sum = 0;
			for (int value : lan) {
				sum += value / mid;
			}
			if (sum >= N) {
				L = mid + 1;
			} else {
				R = mid - 1;
			}
		}
		System.out.println(L - 1);
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		lan = new int[K + 1];
		for (int i = 1; i <= K; i++) {
			lan[i] = Integer.parseInt(br.readLine());
			max = Math.max(lan[i], max);
		}
	}
}
