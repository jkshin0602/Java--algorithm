package baekjoon.위상정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Main1005 {

	static int T, N, K, W;
	static int[] indeg;
	static int[] time, done;
	static ArrayList<Integer>[] g;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		while (T-- > 0) {
			input(br);
			go();
		}
		System.out.println(sb);
	}

	private static void go() {
		// 제일 앞에 정렬될 수 있는 정점 찾기
		Deque<Integer> q = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			if (indeg[i] == 0) {
				q.add(i);
				done[i] = time[i];
			}
		}
		// 정렬될 수 있는 정점이 있다면?
		// 1. 정렬 결과에 추가하기
		// 2. 정점과 연결된 간선 제거하기
		// 3. 새롭게 정렬 될 수 있는 정점
		while (!q.isEmpty()) {
			int x = q.poll();
			for (int y : g[x]) {
				indeg[y]--;
				if (indeg[y] == 0)
					q.add(y);
				done[y] = Math.max(done[y], done[x] + time[y]);
			}
		}
		sb.append(done[W]).append('\n');
	}

	private static void input(BufferedReader br) throws IOException {
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		g = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			g[i] = new ArrayList<>();
		}
		indeg = new int[N + 1];
		time = new int[N + 1];
		done = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			time[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 1; i <= K; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			g[x].add(y);
			indeg[y]++;
		}
		W = Integer.parseInt(br.readLine());
	}
}
