package baekjoon.ready;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main1018 {

	private static char[][] startBlack = {{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
		{'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'}, {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
		{'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'}, {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
		{'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'}, {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
		{'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'}};

	private static char[][] startWhite = {{'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
		{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'}, {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
		{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'}, {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
		{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'}, {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
		{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		char[][] map = new char[N][M];

		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = input.charAt(j);
			}
		}

		int answer = Integer.MAX_VALUE;

		for (int i = 0; i <= N - 8; i++) {
			for (int j = 0; j <= M - 8; j++) {
				answer = Math.min(answer, go(map, i, j));

			}
		}

		System.out.println(answer);
	}

	private static int go(char[][] map, int startRow, int startCol) {
		int changeCount1 = 0;

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (startBlack[i][j] != map[i + startRow][j + startCol]) {
					changeCount1++;
				}
			}
		}

		int changeCount2 = 0;

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (startWhite[i][j] != map[i + startRow][j + startCol]) {
					changeCount2++;
				}
			}
		}

		return Math.min(changeCount1, changeCount2);
	}
}
