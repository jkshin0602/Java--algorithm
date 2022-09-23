package baekjoon.DFS와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main1260 {

	static StringBuilder sb = new StringBuilder();
	static int N, M, V;
	static ArrayList<Integer>[] graph;
	static Queue<Integer> q;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		input();
		go();
		System.out.println(sb);
	}

	private static void go() {
		dfs(V);
		sb.append('\n');
		init();
		bfs(V);
	}

	private static void init() {
		for (int i = 1; i <= N; i++) {
			visited[i] = false;
		}
	}

	private static void dfs(int start) {
		visited[start] = true;
		sb.append(start).append(' ');

		for (Integer a : graph[start]) {
			if (visited[a])
				continue;
			dfs(a);
		}
	}

	private static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();

		q.add(start);
		visited[start] = true;

		while (!q.isEmpty()) {
			Integer a = q.poll();
			sb.append(a).append(' ');

			for (Integer b : graph[a]) {
				if (visited[b])
					continue;
				q.add(b);
				visited[b] = true;
			}
		}
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		graph = new ArrayList[N + 1];
		visited = new boolean[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}
		for (int i = 1; i <= N; i++) {
			Collections.sort(graph[i]);
		}
	}
}



