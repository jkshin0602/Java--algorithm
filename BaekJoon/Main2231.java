package baekjoon.ready;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main2231 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int min = Integer.MAX_VALUE;
		for (int i = 1; i < N; i++) {
			String m = String.valueOf(i);
			int sum = Integer.parseInt(m);

			for (int j = 0; j < m.length(); j++) {
				sum += m.charAt(j) - '0';
			}

			if (sum == N) {
				min = Math.min(Integer.parseInt(m), min);
			}
		}

		System.out.println(min != Integer.MAX_VALUE ? min : 0);
	}
}
