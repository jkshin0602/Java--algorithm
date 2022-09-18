package baekjoon.DFS와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main2251 {

	static StringBuilder sb = new StringBuilder();
	static boolean[] possible;
	static boolean[][][] visit;
	static int[] Limit;

	public static void main(String[] args) throws Exception {
		input();
		go();
	}

	private static void go() {
		bfs(0, 0, Limit[2]);
		for (int i = 0; i <= Limit[2]; i++) {
			if (possible[i])
				sb.append(i).append(' ');
		}
		System.out.println(sb);
	}

	private static void bfs(int x1, int x2, int x3) {
		Queue<State> q = new LinkedList<>();

		visit[x1][x2][x3] = true;
		q.add(new State(new int[] {x1, x2, x3}));

		while (!q.isEmpty()) {
			State state = q.poll();
			if (state.X[0] == 0)
				possible[state.X[2]] = true;
			for (int from = 0; from < 3; from++) {
				for (int to = 0; to < 3; to++) {
					if (from == to)
						continue;
					State nxt = state.move(from, to, Limit);

					if (!visit[nxt.X[0]][nxt.X[1]][nxt.X[2]]) {
						q.add(nxt);
						visit[nxt.X[0]][nxt.X[1]][nxt.X[2]] = true;
					}
				}
			}
		}

	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Limit = new int[3];
		for (int i = 0; i < 3; i++)
			Limit[i] = Integer.parseInt(st.nextToken());
		visit = new boolean[205][205][205];
		possible = new boolean[205];
	}

	private static class State {
		int[] X;

		public State(int[] X) {
			this.X = new int[3];
			for (int i = 0; i < 3; i++)
				this.X[i] = X[i];
		}

		State move(int from, int to, int[] Limit) {
			//from 물통에서 to 물통으로 물을 옮긴다.
			int[] nX = {X[0], X[1], X[2]};
			if (X[from] + X[to] >= Limit[to]) {
				nX[from] -= Limit[to] - X[to];
				nX[to] = Limit[to];
			} else {
				nX[to] += nX[from];
				nX[from] = 0;
			}
			return new State(nX);
		}
	}
}



