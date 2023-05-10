package book.nadongbin.그래프이론;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 커리큘럼 {

	public static int[] solution(int N, String[] infos) {

		int[] indegree = new int[N + 1];

		ArrayList<Integer>[] graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		int[] time = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(infos[i - 1]);
			int x = Integer.parseInt(st.nextToken());
			time[i] = x;

			while (st.hasMoreElements()) {
				x = Integer.parseInt(st.nextToken());
				if (x == -1)
					break;
				indegree[i] += 1;
				graph[x].add(i);
			}
		}

		return topologySort(graph, indegree, time);

	}

	private static int[] topologySort(ArrayList<Integer>[] graph, int[] indegree, int[] time) {
		int[] result = new int[501];
		for (int i = 1; i < graph.length; i++) {
			result[i] = time[i];
		}

		Queue<Integer> q = new LinkedList<>();

		for (int i = 1; i < graph.length; i++) {
			if (indegree[i] == 0) {
				q.add(i);
			}
		}

		while (!q.isEmpty()) {
			int now = q.poll();

			for (Integer x : graph[now]) {
				result[x] = Math.max(result[x], result[now] + time[x]);
				indegree[x]--;

				if (indegree[x] == 0) {
					q.add(x);
				}
			}
		}

		return Arrays.copyOfRange(result, 1, graph.length);
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(5, new String[] {
			"10 -1", "10 1 -1", "4 1 -1", "4 3 1 -1", "3 3 -1"
		})));
	}
}
