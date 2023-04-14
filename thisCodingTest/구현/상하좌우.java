package book.nadongbin.구현;

import java.util.Arrays;

public class 상하좌우 {

	private static int[] dy = {-1, 0, 1, 0};
	private static int[] dx = {0, 1, 0, -1};

	public static int[] solution(int N, String command) {
		int sy = 1;
		int sx = 1;

		for (int i = 0; i < command.length(); i++) {
			int ny, nx;
			if (command.charAt(i) == 'U') {
				ny = sy + dy[0];
				nx = sx + dx[0];
			} else if (command.charAt(i) == 'R') {
				ny = sy + dy[1];
				nx = sx + dx[1];
			} else if (command.charAt(i) == 'D') {
				ny = sy + dy[2];
				nx = sx + dx[2];
			} else {
				ny = sy + dy[3];
				nx = sx + dx[3];
			}

			if (isNotMap(ny, nx, N)) {
				continue;
			}
			sy = ny;
			sx = nx;
		}

		return new int[] {sy, sx};
	}

	private static boolean isNotMap(int ny, int nx, int N) {
		return ny < 1 || ny > N || nx < 1 || nx > N;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(5, "RRRUDD")));
	}
}
