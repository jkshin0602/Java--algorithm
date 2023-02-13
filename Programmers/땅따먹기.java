package programmers;

public class 땅따먹기 {

	//D[i][j] = (i,j) 까지 도달했을 때의 최댓값
	//D[i][j] = max(D[i-1][0], ... D[i-1][k]) + land[i][j]
	// j == k -> continue

	public static int solution(int[][] land) {

		int[][] d = new int[land.length][land[0].length];
		for (int i = 0; i < land[0].length; i++) {
			d[0][i] = land[0][i];
		}

		for (int i = 1; i < land.length; i++) {
			for (int j = 0; j < land[i].length; j++) {
				for (int k = 0; k < land[i].length; k++) {
					if (j == k)
						continue;
					d[i][j] = Math.max(d[i][j], d[i - 1][k] + land[i][j]);
				}
			}
		}

		int ans = 0;
		for (int i = 0; i < land[0].length; i++) {
			ans = Math.max(ans, d[land.length - 1][i]);
		}

		return ans;
	}

	public static void main(String[] args) {
		System.out.println(solution(new int[][] {{1, 2, 3, 5}, {5, 6, 7, 8}, {4, 3, 2, 1}}));
		System.out.println(solution(new int[][] {{1, 1, 1, 1}, {2, 2, 2, 3}, {3, 3, 3, 6}, {4, 4, 4, 7}}));
	}
}
