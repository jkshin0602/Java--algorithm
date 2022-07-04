package baekjoon.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main7795 {

	static int N, M;
	static int[] A, B;

	static int go(int[] B, int left, int right, int value) {
		int result = left - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (B[mid] < value) {
				result = mid;
				left = mid + 1;
			} else if (B[mid] >= value) {
				right = mid - 1;
			}
		}
		return result;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		while (T-- > 0) {
			input(br);
			int ans = 0;
			for (int i = 1; i <= N; i++) {
				ans += go(B, 1, M, A[i]);
			}
			System.out.println(ans);
		}
	}

	private static void input(BufferedReader br) throws IOException {
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		A = new int[N + 1];
		B = new int[M + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= M; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(B, 1, M + 1);
	}

}
