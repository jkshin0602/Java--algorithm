package baekjoon.그리디;

import java.util.*;
import java.io.*;

class Main13305 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] d = new int[N];
		int[] p = new int[N + 1];
		for (int i = 1; i < N; i++) {
			d[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			p[i] = Integer.parseInt(st.nextToken());
		}

		long ans = 0;
		int min = Integer.MAX_VALUE;
		for (int i = 1; i < N; i++) {
			min = Math.min(min, p[i]);
			ans += (long)min * d[i];
		}

		System.out.println(ans);

	}
}



