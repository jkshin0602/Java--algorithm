package baekjoon.ready;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main13164 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] q = new int[N];
		for (int i = 0; i < N; i++) {
			q[i] = Integer.parseInt(st.nextToken());
		}

		int[] diff = new int[N - 1];
		for (int i = 0; i < N - 1; i++) {
			diff[i] = q[i + 1] - q[i];
		}

		Arrays.sort(diff);

		int answer = 0;
		for (int i = 0; i < N - K; i++) {
			answer += diff[i];
		}

		System.out.println(answer);
	}
}
