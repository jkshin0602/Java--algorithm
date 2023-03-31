package programmers;

import java.util.Arrays;

public class 숫자_카드_나누기 {

	//1. A가 가진 카드들에 적힌 모든 숫자를 나눌 수 있고, B가 가진 카드들에 적힌 모든 숫자들 중 하나도 나눌 수 없는 수
	//2. B가 가진 카드들에 적힌 모든 숫자를 나눌 수 있고, A가 가진 카드들에 적힌 모든 숫자를 중 하나도 나눌 수 없는 수

	public static int solution(int[] arrayA, int[] arrayB) {
		int answer = 0;

		int idx = 0;
		int max = Math.max(Arrays.stream(arrayA).max().getAsInt(), Arrays.stream(arrayB).max().getAsInt());

		for (int i = 1; i <= max; i++) {
			int tmp = 0;
			for (int j = 0; j < arrayA.length; j++) {
				if (arrayA[j] % i == 0 && arrayB[j] % i != 0) {
					tmp = Math.max(answer, i);
				} else {
					tmp = 0;
					break;
				}
			}
			answer = Math.max(answer, tmp);
			for (int j = 0; j < arrayA.length; j++) {
				if (arrayB[j] % i == 0 && arrayA[j] % i != 0) {
					tmp = Math.max(answer, i);
				} else {
					tmp = 0;
					break;
				}
			}
			answer = Math.max(answer, tmp);
		}

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(solution(new int[] {10, 17}, new int[] {5, 20}));
		System.out.println(solution(new int[] {10, 20}, new int[] {5, 17}));
		System.out.println(solution(new int[] {14, 35, 119}, new int[] {18, 30, 102}));
	}
}
