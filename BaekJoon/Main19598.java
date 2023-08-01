package baekjoon.ready;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main19598 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<Pair> list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			list.add(new Pair(start, end));
		}

		list.sort((o1, o2) -> {
			if (o1.start == o2.start) {
				return o1.end - o2.end;
			}
			return o1.start - o2.start;
		});

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add(list.get(0).end);

		for (int i = 1; i < N; i++) {
			if (pq.peek() <= list.get(i).start) {
				pq.poll();
			}
			pq.add(list.get(i).end);
		}

		System.out.println(pq.size());
	}

	private static class Pair {
		int start;
		int end;

		public Pair(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
}
