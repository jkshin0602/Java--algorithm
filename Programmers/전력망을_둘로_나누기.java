package programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 전력망을_둘로_나누기 {

	//n개의 송전탑이 전선을 통해 하나의 트리 형태로 연결
	//이 전선들 중 하나를 끊어서 전력망 네트워크를 2개로 분할
	//두 전력망이 갖게 되는 송전탑의 개수를 최대한 비슷하게
	//2 <= n <= 100

	public static int solution(int n, int[][] wires) {
		ArrayList<Integer>[] map = init(n, wires);

		return go(wires, map, n);
	}

	private static int go(int[][] wires, ArrayList<Integer>[] map, int n) {
		boolean[] cutOff = new boolean[n + 1];
		int ans = Integer.MAX_VALUE;

		for (int i = 0; i < wires.length; i++) {
			int x = wires[i][0];
			int y = wires[i][1];
			cutOff[x] = true;
			cutOff[y] = true;
			ans = Math.min(ans, bfs(map, cutOff));
			cutOff[x] = false;
			cutOff[y] = false;
		}

		return ans;
	}

	private static int bfs(ArrayList<Integer>[] map, boolean[] cutOff) {
		Queue<Integer> q = new LinkedList<>();
		boolean[] isVisit1 = new boolean[map.length];
		boolean[] isVisit2 = new boolean[map.length];

		int check = 0;
		for (int i = 1; i <= cutOff.length; i++) {
			if (cutOff[i]) {
				q.add(i);
				check = i;
				isVisit1[i] = true;
				break;
			}
		}
		setVisit(map, cutOff, q, isVisit1);

		q = new LinkedList<>();
		for (int i = 1; i <= cutOff.length; i++) {
			if (cutOff[i] && i != check) {
				q.add(i);
				isVisit2[i] = true;
				break;
			}
		}
		setVisit(map, cutOff, q, isVisit2);

		return Math.abs(getCount(isVisit1) - getCount(isVisit2));
	}

	private static void setVisit(ArrayList<Integer>[] map, boolean[] cutOff, Queue<Integer> q, boolean[] isVisit) {
		while (!q.isEmpty()) {
			int x = q.poll();

			for (int num : map[x]) {
				if (!isVisit[num] && !cutOff[num]) {
					q.add(num);
					isVisit[num] = true;
				}
			}
		}
	}

	private static int getCount(boolean[] isVisit) {
		int count = 0;

		for (int i = 1; i < isVisit.length; i++) {
			if (isVisit[i]) {
				count++;
			}
		}

		return count;
	}

	private static ArrayList<Integer>[] init(int n, int[][] wires) {
		ArrayList<Integer>[] map = new ArrayList[n + 1];

		for (int i = 1; i <= n; i++) {
			map[i] = new ArrayList<>();
		}

		for (int[] wire : wires) {
			int x = wire[0];
			int y = wire[1];
			map[x].add(y);
			map[y].add(x);
		}

		return map;
	}

	public static void main(String[] args) {
		System.out.println(solution(9, new int[][] {{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}}));
		System.out.println(solution(4, new int[][] {{1, 2}, {2, 3}, {3, 4}}));
		System.out.println(solution(7, new int[][] {{1, 2}, {2, 7}, {3, 7}, {3, 4}, {4, 5}, {6, 7}}));
	}
}
