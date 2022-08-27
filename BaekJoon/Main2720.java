package baekjoon.그리디;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main2720 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		final int Q = 25;
		final int D = 10;
		final int N = 5;
		final int P = 1;
		while (T-- > 0) {
			int C = Integer.parseInt(br.readLine());
			StringBuilder sb = new StringBuilder();
			sb.append(C / Q).append(' ');
			C %= Q;
			sb.append(C / D).append(' ');
			C %= D;
			sb.append(C / N).append(' ');
			C %= N;
			sb.append(C / P);
			System.out.println(sb);
		}
	}
}
