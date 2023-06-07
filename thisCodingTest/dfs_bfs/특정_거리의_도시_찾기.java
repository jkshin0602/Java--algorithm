package book.nadongbin.문제.BFS_DFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 특정_거리의_도시_찾기 {

	private static String solution(int N, int M, int K, int X, String[] info) {
		ArrayList<Integer>[] map = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) {
			map[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(info[i]);
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x].add(y);
		}

		int[] result = bfs(map, X);

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			if (result[i] == K) {
				sb.append(i).append('\n');
			}
		}

		return sb.length() == 0 ? "-1" : sb.toString();
	}

	private static int[] bfs(ArrayList<Integer>[] map, int start) {
		Queue<Integer> q = new LinkedList<>();
		int[] result = new int[map.length];
		boolean[] visited = new boolean[map.length];

		visited[start] = true;
		q.add(start);

		while (!q.isEmpty()) {
			int p = q.poll();

			for (Integer x : map[p]) {
				if (visited[x]) {
					continue;
				}

				q.add(x);
				visited[x] = true;
				result[x] = result[p] + 1;
			}
		}

		return result;
	}

	public static void main(String[] args) {
		System.out.println(solution(4, 4, 2, 1, new String[] {"1 2", "1 3", "2 3", "2 4"}));
		System.out.println();
		System.out.println(solution(4, 3, 2, 1, new String[] {"1 2", "1 3", "1 4"}));
		System.out.println();
		System.out.println(solution(4, 4, 1, 1, new String[] {"1 2", "1 3", "2 3", "2 4"}));
	}
}
