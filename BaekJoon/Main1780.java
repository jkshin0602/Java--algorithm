package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1780 {

	public static int N;
	public static int[][] map;
	public static int minusOne = 0;
	public static int zero = 0;
	public static int one = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		paper(0, 0, N);
		System.out.println(minusOne);
		System.out.println(zero);
		System.out.println(one);

	}

	public static void paper(int y, int x, int size) {
		if (isCheck1780(y, x, size)) {
			int var = map[y][x];
			if (var == -1) {
				minusOne++;
			} else if (var == 0) {
				zero++;
			} else if (var == 1) {
				one++;
			}
			return;
		}

		int nSize = size / 3;

		paper(y, x, nSize);
		paper(y, x + nSize, nSize);
		paper(y, x + (nSize * 2), nSize);

		paper(y+nSize, x, nSize);
		paper(y+nSize, x + nSize, nSize);
		paper(y+nSize, x + (nSize * 2), nSize);

		paper(y+(nSize*2), x, nSize);
		paper(y+(nSize*2), x + nSize, nSize);
		paper(y+(nSize*2), x + (nSize * 2), nSize);
		return;
	}

	public static boolean isCheck1780(int y, int x, int size) {
		int var = map[y][x];
		for (int i = y; i < y + size; i++) {
			for (int j = x; j < x + size; j++) {
				if (var != map[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

}
