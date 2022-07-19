package baekjoon.그리디;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main11000 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		Pair[] a = new Pair[N];
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			a[i] = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(a);

		pq.add(a[0].e);
		for (int i = 1; i < N; i++) {
			if (pq.peek() <= a[i].s) {
				pq.poll();
			}
			pq.add(a[i].e);
		}
		System.out.println(pq.size());
	}

	private static class Pair implements Comparable<Pair> {
		int s, e;

		public Pair(int s, int e) {
			this.s = s;
			this.e = e;
		}

		@Override
		public int compareTo(Pair o) {
			if (this.s != o.s) {
				return this.s - o.s;
			}
			return this.e - o.e;
		}
	}
}
