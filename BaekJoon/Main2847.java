package baekjoon.그리디;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main2847 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] score = new int[N];
		for (int i = 0; i < N; i++) {
			score[i] = Integer.parseInt(br.readLine());
		}
		if (score.length == 1) {
			System.out.println(0);
			return;
		}
		int ans = 0;
		for (int i = N - 1; i > 0; i--) {
			if (score[i - 1] >= score[i]) {
				ans += score[i - 1] - (score[i] - 1);
				score[i - 1] = score[i] - 1;
			}
		}

		System.out.println(ans);
	}
}
