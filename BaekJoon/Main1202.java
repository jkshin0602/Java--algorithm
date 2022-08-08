package baekjoon.그리디;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main1202 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		List<Jewel> j = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			j.add(new Jewel(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		j.sort((o1, o2) -> {
			if (o1.m == o2.m) {
				return o2.v - o1.v;
			}
			return o1.m - o2.m;
		});
		int[] b = new int[K];
		for (int i = 0; i < K; i++) {
			b[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(b);

		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
		long ans = 0;
		int idx = 0;
		for (int i = 0; i < K; i++) {
			while (idx < N && j.get(idx).m <= b[i]) {
				pq.add(j.get(idx++).v);
			}
			if (!pq.isEmpty()) {
				ans += pq.poll();
			}
		}

		System.out.println(ans);
	}

	private static class Jewel {
		int m, v;

		public Jewel(int m, int v) {
			this.m = m;
			this.v = v;
		}
	}

}
