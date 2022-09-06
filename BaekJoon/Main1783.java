package baekjoon.그리디;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main1783 {

	static int N, M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		if (N == 1) {
			System.out.println(1);
		} else if (N == 2) {
			System.out.println(Math.min(4, (M + 1) / 2));
		} else {
			int[] ans = {-1, 1, 2, 3, 4, 4, 4, 5, 6};
			if (M <= 8) {
				System.out.println(ans[M]);
			} else {
				System.out.println(M - 2);
			}
		}

	}
}
