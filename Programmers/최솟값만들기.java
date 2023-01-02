package programmers;

import java.util.Collections;
import java.util.PriorityQueue;

public class 최솟값만들기 {

	public static int solution(int[] A, int[] B) {
		int ans = 0;
		PriorityQueue<Integer> a = new PriorityQueue<>();
		PriorityQueue<Integer> b = new PriorityQueue<>(Collections.reverseOrder());

		for (int i = 0; i < A.length; i++) {
			a.add(A[i]);
			b.add(B[i]);
		}

		while (!a.isEmpty()) {
			ans += a.poll() * b.poll();
		}

		return ans;
	}

	public static void main(String[] args) {
		System.out.println(solution(new int[] {1, 4, 2}, new int[] {5, 4, 4}));
		System.out.println(solution(new int[] {1, 2}, new int[] {3, 4}));
	}
}
