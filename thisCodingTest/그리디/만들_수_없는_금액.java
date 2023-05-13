package book.nadongbin.문제.그리디;

import java.util.Arrays;

public class 만들_수_없는_금액 {

	// N개의 동전을 가지고 있다.
	// N개의 동전을 이용하여 만들 수 없는 양의 정수 금액 중 최솟값을 구하는 프로그램

	public static int solution(int[] units) {
		int answer = 1;

		Arrays.sort(units);

		for (int i = 0; i < units.length; i++) {
			if (answer < units[i]) {
				break;
			}
			answer += units[i];
		}

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(solution(new int[] {3, 2, 1, 1, 9}));
	}
}
