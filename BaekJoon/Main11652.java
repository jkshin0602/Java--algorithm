package baekjoon.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main11652 {

	static int N;
	static long[] A;
	static int length, maxLength;
	static long ans, last;

	public static void main(String[] args) throws Exception {
		input();
		Arrays.sort(A);
		last = A[0];
		length = 1;
		for (int i = 1; i < N; i++) {
			if (last == A[i]) {
				length++;
			} else {
				if (length > maxLength) {
					maxLength = length;
					ans = last;
				}
				length = 1;
				last = A[i];
			}
		}
		if (length > maxLength) {
			maxLength = length;
			ans = last;
		}
		System.out.println(ans);
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		A = new long[N];
		for (int i = 0; i < N; i++) {
			A[i] = Long.parseLong(br.readLine());
		}
	}

}
