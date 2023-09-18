package baekjoon.ready;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main17484 {

	private static final int[] dy = {-1, 0, 1};
	private static int N, M, ans;
	private static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		ans = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < M; i++) { //모든곳에서 출발
			dfs(1, i, -1, map[0][i]);
		}

		System.out.println(ans);
	}

	private static void dfs(int depth, int y, int dir, int current) {
		if (depth == N) { //마지막 줄이라면
			ans = Math.min(ans, current); //최소 연료 값 비교
			return;
		}

		for (int i = 0; i < 3; i++) {
			int ny = y + dy[i];

			if (ny < 0 || ny >= M) {
				continue;
			}

			if (dir != i) { //현재 위치로 온 방법이 전의 방법이랑 같지 않아야 한다.
				dfs(depth + 1, ny, i, current + map[depth][ny]);
			}
		}
	}

}
