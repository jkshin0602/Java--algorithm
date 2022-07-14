package baekjoon.그리디;

import java.util.*;
import java.io.*;

class Main1931 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			pq.add(new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		int endTime = 0;
		int ans = 0;
		while (!pq.isEmpty()) {
			Pair p = pq.poll();
			if (endTime <= p.s) {
				endTime = p.f;
				ans++;
			}
		}
		System.out.println(ans);

	}

	private static class Pair implements Comparable<Pair> {
		int s, f;

		public Pair(int start, int finish) {
			this.s = start;
			this.f = finish;
		}

		public int compareTo(Pair o1) {
			if (this.f == o1.f) {
				return this.s - o1.s;
			}
			return this.f - o1.f;
		}
	}
}



