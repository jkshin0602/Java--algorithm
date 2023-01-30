package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class 프린터 {

	//1. 인쇄 대기목록의 가장 앞에 있는 문저 J를 대기목록에서 꺼낸다.
	//2. 나머지 인쇄 대기목록에서 J보다 중요도가 높은 문서가 한 개라도 존재하면, J를 대기목록의 가장 마지막에 넣는다.
	//3. 그렇지 않으면 J를 인쇄한다.

	public static int solution(int[] priorities, int location) {
		Queue<Pair> q = init(priorities, location);

		int answer = 0;
		int order = 0;
		while (!q.isEmpty()) {
			Pair poll = q.poll();
			boolean state = false;

			for (Pair p : q) {
				if (poll.value < p.value) {
					state = true;
					break;
				}
			}

			if (state) {
				q.offer(poll);
				continue;
			}

			order++;

			if (poll.location) {
				answer = order;
			}
		}

		return answer;
	}

	private static Queue<Pair> init(int[] priorities, int location) {
		Queue<Pair> q = new LinkedList<>();

		for (int i = 0; i < priorities.length; i++) {
			boolean state = false;
			if (i == location) {
				state = true;
			}
			q.offer(new Pair(priorities[i], state));
		}

		return q;
	}

	private static class Pair {
		int value;
		boolean location;

		public Pair(int value, boolean location) {
			this.value = value;
			this.location = location;
		}
	}

	public static void main(String[] args) {
		System.out.println(solution(new int[] {2, 1, 3, 2}, 2));
		System.out.println(solution(new int[] {1, 1, 9, 1, 1, 1}, 0));
	}
}
