package baekjoon.ready;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main20300 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] t = new long[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			t[i] = Long.parseLong(st.nextToken());
		}

		Arrays.sort(t);

		long answer= 0;

		if (N % 2 == 0) {
			for (int i = 0; i < N / 2; i++) {
				answer = Math.max(answer, t[i] + t[N - 1 - i]);
			}
		}else{
			answer = t[N - 1];
			for(int i=0; i<(N-1)/2; i++){
				answer = Math.max(answer, t[i]+t[N-2-i]);
			}
		}

		System.out.println(answer);
	}
}
