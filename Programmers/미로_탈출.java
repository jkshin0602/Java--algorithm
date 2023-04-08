package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class 미로_탈출 {

	//S : 시작지점
	//E : 출구
	//L : 레버
	//O : 통로
	//X : 벽

	//S -> L -> E
	//레버를 당기지 않아도 출구가 있는 칸을 지날 수는 있다.

	private static int[] dy = {-1, 0, 1, 0};
	private static int[] dx = {0, 1, 0, -1};
	private static Pair start;
	private static Pair end;

	public static int solution(String[] maps) {
		char[][] map = init(maps);

		return bfs(map, new int[map.length][map[0].length]);
	}

	private static int bfs(char[][] map, int[][] visited) {
		Queue<Pair> q = new LinkedList<>();
		q.add(start);
		int ly = -1, lx = -1, lc = -1;

		while (!q.isEmpty()) {
			Pair p = q.poll();
			for (int i = 0; i < 4; i++) {
				int ny = p.y + dy[i];
				int nx = p.x + dx[i];
				if (isMap(ny, nx, map) || map[ny][nx] == 'X' || visited[ny][nx] > 0) {
					continue;
				}
				q.add(new Pair(ny, nx));
				visited[ny][nx] = visited[p.y][p.x] + 1;
				if (map[ny][nx] == 'L') {
					ly = ny;
					lx = nx;
					lc = visited[ny][nx];
					break;
				}
			}
		}

		if (ly == -1 || lx == -1 || lc == -1) {
			return -1;
		}

		visited = new int[map.length][map[0].length];
		visited[ly][lx] = lc;
		q = new LinkedList<>();
		q.add(new Pair(ly, lx));
		while (!q.isEmpty()) {
			Pair p = q.poll();
			for (int i = 0; i < 4; i++) {
				int ny = p.y + dy[i];
				int nx = p.x + dx[i];
				if (isMap(ny, nx, map) || map[ny][nx] == 'X' || visited[ny][nx] > 0) {
					continue;
				}
				q.add(new Pair(ny, nx));
				visited[ny][nx] = visited[p.y][p.x] + 1;
			}
		}

		return visited[end.y][end.x] == 0 ? -1 : visited[end.y][end.x];
	}

	private static boolean isMap(int ny, int nx, char[][] map) {
		return ny < 0 || nx < 0 || ny >= map.length || nx >= map[0].length;
	}

	private static char[][] init(String[] maps) {
		char[][] map = new char[maps.length][maps[0].length()];

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				map[i][j] = maps[i].charAt(j);
				if (map[i][j] == 'S') {
					start = new Pair(i, j);
					continue;
				}
				if (map[i][j] == 'E') {
					end = new Pair(i, j);
				}
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
		System.out.println(solution(new String[] {"SOOOL", "XXXXO", "OOOOO", "OXXXX", "OOOOE"}) == 16);
		System.out.println(solution(new String[] {"LOOXS", "OOOOX", "OOOOO", "OOOOO", "EOOOO"}) == -1);
	}
}
