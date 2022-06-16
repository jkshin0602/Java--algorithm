package baekjoon.DFS와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/24479
public class Main24479 {

	static int N, M, R, cnt = 1;

	static ArrayList<Integer> list[];
	static int[] visited;

	public static void main(String[] args) throws Exception {
		input();
		DFS(R);
		for (int i = 1; i <= N; i++) {
			System.out.println(visited[i]);
		}
	}

	private static void DFS(int start) {
		visited[start] = cnt++;
		for (Integer d : list[start]) {
			if (visited[d] > 0)
				continue;
			DFS(d);
		}
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		list = new ArrayList[N + 1];
		visited = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		for (int i = 1; i <= N; i++) {
			list[i].sort(null);
		}
	}

}