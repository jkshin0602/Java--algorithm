package programmers;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class 구명보트 {

	public static int solution(int[] people, int limit) {
		Arrays.sort(people);
		Deque<Integer> deque = new ArrayDeque<>(50001);

		for (int person : people) {
			deque.add(person);
		}

		int answer = 0;
		while (!deque.isEmpty()) {
			int weight = deque.pollLast();
			if (!deque.isEmpty() && weight + deque.peekFirst() <= limit) {
				deque.pollFirst();
			}
			answer++;
		}

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(solution(new int[] {70, 50, 80, 50}, 100));
		System.out.println(solution(new int[] {70, 80, 50}, 100));
		System.out.println(solution(new int[] {40, 40, 40, 30, 50, 80}, 80));
	}
}
