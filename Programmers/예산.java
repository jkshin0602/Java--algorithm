package programmers;

import java.util.*;

public class 예산 {

	public static int solution(int[] d, int budget) {
		int answer = 0;
		List<Integer> l = new ArrayList<>();
		for (int i : d) {
			l.add(i);
		}
		l.sort(Comparator.reverseOrder());

		int c = 0;
		while (c < l.size()) {
			int tmp = budget;
			int cnt = 0;
			for (int i = c; i < l.size(); i++) {
				tmp -= l.get(i);
				if (tmp < 0) {
					break;
				} else {
					cnt++;
				}
			}
			answer = Math.max(answer, cnt);
			c++;
		}
		return answer;
	}

	public static void main(String[] args) {
		System.out.println(solution(new int[] {1, 3, 2, 5, 4}, 9));
		System.out.println(solution(new int[] {2, 2, 3, 3}, 10));
	}
}
