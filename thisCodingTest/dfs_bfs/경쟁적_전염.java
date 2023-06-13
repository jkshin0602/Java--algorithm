package book.nadongbin.문제.BFS_DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 경쟁적_전염 {

	private static int[] dy = {-1, 0, 1, 0};
	private static int[] dx = {0, 1, 0, -1};

	public static int solution(int N, int K, int[][] map, int[] info) {

		int S = info[0];
		int X = info[1];
		int Y = info[2];

		return bfs(S, map, X, Y);
	}

	private static int bfs(int S, int[][] map, int X, int Y) {
		List<Pair> list = new ArrayList<>();

		int[][] visited = new int[map.length][map.length];
		for (int[] visit : visited) {
			Arrays.fill(visit, -1);
		}

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				if (map[i][j] != 0) {
					list.add(new Pair(i, j, map[i][j]));
					visited[i][j] = 0;
				}
			}
		}

		list.sort(Comparator.comparingInt(o -> o.virus));

		Queue<Pair> q = new LinkedList<>(list);

		while (!q.isEmpty()) {
			Pair p = q.poll();
			for (int i = 0; i < 4; i++) {
				int ny = p.y + dy[i];
				int nx = p.x + dx[i];

				if (isNotMap(ny, nx, map) || visited[ny][nx] != -1) {
					continue;
				}

				q.add(new Pair(ny, nx, map[ny][nx]));
				map[ny][nx] = map[p.y][p.x];
				visited[ny][nx] = visited[p.y][p.x] + 1;
			}
		}

		return visited[X - 1][Y - 1] > S ? 0 : map[X - 1][Y - 1];
	}

	private static boolean isNotMap(int ny, int nx, int[][] map) {
		return ny < 0 || nx < 0 || ny >= map.length || nx >= map.length;
	}

	private static class Pair {
		int y, x, virus;

		public Pair(int y, int x, int virus) {
			this.y = y;
			this.x = x;
			this.virus = virus;
		}
	}

	public static void main(String[] args) {
		System.out.println(solution(3, 3, new int[][] {{1, 0, 2}, {0, 0, 0}, {3, 0, 0}}, new int[] {2, 3, 2}));
		System.out.println(solution(3, 3, new int[][] {{1, 0, 2}, {0, 0, 0}, {3, 0, 0}}, new int[] {1, 2, 2}));
	}
}
