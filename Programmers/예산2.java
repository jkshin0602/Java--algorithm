package programmers;

import java.util.Arrays;

public class 예산2 {

	public static int solution(int[] budgets, int M) {
		return binarySearch(budgets, M);
	}

	private static int binarySearch(int[] budgets, int M) {
		int left = 0;
		int right = 0;
		int answer = 0;
		//참고자료
		//https://jypthemiracle.medium.com/java-stream-api%EB%8A%94-%EC%99%9C-for-loop%EB%B3%B4%EB%8B%A4-%EB%8A%90%EB%A6%B4%EA%B9%8C-50dec4b9974b
		// 속도 : 순차 스트림 < for-loop, stream 으로 할경우 시간초과
		for (int budget : budgets) {
			right = Math.max(right, budget);
		}

		while (left <= right) {
			int mid = (left + right) / 2;
			int sum =  Arrays.stream(budgets)
				.map(b -> Math.min(b, mid))
				.sum();

			if (sum <= M) {
				left = mid + 1;
				answer = mid;
			} else {
				right = mid - 1;
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		System.out.println(solution(new int[] {120, 110, 140, 150}, 485));
	}
}
