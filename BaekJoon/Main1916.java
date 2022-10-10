package baekjoon.다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main1916 {

	static int N, M, S, E;
	static int[] dist;
	static ArrayList<Edge>[] edges;

	private static void dijkstra(int start) {
		for (int i = 1; i <= N; i++)
			dist[i] = Integer.MAX_VALUE;

		PriorityQueue<Info> pq = new PriorityQueue<>(Comparator.comparing(o -> o.dist));

		pq.add(new Info(start, 0));
		dist[start] = 0;

		while (!pq.isEmpty()) {
			Info info = pq.poll();

			if (dist[info.idx] < info.dist)
				continue;

			for (Edge e : edges[info.idx]) {
				if (dist[info.idx] + e.weight >= dist[e.to])
					continue;

				dist[e.to] = dist[info.idx] + e.weight;
				pq.add(new Info(e.to, dist[e.to]));
			}
		}
	}

	public static void main(String[] args) throws Exception {
		input();
		dijkstra(S);
		System.out.println(dist[E]);
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		edges = new ArrayList[N + 1];
		dist = new int[N + 1];
		for (int i = 1; i <= N; i++)
			edges[i] = new ArrayList<>();

		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			edges[from].add(new Edge(to, weight));
		}

		st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
	}

	private static class Edge {
		int to, weight;

		public Edge(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
	}

	private static class Info {
		int idx, dist;

		public Info(int idx, int dist) {
			this.idx = idx;
			this.dist = dist;
		}
	}
}

