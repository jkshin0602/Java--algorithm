package book.nadongbin.문제.BFS_DFS;

import java.util.LinkedList;
import java.util.Queue;

public class 블록_이동하기 {

	private static int[][] Board;
	private static int N;
	private static Queue<Point[]> Q = new LinkedList<>();
	private static boolean[][][] Visited = new boolean[100][100][4];
	private static final int UP = 0;
	private static final int RIGHT = 1;
	private static final int DOWN = 2;
	private static final int LEFT = 3;
	private static int[][] D = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	private static int[][][] Drot = {{{1, 1}, {1, -1}, {-1, -1}, {-1, 1}},
		{{1, -1}, {-1, -1}, {-1, 1}, {1, 1}}};
	private static int[][][] Dcor = {{{-1, 1}, {1, 1}, {1, -1}, {-1, -1}},
		{{-1, -1}, {-1, 1}, {1, 1}, {1, -1}}};

	public static int solution(int[][] board) {
		Board = board;
		N = board.length;
		Q.add(new Point[] {new Point(0, 0, RIGHT, 0), new Point(0, 1, LEFT, 0)});
		Visited[0][0][RIGHT] = true;
		Visited[0][1][LEFT] = true;
		Point[] curr = new Point[2];
		Point[] newPt = new Point[2];

		while ((curr = Q.poll()) != null) {
			for (int j = 0; j < 4; j++) {
				for (int i = 0; i < 2; i++) {
					newPt[i] = new Point(curr[i].row + D[j][0], curr[i].col + D[j][1],
						curr[i].dir, curr[i].time + 1);
				}

				if (!isValid(newPt)) {
					continue;
				}

				for (int i = 0; i < 2; i++) {
					if (newPt[i].row == N - 1 && newPt[i].col == N - 1) {
						return newPt[i].time;
					}

					Visited[newPt[i].row][newPt[i].col][newPt[i].dir] = true;
				}
				Q.add(new Point[] {newPt[0], newPt[1]});
			}

			for (int ccw = 0; ccw < 2; ccw++) {
				for (int i = 0; i < 2; i++) {
					int ret = rotate(curr, ccw, i);
					if (ret != 0) {
						return ret;
					}

				}
			}
		}

		return 0;
	}

	private static int rotate(Point[] curr, int ccw, int idx) {
		Point[] newPt = new Point[2];
		int a = idx, b = (idx + 1) % 2;
		int dir = curr[a].dir;
		newPt[0] = new Point(curr[a].row, curr[a].col,
			(curr[a].dir + (ccw == 0 ? 1 : 3)) % 4, curr[a].time + 1);
		newPt[1] = new Point(curr[b].row + Drot[ccw][dir][0], curr[b].col + Drot[ccw][dir][1],
			(curr[b].dir + (ccw == 0 ? 1 : 3)) % 4, curr[b].time + 1);

		if (!isValid(newPt)) {
			return 0;
		}

		if (Board[curr[a].row + Dcor[ccw][dir][0]][curr[a].col + Dcor[ccw][dir][1]] == 1) {
			return 0;
		}

		for (int i = 0; i < 2; i++) {
			if (newPt[i].row == N - 1 && newPt[i].col == N - 1) {
				return newPt[i].time;
			}
			Visited[newPt[i].row][newPt[i].col][newPt[i].dir] = true;
		}
		Q.add(new Point[] {newPt[0], newPt[1]});
		return 0;
	}

	private static boolean isValid(Point[] pt) {
		for (int i = 0; i < 2; i++) {
			if (pt[i].row < 0 || pt[i].row > N - 1 || pt[i].col < 0 || pt[i].col > N - 1) {
				return false;
			}

			if (Board[pt[i].row][pt[i].col] == 1) {
				return false;
			}

			if (Visited[pt[i].row][pt[i].col][pt[i].dir]) {
				return false;
			}
		}

		return true;
	}

	private static class Point {
		int row, col, dir, time;

		public Point(int row, int col, int dir, int time) {
			this.row = row;
			this.col = col;
			this.dir = dir;
			this.time = time;
		}
	}

	public static void main(String[] args) {
		System.out.println(solution(
			new int[][] {
				{0, 0, 0, 1, 1},
				{0, 0, 0, 1, 0},
				{0, 1, 0, 1, 1},
				{1, 1, 0, 0, 1},
				{0, 0, 0, 0, 0}
			}));
	}
}
