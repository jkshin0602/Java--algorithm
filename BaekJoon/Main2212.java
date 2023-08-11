package baekjoon.ready;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class Main2212 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		int[] A = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		if (N <= K) {
			System.out.println(0);
			return;
		}

		Arrays.sort(A);

		Integer[] diff = new Integer[N - 1];
		for (int i = 0; i < N - 1; i++) {
			diff[i] = A[i + 1] - A[i];
		}

		Arrays.sort(diff, Comparator.reverseOrder());

		int sum = 0;
		for (int i = K - 1; i < N - 1; i++) {
			sum += diff[i];
		}

		System.out.println(sum);
	}
}
