package programmers;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class 더맵게 {

	//섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
	//스코빌 지수가 K 이상이 될 때까지 반복
	//모든 음식의 스코빌 지수를 K 이상으로 만들기 위해 섞어야 하는 최소 횟수
	//만들 수 없는 경우 -1

	//2 <= scoville.length <= 1,000,000
	//0 <= K <- 1,000,000,000
	//0 <= scoville <= 1,000,000

	public static int solution(int[] scoville, int K) {
		PriorityQueue<Integer> pq = Arrays.stream(scoville)
			.boxed()
			.collect(Collectors.toCollection(PriorityQueue::new));

		int answer = 0;
		int min = pq.peek();

		while (K > min && pq.size() > 1) {
			answer++;
			int a = pq.poll();
			int b = pq.poll();
			int tmp = a + (b * 2);
			pq.add(tmp);
			min = pq.peek();
		}

		if (K > min) {
			return -1;
		}

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(solution(new int[] {1, 2, 3, 9, 10, 12}, 7));
		System.out.println(solution(new int[] {1, 1, 1}, 10));
	}
}
