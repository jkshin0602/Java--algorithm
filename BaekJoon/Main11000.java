package baekjoon.ready;

import java.io.*;
import java.util.*;

class Main11000 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		List<Pair> list = new ArrayList<>(N);

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			list.add(new Pair(start, end));
		}

		Collections.sort(list);
		pq.add(list.get(0).end);

		for (int i = 1; i < N; i++) {
			if (pq.peek() <= list.get(i).start) {
				pq.poll();
			}

			pq.add(list.get(i).end);
		}

		System.out.println(pq.size());
	}

	private static class Pair implements Comparable<Pair> {
		int start;
		int end;

		public Pair(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Pair o) {
			if (this.start == o.start) {
				return this.end - o.end;
			}
			return this.start - o.start;
		}
	}
}
