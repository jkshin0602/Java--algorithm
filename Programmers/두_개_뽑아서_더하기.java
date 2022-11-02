package programmers;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class 두_개_뽑아서_더하기 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new int[] {2, 1, 3, 4, 1})));
		System.out.println(Arrays.toString(solution(new int[] {5, 0, 2, 7})));
	}

	public static int[] solution(int[] numbers) {
		Set<Integer> set = new TreeSet<>();
		for (int i = 0; i < numbers.length; i++) {
			for (int j = 0; j < numbers.length; j++) {
				if (i == j)
					continue;
				set.add(numbers[i] + numbers[j]);
			}
		}

		int[] answer = new int[set.size()];
		Iterator<Integer> iterator = set.iterator();
		for (int i = 0; i < set.size(); i++) {
			answer[i] = iterator.next();
		}
		return answer;
	}

}
