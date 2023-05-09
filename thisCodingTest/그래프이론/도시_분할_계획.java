package book.nadongbin.그래프이론;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class 도시_분할_계획 {

	public static int solution(int N, String[] infos) {
		int[] parent = new int[N + 1];
		List<Edge> list = new ArrayList<>();
		int ans = 0;

		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}

		for (String info : infos) {
			StringTokenizer st = new StringTokenizer(info);
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			list.add(new Edge(a, b, d));
		}

		list.sort(Comparator.comparingInt(o -> o.d));
		int last = 0; // MST에 포함되는 간선 중 가장 비용이 큰 간선

		for (Edge edge : list) {
			int cost = edge.d;
			int a = edge.from;
			int b = edge.to;
			if (findParent(parent, a) != findParent(parent, b)) {
				unionParent(parent, a, b);
				ans += cost;
				last = cost;
			}
		}

		return ans - last;
	}

	private static void unionParent(int[] parent, int a, int b) {
		a = findParent(parent, a);
		b = findParent(parent, b);

		if (a < b) {
			parent[b] = a;
			return;
		}
		parent[a] = b;
	}

	private static int findParent(int[] parent, int x) {
		if (parent[x] != x) {
			parent[x] = findParent(parent, parent[x]);
		}
		return parent[x];
	}

	private static class Edge {
		int from, to, d;

		public Edge(int from, int to, int d) {
			this.from = from;
			this.to = to;
			this.d = d;
		}

	}

	public static void main(String[] args) {
		System.out.println(solution(7,
			new String[] {
				"1 2 3", "1 3 2", "3 2 1", "2 5 2", "3 4 4", "7 3 6",
				"5 1 5", "1 6 2", "6 4 1", "6 5 3", "4 5 3", "6 7 4"
			}));
	}
}
