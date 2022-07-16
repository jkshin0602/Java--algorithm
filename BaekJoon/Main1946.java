package baekjoon.그리디;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1946 {

	static int N;
	static int[] rank;

	static void go() {
		int ans = 1;
		int min = rank[1];
		for (int i = 2; i <= N; i++) {
			if (rank[i] < min) {
				ans++;
				min = rank[i];
			}
		}
		System.out.println(ans);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		while (T-- > 0) {
			N = Integer.parseInt(br.readLine());
			rank = new int[N + 1];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				rank[x] = Integer.parseInt(st.nextToken());
			}
			go();
		}
	}

}
