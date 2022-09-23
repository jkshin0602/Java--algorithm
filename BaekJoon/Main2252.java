package baekjoon.위상정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Main2252 {

	static int N, M;
	static StringBuilder sb = new StringBuilder();
	static int[] indeg;
	static ArrayList<Integer>[] g;

	public static void main(String[] args) throws Exception {
		input();
		go();

	}

	private static void go() {
		Deque<Integer> q = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			if (indeg[i] == 0)
				q.add(i);
		}
		while (!q.isEmpty()) {
			int x = q.poll();
			sb.append(x).append(' ');
			for (int y : g[x]) {
				indeg[y]--;
				if (indeg[y] == 0)
					q.add(y);
			}
		}
		System.out.println(sb);
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		g = new ArrayList[N + 1];
		indeg = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			g[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			g[x].add(y);
			indeg[y]++;
		}
	}
}
