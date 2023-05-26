package book.nadongbin.문제.그리디;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 무지의_먹방_라이브 {

	//회전판에 먹어야 할 N개의 음식이 있다.
	//각 음식에는 1~N까지의 번호가 있으며, 각 음식을 섭취하는데 일정 시간이 소요된다.
	//1번 음식 부터 먹기 시작하여, 회전판은 번호판이 증가하는 순서대로 음식을 무지 앞으로 가져도 놓는다.
	//마지막 번호의 음식을 섭취한 후에는 회전판에 의해 다시 1번 음식이 무지 앞으로 온다.
	//음식 하나를 1초 동안 섭취한 후 남은 음식은 그대로 두고 다음 음식을 섭취한다.
	//회전판이 다음 음식을 무지 앞으로 가져오는데 걸리는 시간은 없다고 가정

	//무지가 먹방을 시작한지 K 초 후에 네트워크 장애로 방송이 중단
	//네트워크 정상화 후 다시 방송을 이어갈 때, 몇 번 음식부터 섭취해야 하는지 알고자 한다.
	//더 섭취해야할 음식이 없다면 -1을 반환

	public static int solution(int[] food_times, long k) {

		long sumTime = 0;

		for (int i = 0; i < food_times.length; i++) {
			sumTime += food_times[i];
		}

		// 음식의 총 섭취량이 k 보다 작으면 -1
		if (sumTime <= k) {
			return -1;
		}

		// (음식 시간, 순서) 쌍으로 우선순위 큐에 저장
		PriorityQueue<Food> pq = new PriorityQueue<>();
		for (int i = 0; i < food_times.length; i++) {
			pq.offer(new Food(food_times[i], i + 1));
		}

		long total = 0;   // 먹기 위해 사용한 시간
		long previous = 0;  // 직전에 다 먹은 음식 시간
		long length = food_times.length;    // 남은 음식 개수

		// 음식을 다 먹은 시간과 앞으로 남은 음식을 먹을 시간이 K보다 작거나 같다면, 현재 음식을 먹을 수 있다.
		//summary + (현재의 음식 시간 - 이전 음식 시간) * 현재 음식개수와 k 비교
		while (total + ((pq.peek().time - previous) * length) <= k) {
			int now = pq.poll().time;
			total += (now - previous) * length;
			length -= 1;
			previous = now;
		}

		ArrayList<Food> result = new ArrayList<>();
		while (!pq.isEmpty()) {
			result.add(pq.poll());
		}

		result.sort(Comparator.comparingInt(a -> a.idx));

		return result.get((int)((k - total) % length)).idx;
	}

	private static class Food implements Comparable<Food> {
		int time, idx;

		public Food(int time, int idx) {
			this.time = time;
			this.idx = idx;
		}

		@Override
		public int compareTo(Food o) {
			return Integer.compare(this.time, o.time);
		}
	}

	public static void main(String[] args) {
		System.out.println(solution(new int[] {3, 1, 2}, 5));
	}
}
