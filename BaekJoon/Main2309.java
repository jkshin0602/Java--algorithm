package baekjoon.ready;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main2309 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] A = new int[9];

		int sum = 0;
		for (int i = 0; i < 9; i++) {
			A[i] = Integer.parseInt(br.readLine());
			sum += A[i];
		}

		Arrays.sort(A);

		for (int i = 0; i < 9; i++) {
			for (int j = i + 1; j < 9; j++) {
				if (sum - A[i] - A[j] == 100) {
					for (int k = 0; k < 9; k++) {
						if (k == i || k == j) {
							continue;
						}
						System.out.println(A[k]);
					}
					return;
				}
			}
		}
	}
}
