package book.nadongbin.문제.BFS_DFS;

import java.util.Arrays;

public class 연산자_끼워_넣기 {
	private static int max = 0;
	private static int min = Integer.MAX_VALUE;

	public static int[] solution(int[] num, int[] operations) {
		getMax(num, operations, num[0], 1);
		return new int[] {max, min};
	}

	private static void getMax(int[] num, int[] operations, int current, int idx) {
		if (idx >= num.length) {
			max = Math.max(current, max);
			min = Math.min(current, min);
			return;
		}
		for (int i = 0; i < 4; i++) {
			if (operations[i] > 0) {
				operations[i]--;
				switch (i) {
					case 0:
						getMax(num, operations, current + num[idx], idx + 1);
						break;
					case 1:
						getMax(num, operations, current - num[idx], idx + 1);
						break;
					case 2:
						getMax(num, operations, current * num[idx], idx + 1);
						break;
					case 3:
						getMax(num, operations, current / num[idx], idx + 1);
						break;
				}
				operations[i]++;
			}
		}

	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new int[] {5, 6}, new int[] {0, 0, 1, 0})));
		System.out.println(Arrays.toString(solution(new int[] {3, 4, 5}, new int[] {1, 0, 1, 0})));
		System.out.println(Arrays.toString(solution(new int[] {1, 2, 3, 4, 5, 6}, new int[] {2, 1, 1, 1})));
	}
}
