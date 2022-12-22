package programmers;

import java.util.Arrays;
import java.util.PriorityQueue;

public class 명예의전당1 {

	public static int[] solution(int k, int[] score) {
		int[] answer = new int[score.length];
		PriorityQueue<Integer> q = new PriorityQueue<>();

		for (int i = 0; i < score.length; i++) {
			q.add(score[i]);
			if (q.size() > k) {
				q.poll();
			}
			answer[i] = q.peek();
		}
		return answer;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(3, new int[] {10, 100, 20, 150, 1, 100, 200})));
		System.out.println(Arrays.toString(solution(4, new int[] {0, 300, 40, 300, 20, 70, 150, 50, 500, 1000})));
	}
}
