package baekjoon.DFS와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main1697 {

	static int N, K;
	static int[] dx = {-1, 1, 2};
	static int[] cnt;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		input();
		bfs();
		System.out.println(cnt[K]);
	}

	private static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.add(N);
		cnt[N] = 0;
		visited[N] = true;

		while (!q.isEmpty()) {
			int x = q.poll();
			for (int i = 0; i < 3; i++) {
				int nx = x + dx[i];
				if (i == 2)
					nx = x * dx[i];
				if (nx < 0 || nx > 100_000 || visited[nx])
					continue;
				cnt[nx] = cnt[x] + 1;
				visited[nx] = true;
				q.add(nx);
			}
		}
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		cnt = new int[100_005];
		visited = new boolean[100_005];
	}

}