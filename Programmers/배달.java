package programmers;

import java.util.Comparator;
import java.util.PriorityQueue;

public class 배달 {

	public static int solution(int N, int[][] road, int K) {
		int[] map = dijkstra(N, road, 1);

		int ans = 0;

		for (int x : map) {
			if (x <= K) {
				ans++;
			}
		}

		return ans;
	}

	private static int[] dijkstra(int N, int[][] road, int start) {
		int[] map = new int[N + 1];
		for (int i = 0; i < N + 1; i++) {
			map[i] = 500_001;
		}
		map[start] = 0;

		PriorityQueue<Pair> q = new PriorityQueue<>(Comparator.comparingInt(o -> o.distance));
		q.add(new Pair(start, 0));

		while (!q.isEmpty()) {
			Pair p = q.poll();

			int distance = p.distance;
			int currentTown = p.town;

			if (distance > map[currentTown]) {
				continue;
			}

			for (int i = 0; i < road.length; i++) {
				int nextDistance;
				int nextTown;
				if (road[i][0] == currentTown) {
					nextDistance = distance + road[i][2];
					nextTown = road[i][1];
					if (nextDistance < map[nextTown]) {
						map[nextTown] = nextDistance;
						q.add(new Pair(nextTown, nextDistance));
					}
				} else if (road[i][1] == currentTown) {
					nextDistance = road[i][2] + distance;
					nextTown = road[i][0];
					if (nextDistance < map[nextTown]) {
						map[nextTown] = nextDistance;
						q.add(new Pair(nextTown, nextDistance));
					}
				}
			}
		}

		return map;
	}

	private static class Pair {
		int town;
		int distance;

		public Pair(int town, int distance) {
			this.town = town;
			this.distance = distance;
		}

	}

	public static void main(String[] args) {
		System.out.println(
			solution(5, new int[][] {{1, 2, 1}, {2, 3, 3}, {5, 2, 2}, {1, 4, 2}, {5, 3, 1}, {5, 4, 2}}, 3));
		System.out.println(
			solution(6, new int[][] {{1, 2, 1}, {1, 3, 2}, {2, 3, 2}, {3, 4, 3}, {3, 5, 2}, {3, 5, 3}, {5, 6, 1}}, 4));
	}
}
