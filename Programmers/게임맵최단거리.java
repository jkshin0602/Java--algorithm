package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 게임맵최단거리 {

	private static int[] dy = {-1, 0, 1, 0};
	private static int[] dx = {0, 1, 0, -1};
	private static int[][] checked;

	public static int solution(int[][] maps) {
		init(maps);
		return bfs(maps);
	}

	private static int bfs(int[][] maps) {
		Queue<Pair> q = new LinkedList<>();

		q.add(new Pair(0, 0));
		checked[0][0] = 1;

		while (!q.isEmpty()) {
			Pair p = q.poll();
			addNextPair(maps, q, p);
		}

		return checked[maps.length - 1][maps[0].length - 1];
	}

	private static void addNextPair(int[][] maps, Queue<Pair> q, Pair p) {
		for (int i = 0; i < 4; i++) {
			int ny = p.y + dy[i];
			int nx = p.x + dx[i];
			if (isMap(ny, nx, maps)) {
				continue;
			}
			checked[ny][nx] = checked[p.y][p.x] + 1;
			q.add(new Pair(ny, nx));
		}
	}

	private static boolean isMap(int ny, int nx, int[][] maps) {
		return ny < 0 || ny >= checked.length || nx < 0 || nx >= checked[0].length
			|| checked[ny][nx] != -1 || maps[ny][nx] != 1;
	}

	private static void init(int[][] maps) {
		checked = new int[maps.length][maps[0].length];
		for (int i = 0; i < checked.length; i++) {
			Arrays.fill(checked[i], -1);
		}
	}

	private static class Pair {
		int y, x;

		public Pair(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	public static void main(String[] args) {
		System.out.println(solution(new int[][] {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1},
			{1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}}));

		System.out.println(solution(new int[][] {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1},
			{1, 0, 1, 1, 1}, {1, 1, 1, 0, 0}, {0, 0, 0, 0, 1}}));
	}

}
