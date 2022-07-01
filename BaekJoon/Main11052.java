package baekjoon.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main11052 {

	static int N;
	static int[] P, D;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		P = new int[N + 1];
		D = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			P[i] = Integer.parseInt(st.nextToken());
		}
		go();
		System.out.println(D[N]);
	}

	//D[N] = 카드 N개를 구매하는 비용의 최대값
	//D[N] = max(D[N-i] + P[i])
	// 1 <=i <=N
	// N x O(N) = O(N^2)

	static void go() {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= i; j++) {
				D[i] = Math.max(D[i], D[i - j] + P[j]);
			}
		}
	}

}
