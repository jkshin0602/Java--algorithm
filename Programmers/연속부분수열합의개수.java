package programmers;

import java.util.HashSet;
import java.util.Set;

public class 연속부분수열합의개수 {

	public static int solution(int[] elements) {
		Set<Integer> ans = new HashSet<>();

		for (int i = 1; i <= elements.length; i++) {
			for (int j = 0; j < elements.length; j++) {
				int sum = 0;
				for (int k = 0; k < i; k++) {
					if (j + k > elements.length - 1) {
						sum += elements[j + k - elements.length];
					} else {
						sum += elements[j + k];
					}
				}
				ans.add(sum);

			}
		}

		return ans.size();
	}

	public static void main(String[] args) {
		System.out.println(solution(new int[] {7, 9, 1, 1, 4}));
	}
}
