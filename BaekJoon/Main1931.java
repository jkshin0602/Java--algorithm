package baekjoon.ready;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main1931 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		PriorityQueue<Pair> pq = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			pq.add(new Pair(start, end));
		}

		int endTime = 0;
		int answer = 0;

		while (!pq.isEmpty()) {
			Pair p = pq.poll();
			if (endTime <= p.start) {
				endTime = p.end;
				answer++;
			}
		}

		System.out.println(answer);
	}

	private static class Pair implements Comparable<Pair> {
		int start, end;

		public Pair(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Pair o) {
			if (this.end == o.end) {
				return this.start - o.start;
			}

			return this.end - o.end;
		}
	}
}
