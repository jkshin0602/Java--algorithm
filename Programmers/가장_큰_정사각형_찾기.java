package programmers;

public class 가장_큰_정사각형_찾기 {

	//위, 왼쪽대각, 왼쪽의 최솟값 + 1

	private static int[] dy = {-1, -1, 0};
	private static int[] dx = {0, -1, -1};

	public static int solution(int[][] board) {
		go(board);

		int ans = find(board);
		return ans * ans;
	}

	private static int find(int[][] board) {
		int ans = -1;

		for (int[] nums : board) {
			for (int j = 0; j < board[0].length; j++) {
				ans = Math.max(ans, nums[j]);
			}
		}

		return ans;
	}

	private static void go(int[][] board) {
		for (int i = 1; i < board.length; i++) {
			for (int j = 1; j < board[0].length; j++) {
				if (board[i][j] > 0) {
					int min = Integer.MAX_VALUE;
					for (int k = 0; k < 3; k++) {
						int ny = i + dy[k];
						int nx = j + dx[k];
						min = Math.min(min, board[ny][nx]);
					}
					board[i][j] = min + 1;
				}
			}
		}
	}

	public static void main(String[] args) {
		System.out.println(solution(new int[][] {{0, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {0, 0, 0, 0}}));
		System.out.println(solution(new int[][] {{0, 0, 1, 1}, {1, 1, 1, 1}}));

	}
}
