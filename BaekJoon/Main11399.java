package baekjoon.ready;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main11399 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] P = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			P[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(P);

		int answer = P[0];

		for (int i = 1; i < N; i++) {
			P[i] = P[i - 1] + P[i];
			answer += P[i];
		}

		System.out.println(answer);
	}
}
