package baekjoon.트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main1068 {

	static int[] leaf;
	static int N, R, root;
	static ArrayList<Integer>[] g;

	public static void main(String[] args) throws Exception {
		input();
		go();
	}

	private static void go() {
		for (int i = 0; i < N; i++) {
			if (g[i].contains(R)) {
				g[i].remove(g[i].indexOf(R));
			}
		}
		if (root != R) {
			dfs(root);
		}
		System.out.println(leaf[root]);
	}

	private static void dfs(int x) {
		if (g[x].isEmpty()) {
			leaf[x] = 1;
		}
		for (int y : g[x]) {
			dfs(y);
			leaf[x] += leaf[y];
		}
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		g = new ArrayList[N];
		leaf = new int[N];
		for (int i = 0; i < N; i++) {
			g[i] = new ArrayList<>();
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int a = Integer.parseInt(st.nextToken());
			if (a == -1) {
				root = i;
				continue;
			}
			g[a].add(i);
		}
		R = Integer.parseInt(br.readLine());
	}
}
