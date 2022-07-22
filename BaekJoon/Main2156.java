package baekjoon.DP;

import java.util.*;
import java.io.*;

class Main2156 {

	static int[] D, A;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		D = new int[N + 1];
		A = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			A[i] = Integer.parseInt(br.readLine());
		}
		// D[N] = max(D[N-1], (D[N-2]+A[N]) , (D[N-3] + +A[i-1] + A[N])
		if (N >= 1)
			D[1] = A[1];
		if (N >= 2)
			D[2] = D[1] + A[2];
		if (N >= 3)
			D[3] = Math.max(D[2], Math.max(D[1] + A[3], A[1] + A[3]));
		for (int i = 4; i <= N; i++) {
			D[i] = Math.max(D[i - 1], Math.max(D[i - 2], D[i - 3] + A[i - 1]) + A[i]);
		}

		System.out.println(D[N]);
	}
}



