package book.nadongbin.문제.BFS_DFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 인구_이동 {

	//국경선을 공유하는 두 나라의 인구 차이가 L명 이상, R명 이하라면, 국경을 연다.
	//국경선이 열려 있어 인접한 칸만을 이용해 이동할 수 있으면, 연합이라 한다.
	//연합을 이루고 있는 각 칸의 인구수는 (연합의 인구수)/연합을 이루고 있는 칸의 개수 가 된다. 소수점x
	//연합을 해체하고,모든 국경선을 닫는다.

	private static int[] dy = {-1, 0, 1, 0};
	private static int[] dx = {0, 1, 0, -1};
	private static int ans;
	private static int[][] unions;

	public static int solution(int N, int L, int R, int[][] map) {
		ans = 0;
		unions = new int[N][N];

		while (true) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					unions[i][j] = -1;
				}
			}
			int index = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (unions[i][j] == -1) {
						bfs(L, R, map, new Pair(i, j), index);
						index++;
					}
				}
			}

			if (index == N * N) {
				break;
			}

			ans++;
		}

		return ans;
	}

	private static void bfs(int L, int R, int[][] map, Pair start, int index) {
		Queue<Pair> q = new LinkedList<>();
		List<Pair> list = new ArrayList<>();

		list.add(start);
		q.add(start);
		unions[start.y][start.x] = index;
		int sum = map[start.y][start.x];

		while (!q.isEmpty()) {
			Pair p = q.poll();
			for (int i = 0; i < 4; i++) {
				int ny = p.y + dy[i];
				int nx = p.x + dx[i];

				if (isNotMap(ny, nx, map.length) || unions[ny][nx] != -1) {
					continue;
				}

				if (check(L, R, map[p.y][p.x], map[ny][nx])) {
					unions[ny][nx] = index;
					sum += map[ny][nx];

					Pair pair = new Pair(ny, nx);
					list.add(pair);
					q.add(pair);
				}
			}
		}

		int aver = sum / list.size();
		for (Pair p : list) {
			map[p.y][p.x] = aver;
		}
	}

	private static boolean isNotMap(int ny, int nx, int len) {
		return ny < 0 || nx < 0 || ny >= len || nx >= len;
	}

	private static boolean check(int L, int R, int a, int b) {
		int result = Math.abs(a - b);
		return L <= result && result <= R;
	}

	private static class Pair {
		int y, x;

		public Pair(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	public static void main(String[] args) {
		System.out.println(solution(2, 20, 50, new int[][] {{50, 30}, {20, 40}}) == 1);
		System.out.println(solution(2, 40, 50, new int[][] {{50, 30}, {20, 40}}) == 0);
		System.out.println(solution(2, 20, 50, new int[][] {{50, 30}, {30, 40}}) == 1);
		System.out.println(solution(3, 5, 10, new int[][] {{10, 15, 20}, {20, 30, 25}, {40, 22, 10}}) == 2);
		System.out.println(solution(4, 10, 50,
			new int[][] {{10, 100, 20, 90}, {80, 100, 60, 70}, {70, 20, 30, 40}, {50, 20, 100, 10}}) == 3);
	}
}
