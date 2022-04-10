package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2630 {

	public static int N;
	public static int[][] map;
	public static int white = 0;
	public static int blue = 0;

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
		confetti(0,0,N);
		System.out.println(white);
		System.out.println(blue);
	}

	public static void confetti(int y, int x, int size) {
		if (isCheck2630(y, x, size)) {
			if(map[y][x] == 0){
				white++;
			} else if (map[y][x] == 1) {
				blue++;
			}
			return;
		}

		int nSize = size/2;

		confetti(y, x, nSize);
		confetti(y, x+nSize, nSize);
		confetti(y+nSize, x, nSize);
		confetti(y+nSize, x+nSize, nSize);

		return;
	}

	public static boolean isCheck2630(int y, int x, int size) {
		int val = map[y][x];
		for (int i = y; i < y + size; i++) {
			for (int j = x; j < x + size; j++) {
				if (val != map[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

}