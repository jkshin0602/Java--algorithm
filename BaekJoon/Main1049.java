package baekjoon.그리디;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main1049 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] a1 = new int[M];
		int[] a2 = new int[M];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			a1[i] = Integer.parseInt(st.nextToken());
			a2[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(a1);
		Arrays.sort(a2);

		int ans = -1;

		ans = Math.min(((N / 6) + 1) * a1[0], Math.min((N * a2[0]), ((N / 6)) * a1[0] + (N % 6) * a2[0]));
		System.out.println(ans);

	}
}



