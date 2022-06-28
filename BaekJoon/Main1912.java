package baekjoon.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1912 {

	static int N;
	static int[] A;
	static int[] D;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		A = new int[N + 1];
		D = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		int max = D[1] = A[1];
		for (int i = 2; i <= N; i++) {
			D[i] = Math.max(D[i - 1] + A[i], A[i]);
			max = Math.max(D[i], max);
		}
		System.out.println(max);

	}

	//D[N] = N개의 정수로 이루어진 임의의 수열 중 연속된 수 중 가장 큰 합
	//D[N-1] =

}
