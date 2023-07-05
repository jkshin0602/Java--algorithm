package book.nadongbin.문제.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 정수_삼각형 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[501][501];
		int[][] d = new int[501][501];

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int idx = 1;
			while (st.hasMoreTokens()) {
				d[i][idx] = arr[i][idx] = Integer.parseInt(st.nextToken());
				idx++;
			}
		}

		for (int i = 2; i <= N; i++) {
			if (i == 1) {
				continue;
			}

			for (int j = 1; j <= N; j++) {
				if (arr[i][j] == 0) {
					break;
				}
				d[i][j] = d[i][j] + Math.max(d[i - 1][j], d[i - 1][j - 1]);
			}
		}

		int max = 0;
		for (int i = 1; i <= N; i++) {
			max = Math.max(d[N][i], max);
		}

		System.out.println(max);
	}

}
