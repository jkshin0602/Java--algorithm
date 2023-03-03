package programmers;

import java.util.Arrays;

public class 삼각_달팽이 {

	public static int[] solution(int n) {
		if (n == 1)
			return new int[] {1};
		int[][] map = new int[n][n];

		int sum = getSum(n);

		int count = 1;
		int y = 0;
		int x = 0;
		int limit = 0;

		while (limit + 1 <= n / 2) {
			//y 증가
			while (y + limit < n && count <= sum) {
				if (map[y][x] != 0)
					break;
				map[y][x] = count++;
				y++;
			}
			y--;
			x++;
			//x 증가
			while (x + limit < n && count <= sum) {
				if (map[y][x] != 0)
					break;
				map[y][x] = count++;
				x++;
			}
			x -= 2;
			y--;
			//y , x 동시 감소
			while (y >= limit && x >= limit && count <= sum) {
				if (map[y][x] != 0)
					break;
				map[y][x] = count++;
				y--;
				x--;
			}
			y += 2;
			x++;
			limit++;
		}

		return getAnswer(n, map, sum);
	}

	private static int[] getAnswer(int n, int[][] map, int sum) {
		int[] answer = new int[sum];

		int idx = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 0)
					break;
				answer[idx++] = map[i][j];
			}
		}

		return answer;
	}

	private static int getSum(int n) {
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			sum += i;
		}

		return sum;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(4)));
		System.out.println(Arrays.toString(solution(6)));
		System.out.println(Arrays.toString(solution(6)));
		System.out.println(Arrays.toString(solution(1)));
	}
}
