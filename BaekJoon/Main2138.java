package baekjoon.ready;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main2138 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		boolean[] current1 = new boolean[N];
		boolean[] current2 = new boolean[N];
		boolean[] expect = new boolean[N];

		String s = br.readLine();
		for (int i = 0; i < N; i++) {
			if (s.charAt(i) == '1') {
				current1[i] = current2[i] = true;
			}
		}

		s = br.readLine();
		for (int i = 0; i < N; i++) {
			if (s.charAt(i) == '1') {
				expect[i] = true;
			}
		}

		//첫번째 전구를 키는 경우 current1
		current1[0] = !current1[0];
		current1[1] = !current1[1];

		int ans1 = 1;
		int ans2 = 0;

		for (int i = 1; i < N; i++) {
			if (current1[i - 1] != expect[i - 1]) { //i-1이 기대값과 다르다면 킨다.
				current1[i - 1] = !current1[i - 1];
				current1[i] = !current1[i];
				if (i < N - 1) {
					current1[i + 1] = !current1[i + 1];
				}
				ans1++;
			}

			if (current2[i - 1] != expect[i - 1]) {
				current2[i - 1] = !current2[i - 1];
				current2[i] = !current2[i];
				if (i < N - 1) {
					current2[i + 1] = !current2[i + 1];
				}
				ans2++;
			}
		}

		if (current1[N - 1] != expect[N - 1]) {
			ans1 = Integer.MAX_VALUE;
		}
		if (current2[N - 1] != expect[N - 1]) {
			ans2 = Integer.MAX_VALUE;
		}

		int min = Math.min(ans1, ans2);
		System.out.println(min == Integer.MAX_VALUE ? -1 : min);
	}

}
