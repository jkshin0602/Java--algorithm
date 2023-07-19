package baekjoon.ready;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main1758 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] tip = new int[N];

		//원래 주려고 했던 돈 - (받은 등수 -1) 만큼의 팁을 준다.

		for (int i = 0; i < N; i++) {
			tip[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(tip);

		long answer = 0;
		int rank = 1;
		for (int i = N - 1; i >= 0; i--) {
			int result = tip[i] - (rank - 1);
			answer += Math.max(result, 0);
			rank++;
		}

		System.out.println(answer);
	}
}
