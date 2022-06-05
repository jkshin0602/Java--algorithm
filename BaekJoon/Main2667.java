
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

//단지 번호 붙이기
// https://www.acmicpc.net/problem/2667
public class Main2667 {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static int N, cnt;
	private static List<Integer> ans = new ArrayList<>();
	private static int[] dy = {-1, 0, 1, 0};
	private static int[] dx = {0, 1, 0, -1};
	private static int[][] map;
	private static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < s.length(); j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 0 || visited[i][j]) continue;
				cnt = 1;
				DFS(i, j);
				ans.add(cnt);
			}
		}

		System.out.println(ans.size());
		ans.sort(null);
		for (Integer a : ans) {
			System.out.println(a);
		}

	}

	private static int DFS(int y, int x) {
		visited[y][x] = true;
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if(isMap(ny, nx) || visited[ny][nx] || map[ny][nx] == 0) continue;
			visited[ny][nx] = true;
			cnt++;
			DFS(ny, nx);
		}
		return cnt;
	}

	//BFS

	private static boolean isMap(int ny, int nx) {
		return ny >= N || nx >= N || ny < 0 || nx < 0;
	}

	class Pair{
		int y,x;

		public Pair(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

}
