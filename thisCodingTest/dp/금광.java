package book.nadongbin.문제.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 금광 {

	//각 칸은 특정한 크기의 금이 들어 있따.
	//채굴자는 첫번째 열부터 출발하여 금을 캔다
	//맨 처음에는 첫 번째 열의 어느 행에서도 출발이 가능
	//이후 m번에 걸쳐서 매번 오른쪽 위, 오른쪽, 오른쪽 아래 쪽 3가지 중 하나의 위치로만 이동
	//채굴자가 얻을 수 있는 금의 최대 크기

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			int[][] map = new int[20][20];
			int[][] d = new int[20][20];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					d[i][j] = map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int j = 1; j < m; j++) {
				for (int i = 0; i < n; i++) {
					int leftUp, left, leftDown;

					//왼쪽 위
					if (i == 0) { //왼쪽 위에서는 올 수 없다.
						leftUp = 0;
					} else {
						leftUp = d[i - 1][j - 1];
					}

					//왼쪽 아래
					if (i == n - 1) { //왼쪽 아래에서는 올 수 없다
						leftDown = 0;
					} else {
						leftDown = d[i + 1][j - 1];
					}

					//왼쪽
					left = d[i][j - 1];

					d[i][j] = d[i][j] + Math.max(leftUp, Math.max(leftDown, left));
				}
			}

			int ans = 0;
			for (int i = 0; i < n; i++) {
				ans = Math.max(ans, d[i][m - 1]);
			}

			System.out.println(ans);
		}

	}

}
