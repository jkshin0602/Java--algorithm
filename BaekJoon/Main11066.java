package baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main11066 {

	static int K;
	static int[] A;
	static int[][] D, sum;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			input(br);
			go();
		}
	}

	// D[i][j] = min(D[i][k] + D[k+1][j] + (i~j 파일 총량))

	private static void go() {
		init();
		for (int len = 2; len <= K; len++) {
			for (int i = 1; i <= K - len + 1; i++) {
				int j = i + len - 1;
				D[i][j] = Integer.MAX_VALUE;
				for (int k = i; k < j; k++) {
					D[i][j] = Math.min(D[i][j], D[i][k] + D[k + 1][j] + sum[i][j]);
				}
			}
		}
		System.out.println(D[1][K]);
	}

	private static void init() {
		for (int i = 1; i <= K; i++) {
			for (int j = i; j <= K; j++) {
				sum[i][j] = sum[i][j - 1] + A[j];
			}
		}
	}

	private static void input(BufferedReader br) throws IOException {
		StringTokenizer st;
		K = Integer.parseInt(br.readLine());
		A = new int[K + 1];
		D = new int[K + 1][K + 1];
		sum = new int[K + 1][K + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= K; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
	}
}
