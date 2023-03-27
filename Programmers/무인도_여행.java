package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 무인도_여행 {

	private static int[] dy = {-1, 0, 1, 0};
	private static int[] dx = {0, 1, 0, -1};

	public static int[] solution(String[] maps) {
		char[][] map = init(maps);
		List<Integer> ansList = go(map);

		if (ansList.isEmpty()) {
			return new int[] {-1};
		}

		return ansList.stream()
			.mapToInt(Integer::intValue)
			.sorted()
			.toArray();
	}

	private static List<Integer> go(char[][] map) {
		List<Integer> ans = new ArrayList<>();
		boolean[][] visited = new boolean[map.length][map[0].length];

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if (isNumber(map[i][j]) && !visited[i][j]) {
					ans.add(bfs(i, j, map, visited));
				}
			}
		}

		return ans;
	}

	private static int bfs(int y, int x, char[][] map, boolean[][] visited) {
		int ans = map[y][x] - '0';
		Queue<Pair> q = new LinkedList<>();

		q.add(new Pair(y, x));
		visited[y][x] = true;

		while (!q.isEmpty()) {
			Pair p = q.poll();
			for (int i = 0; i < 4; i++) {
				int ny = p.y + dy[i];
				int nx = p.x + dx[i];
				if (isNotMap(ny, nx, map) || visited[ny][nx]) {
					continue;
				}

				q.add(new Pair(ny, nx));
				visited[ny][nx] = true;
				ans += map[ny][nx] - '0';
			}
		}

		return ans;
	}

	private static boolean isNotMap(int y, int x, char[][] map) {
		return y < 0 || x < 0 || y >= map.length || x >= map[0].length || map[y][x] == 'X';
	}

	private static boolean isNumber(char c) {
		return c >= '0' && c <= '9';
	}

	private static char[][] init(String[] maps) {
		char[][] map = new char[maps.length][maps[0].length()];

		for (int i = 0; i < map.length; i++) {
			String s = maps[i];
			for (int j = 0; j < map[0].length; j++) {
				map[i][j] = s.charAt(j);
			}
		}

		return map;
	}

	private static class Pair {
		int y, x;

		public Pair(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new String[] {"X591X", "X1X5X", "X231X", "1XXX1"})));
		System.out.println(Arrays.toString(solution(new String[] {"XXX", "XXX", "XXX"})));
	}
}
