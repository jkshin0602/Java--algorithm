package book.nadongbin.최단경로;

import java.util.Arrays;
import java.util.StringTokenizer;

public class 미래_도시 {

	private static final int INF = (int)1e9;

	public static int solution(int N, int K, int X, String[] info) {
		int[][] graph = new int[101][101];

		for (int i = 0; i < 101; i++) {
			Arrays.fill(graph[i], INF);
		}

		for (int a = 1; a <= N; a++) {
			for (int b = 1; b <= N; b++) {
				if (a == b) graph[a][b] = 0;
			}
		}

		StringTokenizer st;
		for (int i = 0; i < info.length; i++) {
			st = new StringTokenizer(info[i]);
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			graph[x][y] = 1;
			graph[y][x] = 1;
		}

		for (int k = 1; k <= N; k++) {
			for (int a = 1; a <= N; a++) {
				for (int b = 1; b <= N; b++) {
					graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
				}
			}
		}

		int distance = graph[1][K] + graph[K][X];
		return distance >= INF ? -1 : distance;
	}

	public static void main(String[] args) {
		System.out.println(solution(5, 4, 5, new String[] {
			"1 2",
			"1 3",
			"1 4",
			"2 4",
			"3 4",
			"3 5",
			"4 5"
		}));
	}
}
