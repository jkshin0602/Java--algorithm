package programmers;

import java.util.Arrays;

public class 카펫 {

	public static int[] solution(int brown, int yellow) {
		int sum = brown + yellow;

		return find(yellow, sum);
	}

	private static int[] find(int yellow, int sum) {
		int y = 0, x = 0;

		for (int i = 1; i <= yellow; i++) {
			if (yellow % i == 0) {
				y = Math.min(i, yellow / i);
				x = Math.max(i, yellow / i);
				if ((y + 2) * (x + 2) == sum) {
					break;
				}
			}
		}

		return new int[] {x + 2, y + 2};
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(10, 2)));
		System.out.println(Arrays.toString(solution(8, 1)));
		System.out.println(Arrays.toString(solution(24, 24)));
	}
}
