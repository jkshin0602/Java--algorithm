package algospot;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JumpGame {

	public static int N;
	public static int[][] memo;
	public static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int C = Integer.parseInt(st.nextToken());
		while (C-- > 0) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			memo = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					memo[i][j] = -1; //아직 memo x -> -1
				}
			}
			int ans = jump(0, 0);
			if (ans == 1) {
				System.out.println("YES");
			}else{
				System.out.println("NO");
			}

		}
	}

	//시간복잡도 O(N^2)
	//jump(y,x) =
	// false(y>=N or x >=N)
	// true(y=n-1 and x = n-1)
	//jump(y+jumpSize,x) || jump(y,x+jumpSize)

	public static int jump(int y, int x) {
		if (y >= N || x >= N)
			return 0; //false
		if (y == N - 1 && x == N - 1)
			return 1; //true
		if (memo[y][x] != -1)
			return memo[y][x];
		int jumpSize = map[y][x];
		memo[y][x] = atLeastOne(jump(y + jumpSize, x), jump(y, x + jumpSize));
		return memo[y][x];
	}

	public static int atLeastOne(int o1, int o2) {
		if (o1 == 1 || o2 == 1) {
			return 1;
		}
		return 0;
	}

}
