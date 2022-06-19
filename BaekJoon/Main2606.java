package baekjoon.DFS와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/2606
public class Main2606 {

	static int C, M;
	static ArrayList<Integer> list[];
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		input();
		DFS(1);
		int ans = -1;
		for (int i = 1; i <= C; i++) {
			if (visited[i])
				ans++;
		}
		System.out.println(ans);
	}

	private static void DFS(int start) {
		visited[start] = true;
		for (Integer a : list[start]) {
			if (visited[a])
				continue;
			DFS(a);
		}
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		C = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		list = new ArrayList[C + 1];
		visited = new boolean[C + 1];
		for (int i = 1; i <= C; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
	}

}
