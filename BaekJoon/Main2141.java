package baekjoon.ready;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main2141 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		long peopleSum = 0;
		long answer = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int idx = Integer.parseInt(st.nextToken());
			int people = Integer.parseInt(st.nextToken());
			pq.add(new Pair(idx, people));
			peopleSum += people;
		}

		long tmp = 0;
		for (int i = 0; i < N; i++) { //제일 왼쪽 마을 부터 탐색
			Pair p = pq.poll();
			tmp += p.people;
			if ((peopleSum + 1) / 2 <= tmp) { //우체국을 세울때 (왼쪽 부분 + 오른쪽 부분)/2 보다 왼쪽 까지 센 부분이 크면 그곳이 우체국을 세울 자리
				answer = p.idx;
				break;
			}
		}

		System.out.println(answer);
	}

	private static class Pair implements Comparable<Pair> {
		int idx, people;

		public Pair(int idx, int people) {
			this.idx = idx;
			this.people = people;
		}

		@Override
		public int compareTo(Pair o) {
			return this.idx - o.idx;
		}
	}
}
