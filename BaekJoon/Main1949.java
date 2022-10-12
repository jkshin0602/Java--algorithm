package baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main1949 {

	static int N;
	static int[] A;
	static ArrayList<Integer>[] g;
	static int[][] D;

	public static void main(String[] args) throws Exception {
		input();
		go();
	}

	//D[i][0] = i를 루트로 하는 subtree에서 root를 선택하지 않고서 가능한 최대 주민수
	//D[i][1] = i를 루트로 하는 subtree에서 root를 선택하고서 가능한 최대 주민수
	//D[parent][0] = 𝝨max(D[child][0], D[child][1])
	//D[parent][1] = 𝝨D[child][0] + A[parent]
	//max(D[1][0], D[1][1]) -> Rooted Tree
	//init : terminal node is small problem

	private static void go() {
		dfs(1, -1);
		System.out.println(Math.max(D[1][0], D[1][1]));
	}

	private static void dfs(int x, int prev) {
		D[x][0] = 0;
		D[x][1] = A[x];

		for (int y : g[x]) {
			if (y == prev)
				continue;
			dfs(y, x);
			D[x][0] += Math.max(D[y][0], D[y][1]);
			D[x][1] += D[y][0];
		}
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		A = new int[N + 1];
		D = new int[N + 1][2];
		g = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			g[i] = new ArrayList<>();
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
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
