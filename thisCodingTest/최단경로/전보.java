package book.nadongbin.최단경로;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 전보 {

	private static int[] distances;
	private static final int INF = (int)1e9;

	public static int[] solution(int N, int C, String[] infos) {
		ArrayList<Pair>[] graph = init(N, infos);
		dijkstra(C, graph);

		int count = 0;
		int max = 0;
		for (int d : distances) {
			if (d != INF) {
				count++;
				max = Math.max(max, d);
			}
		}

		return new int[] {count-1, max};
	}

	private static void dijkstra(int start, ArrayList<Pair>[] graph) {
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		pq.add(new Pair(start, 0));
		distances[start] = 0;

		while (!pq.isEmpty()) {
			Pair p = pq.poll();
			int d = p.d;
			int now = p.y;

			if (distances[now] < d) {
				continue;
			}

			for (Pair pair : graph[now]) {
				int cost = d + pair.d;
				if (cost < distances[pair.y]) {
					distances[pair.y] = cost;
					pq.add(new Pair(pair.y, pair.d));
				}
			}
		}
	}

	private static ArrayList<Pair>[] init(int N, String[] infos) {
		ArrayList<Pair>[] graph = new ArrayList[N + 1];
		distances = new int[N + 1];

		Arrays.fill(distances, INF);

		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		StringTokenizer st;
		for (String info : infos) {
			st = new StringTokenizer(info);
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			graph[x].add(new Pair(y, d));
		}

		return graph;
	}

	private static class Pair implements Comparable<Pair> {
		int y, d;

		public Pair(int y, int d) {
			this.y = y;
			this.d = d;
		}

		@Override
		public int compareTo(Pair o) {
			return this.d - o.d;
		}
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(3, 1, new String[] {"1 2 4", "1 3 2"})));
	}
}
