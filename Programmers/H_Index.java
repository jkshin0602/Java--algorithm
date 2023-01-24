package programmers;

import java.util.Arrays;

public class H_Index {

	//h-index = 논문 n 편중 h번 인용된 논문이 h편 이상이고, 나머지 논문이 h번 이하 인용되었되었을 때 최대값
	//1 <= n <= 1000
	//0 <= h <= 10000

	public static int solution(int[] citations) {
		Arrays.sort(citations);

		int len = citations[citations.length - 1];

		int max = 0;
		for (int i = 0; i <= len; i++) {
			int countA = 0;
			int countB = 0;

			for (int j = 0; j < citations.length; j++) {
				if (citations[j] <= i) {
					countA++;
				}
				if (citations[j] >= i) {
					countB++;
				}

			}
			if (countA <= i && countB >= i) {
				max = Math.max(i, max);
			}
		}

		return max;
	}

	public static void main(String[] args) {
		System.out.println(solution(new int[] {3, 0, 6, 1, 5}));
		System.out.println(solution(new int[] {3, 0, 6, 1, 5, 7}));
	}
}
