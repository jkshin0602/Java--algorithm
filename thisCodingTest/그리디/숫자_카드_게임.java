package book.nadongbin.그리디;

public class 숫자_카드_게임 {

	public static int solution(int N, int M, int[][] cards) {
		int ans = 0;

		for (int i = 0; i < cards.length; i++) {
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < M; j++) {
				min = Math.min(min, cards[i][j]);
			}
			ans = Math.max(ans, min);
		}

		return ans;
	}

	public static void main(String[] args) {
		System.out.println(solution(3, 3, new int[][]
			{{3, 1, 2}, {4, 1, 4}, {2, 2, 2}}));
		System.out.println(solution(2, 4, new int[][]
			{{7, 3, 1, 8}, {3, 3, 3, 4}}));

	}
}
