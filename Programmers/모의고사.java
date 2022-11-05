package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 모의고사 {

	private static int[] one = {1, 2, 3, 4, 5};
	private static int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
	private static int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

	public static int[] solution(int[] answers) {
		int oneCnt = 0, twoCnt = 0, threeCnt = 0;
		for (int i = 0; i < answers.length; i++) {
			if (one[i % one.length] == answers[i]) {
				oneCnt++;
			}
			if (two[i % two.length] == answers[i]) {
				twoCnt++;
			}
			if (three[i % three.length] == answers[i]) {
				threeCnt++;
			}
		}

		List<Integer> list = new ArrayList<>();
		int max = Math.max(oneCnt, Math.max(twoCnt, threeCnt));
		if (max == oneCnt) {
			list.add(1);
		}
		if (max == twoCnt) {
			list.add(2);
		}
		if (max == threeCnt) {
			list.add(3);
		}

		return list.stream().mapToInt(Integer::intValue).toArray();
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new int[] {1, 2, 3, 4, 5})));
		System.out.println(Arrays.toString(solution(new int[] {1, 3, 2, 4, 2})));
	}

}
