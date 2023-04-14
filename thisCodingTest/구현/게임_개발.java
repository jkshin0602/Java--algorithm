package book.nadongbin.구현;

public class 게임_개발 {

	private static int[] dy = {-1, 0, 1, 0};
	private static int[] dx = {0, 1, 0, -1};

	public static int solution(int N, int M, int y, int x, int d, int[][] map) {
		int ans = 1;
		boolean[][] visited = new boolean[N][M];
		visited[y][x] = true;
		int turnTime = 0;

		while (true) {
			d = rotation(d);
			int ny = y + dy[d];
			int nx = x + dx[d];

			if (!visited[ny][nx] && map[ny][nx] == 0) {
				visited[ny][nx] = true;
				y = ny;
				x = nx;
				ans++;
				turnTime = 0;
				continue;
			} else {
				turnTime++;
			}

			if (turnTime == 4) {
				ny = y - dy[d];
				nx = x - dx[d];

				if (map[ny][nx] == 0) {
					y = ny;
					x = nx;
				} else {
					break;
				}
				turnTime = 0;
			}
		}

		return ans;
	}

	private static int rotation(int d) {
		d--;
		return d < 0 ? d + 3 : d;
	}

	public static void main(String[] args) {
		System.out.println(solution(4, 4, 1, 1, 0,
			new int[][] {{1, 1, 1, 1}, {1, 0, 0, 1}, {1, 1, 0, 1}, {1, 1, 1, 1}}));
	}
}
