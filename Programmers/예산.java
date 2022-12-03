package programmers;

import java.util.Arrays;
import java.util.Comparator;

public class 예산 {

	public static int solution(int[] d, int budget) {
		int answer = 0;

		Integer[] numbersArray = Arrays.stream(d)
			.boxed()
			.toArray(Integer[]::new);
		Arrays.sort(numbersArray, Comparator.reverseOrder());

		for (int i = 0; i < numbersArray.length; i++) {
			int tmp = budget;
			int cnt = 0;
			for (int j = i; j < numbersArray.length; j++) {
				tmp -= numbersArray[j];
				if (tmp < 0) {
					break;
				}
				cnt++;
			}
			answer = Math.max(answer, cnt);
		}

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(solution(new int[] {1, 3, 2, 5, 4}, 9));
		System.out.println(solution(new int[] {2, 2, 3, 3}, 10));
		System.out.println(solution(new int[] {120, 110, 140, 150}, 485));
	}
}
