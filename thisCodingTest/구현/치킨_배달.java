package book.nadongbin.문제.구현;

import java.util.ArrayList;
import java.util.List;

public class 치킨_배달 {

	//치킨 거리 : 집에서 가장 가까운 치킨집 사이의 거리
	//각각의 집은 치킨 거리를 가지고 있고, 도시의 치킨 거리는 모든 치킨 거리의 합
	//0 : 빈칸, 1: 집, 2: 치킨집
	//치킨집의 개수를 M개 빼고 폐업 시켜야 한다.
	//도시의 치킨 거리가 가장 작게

	public static int solution(int N, int M, int[][] info) {

		List<Pair> chickenList = new ArrayList<>();
		List<Pair> homeList = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (info[i][j] == 1) {
					homeList.add(new Pair(i, j));
				} else if (info[i][j] == 2) {
					chickenList.add(new Pair(i, j));
				}
			}
		}

		return go(chickenList, homeList, M, new boolean[chickenList.size()], 0, 0);
	}

	private static int go(List<Pair> chickenList, List<Pair> homeList, int M, boolean[] visited, int count, int idx) {
		int result = Integer.MAX_VALUE;

		if (count == M) {
			result = Math.min(result, sumChickenDistance(chickenList, homeList, visited));
		}

		for (int i = idx; i < chickenList.size(); i++) {
			if (visited[i]) {
				continue;
			}

			visited[i] = true;
			result = Math.min(result, go(chickenList, homeList, M, visited, count + 1, i + 1));
			visited[i] = false;
		}

		return result;
	}

	private static int sumChickenDistance(List<Pair> chickenList, List<Pair> homeList,
		boolean[] visited) {

		int result = 0;

		for (Pair home : homeList) {
			int chickenDistance = Integer.MAX_VALUE;

			for (int i = 0; i < chickenList.size(); i++) {
				if (!visited[i]) {
					continue;
				}

				Pair chicken = chickenList.get(i);
				int tmp = Math.abs(home.y - chicken.y) + Math.abs(home.x - chicken.x);
				chickenDistance = Math.min(chickenDistance, tmp);
			}

			result += chickenDistance;
		}

		return result;
	}

	private static class Pair {
		int y, x;

		public Pair(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	public static void main(String[] args) {
		System.out.println(solution(5, 3,
			new int[][] {{0, 0, 1, 0, 0}, {0, 0, 2, 0, 1}, {0, 1, 2, 0, 0}, {0, 0, 1, 0, 0}, {0, 0, 0, 0, 2}}));
		System.out.println(solution(5, 2,
			new int[][] {{0, 2, 0, 1, 0}, {1, 0, 1, 0, 0}, {0, 0, 0, 0, 0}, {2, 0, 0, 1, 1}, {2, 2, 0, 1, 2}}));
		System.out.println(solution(5, 1,
			new int[][] {{1, 2, 0, 0, 0}, {1, 2, 0, 0, 0}, {1, 2, 0, 0, 0}, {1, 2, 0, 0, 0}, {1, 2, 0, 0, 0}}));
		System.out.println(solution(5, 1,
			new int[][] {{1, 2, 0, 2, 1}, {1, 2, 0, 2, 1}, {1, 2, 0, 2, 1}, {1, 2, 0, 2, 1}, {1, 2, 0, 2, 1}}));

	}
}


