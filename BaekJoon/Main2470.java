package baekjoon.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2470 {

	static int N;
	static int[] A;
	static StringBuilder sb = new StringBuilder();

	static int go(int[] A, int left, int right, int value) {
		int result = right+1;
		while (left <= right){
			int mid = (left + right) / 2;
			if (A[mid] >= value) {
				result = mid;
				right = mid - 1;
			}else{
				left = mid + 1;
			}
		}
		return result;
	}

	public static void main(String[] args) throws Exception {
		input();

		int ans = Integer.MAX_VALUE;
		int v1 = 0, v2 = 0;
		for (int left = 1; left <= N - 1; left++) {
			int result = go(A, left + 1, N, -A[left]);

			if (left + 1 <= result - 1 && result - 1 <= N && Math.abs(A[result - 1] + A[left]) < ans) {
				ans = Math.abs(A[result - 1] + A[left]);
				v1 = A[left];
				v2 = A[result - 1];
			}
			if (left + 1 <= result && result <= N && Math.abs(A[result] + A[left]) < ans) {
				ans = Math.abs(A[result] + A[left]);
				v1 = A[left];
				v2 = A[result];
			}
		}
		sb.append(v1).append(' ').append(v2);
		System.out.println(sb);
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(A, 1, N + 1);
	}

}
