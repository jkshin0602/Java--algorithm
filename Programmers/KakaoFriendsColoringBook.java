package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class KakaoFriendsColoringBook {

	public static int[] dy = {-1, 0, 1, 0};
	public static int[] dx = {0, 1, 0, -1};

	public static int[] solution(int m, int n, int[][] picture) {
		int[][] tmp = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				tmp[i][j] = picture[i][j];
			}
		}
		int[] answer = new int[2];

		int max = 1;
		int cnt = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (tmp[i][j] != 0) { //0 = 빈공간 또는 방문한곳
					cnt++; //한번 dfs 가 한 영역은 모두 0이된다. - 즉 한번 걸릴때마다 영역을 세준다.
					int num = tmp[i][j]; //같은 숫자를 찾기위함
					tmp[i][j] = 0; // 방문을 나타냄
					max = Math.max(max, bfs(tmp, i, j, num));
				}
			}
		}

		answer[0] = cnt;
		answer[1] = max;
		return answer;
	}

	public static int bfs(int[][] picture, int y, int x, int target) {
		int count = 1; //영역의 넓이를 구하기 위한 변수
		int m = picture.length;
		int n = picture[0].length;
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(y, x));
		while (!q.isEmpty()) {
			Pair pair = q.poll();
			for (int i = 0; i < 4; i++) {
				int ny = pair.y + dy[i];
				int nx = pair.x + dx[i];
				if (ny >= 0 && ny < m && nx >= 0 && nx < n && picture[ny][nx] == target) {
					count++; //다음 갈곳이 타겟이라면 영역의 수를 늘려줌
					picture[ny][nx] = 0; //방문 처리
					q.add(new Pair(ny, nx));
				}
			}
		}
		return count;
	}

	static class Pair {
		int y, x;

		public Pair(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

}
