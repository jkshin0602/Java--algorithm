package programmers;

import java.util.Comparator;
import java.util.PriorityQueue;

public class 호텔_대실 {

	public static int solution(String[][] book_time) {
		PriorityQueue<Pair> pq1 = new PriorityQueue<>((o1, o2) -> {
			if (o1.start == o2.start) {
				return o1.end - o2.end;
			}
			return o1.start - o2.start;
		});

		for (String[] s : book_time) {
			pq1.add(new Pair(s[0], s[1]));
		}

		PriorityQueue<Pair> pq2 = new PriorityQueue<>(Comparator.comparingInt(o -> o.end));
		pq2.add(pq1.poll());

		while (!pq1.isEmpty()) {
			Pair p1 = pq1.poll();
			Pair p2 = pq2.peek();
			if (p2.end <= p1.start) {
				pq2.poll();
			}
			pq2.add(p1);

		}

		return pq2.size();
	}

	private static class Pair {
		int start, end;

		public Pair(String start, String end) {
			this.start = Integer.parseInt(start.split(":")[0]) * 60 + Integer.parseInt(start.split(":")[1]);
			this.end = Integer.parseInt(end.split(":")[0]) * 60 + Integer.parseInt(end.split(":")[1]) + 10;
		}

	}

	public static void main(String[] args) {
		System.out.println(solution(
			new String[][] {{"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"}, {"14:10", "19:20"},
				{"18:20", "21:20"}}));
		System.out.println(solution(new String[][] {{"09:10", "10:10"}, {"10:20", "12:20"}}));
		System.out.println(solution(new String[][] {{"10:20", "12:30"}, {"10:20", "12:30"}, {"10:20", "12:30"}}));

	}

}
