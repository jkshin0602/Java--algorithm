package baekjoon.트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main11725 {

	static int N;
	static ArrayList<Integer>[] g;
	static int[] parent;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		input();
		go();
		System.out.println(sb);
	}

	private static void go() {
		dfs(1, -1);
		for (int i = 2; i <= N; i++) {
			sb.append(parent[i]).append('\n');
		}
	}

	private static void dfs(int x, int par) {
		for (Integer y : g[x]) {
			if (y == par)
				continue;
			parent[y] = x;
			dfs(y, x);
		}
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		g = new ArrayList[N + 1];
		parent = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			g[i] = new ArrayList<>();
		}
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			g[a].add(b);
			g[b].add(a);
		}
	}
}
