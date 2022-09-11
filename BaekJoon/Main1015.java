package baekjoon.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main1015 {

	static int[] A, B;
	static int N;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		input();
		Arrays.sort(B);
		find();
		System.out.println(sb);
	}

	private static void find() {
		for (int i = 0; i < N; i++) {
			int a = A[i];
			for (int j = 0; j < N; j++) {
				if (a == B[j]) {
					sb.append(j).append(' ');
					B[j] = -1;
					break;
				}
			}
		}
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		A = new int[N];
		B = new int[N];
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			A[i] = num;
			B[i] = num;
		}
	}
}



