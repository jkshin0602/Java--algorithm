package book.nadongbin.문제.정렬;

import java.util.PriorityQueue;

public class 카드_정렬하기 {

	public static int solution(int N, int[] cards) {
		PriorityQueue<Integer> q = new PriorityQueue<>();

		for (int card : cards) {
			q.add(card);
		}

		int answer = 0;

		while (q.size() > 1) {
			int x = q.poll();
			int y = q.poll();

			int sum = x + y;
			answer += sum;
			q.add(sum);
		}

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(solution(3, new int[] {10, 20, 40}));
	}
}

//(10+20) + (30 + 40) = 100
//(20+40) + (60 + 10)