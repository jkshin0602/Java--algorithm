package baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main15681 {

	static int N, R, Q;
	static ArrayList<Integer>[] g;
	static int[] D;
	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		input();
		go();
	}

	// D[i] = i를 root로 하는 subtree의 정점 개수 - 트리는 항상 자식노드를 이용할 수 있음
	// D[parent] =  𝝨D[child] + 1
	// -> DFS O(V+E) = O(N)
	private static void go() throws IOException {
		D = new int[N + 1];
		dfs(R, -1);
		for (int i = 1; i <= Q; i++) {
			int q = Integer.parseInt(br.readLine());
			sb.append(D[q]).append('\n');
		}
		System.out.println(sb);
	}

	private static void dfs(int x, int prev) {
		D[x] = 1;
		for (int y : g[x]) {
			if (y == prev)
				continue;
			dfs(y, x);
			D[x] += D[y];
		}
	}

	private static void input() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		g = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) {
			g[i] = new ArrayList<>();
		}
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			g[x].add(y);
			g[y].add(x);
		}
	}

}
