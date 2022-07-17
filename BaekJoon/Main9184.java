package baekjoon.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main9184 {

	static int[][][] D = new int[21][21][21];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int A, B, C;
		while (true) {
			st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			if (A == -1 && B == -1 && C == -1)
				break;
			System.out.printf("w(%d, %d, %d) = %d\n", A, B, C, go(A, B, C));
		}

	}

	//D[a][b][c]

	static int go(int a, int b, int c) {
		if (a <= 0 || b <= 0 || c <= 0) {
			return 1;
		} else if (a > 20 || b > 20 || c > 20) {
			return go(20, 20, 20);
		} else if (D[a][b][c] != 0) {
			return D[a][b][c];
		} else if (a < b && b < c) {
			return D[a][b][c] = go(a, b, c - 1) + go(a, b - 1, c - 1) - go(a, b - 1, c);
		}
		return D[a][b][c] = go(a - 1, b, c) + go(a - 1, b - 1, c) + go(a - 1, b, c - 1) - go(a - 1, b - 1, c - 1);
	}

}
