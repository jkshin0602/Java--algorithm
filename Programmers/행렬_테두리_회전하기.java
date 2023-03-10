package programmers;

import java.util.Arrays;

public class 행렬_테두리_회전하기 {

	private static int[] answer;
	private static int idx;

	public static int[] solution(int rows, int columns, int[][] queries) {
		int[][] map = init(rows, columns);
		answer = new int[queries.length];
		idx = 0;
		for (int i = 0; i < queries.length; i++) {
			map = getAfterRotateSmaller(map, queries[i]);
		}

		return answer;
	}

	//(x1,y1) ~ (x1,y2), (x1,y2) ~ (x2,y2), (x2,y2) ~ (x2,y1), (x2,y1) ~ (x1,y1)
	private static int[][] getAfterRotateSmaller(int[][] map, int[] query) {

		int x1 = query[0];
		int y1 = query[1];
		int x2 = query[2];
		int y2 = query[3];

		int smaller;

		int tmp = map[x1 + 1][y1];
		smaller = tmp;
		int tmp1;

		for (int i = y1; i <= y2; i++) {
			tmp1 = map[x1][i];
			map[x1][i] = tmp;
			tmp = tmp1;
			smaller = getSmaller(smaller, tmp);
		}

		for (int i = x1 + 1; i <= x2; i++) {
			tmp1 = map[i][y2];
			map[i][y2] = tmp;
			tmp = tmp1;
			smaller = getSmaller(smaller, tmp);

		}

		for (int i = y2 - 1; i >= y1; i--) {
			tmp1 = map[x2][i];
			map[x2][i] = tmp;
			tmp = tmp1;
			smaller = getSmaller(smaller, tmp);

		}

		for (int i = x2 - 1; i >= x1; i--) {
			tmp1 = map[i][y1];
			map[i][y1] = tmp;
			tmp = tmp1;
			smaller = getSmaller(smaller, tmp);
		}
		answer[idx++] = smaller;
		return map;
	}

	private static int getSmaller(int smaller, int tmp) {
		if (smaller > tmp) {
			smaller = tmp;
		}
		return smaller;
	}

	private static int[][] init(int rows, int columns) {
		int[][] map = new int[rows + 1][columns + 1];
		int count = 1;
		for (int i = 1; i <= rows; i++) {
			for (int j = 1; j <= columns; j++) {
				map[i][j] = count++;
			}
		}
		return map;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(6, 6, new int[][] {{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}})));
		System.out.println(
			Arrays.toString(solution(3, 3, new int[][] {{1, 1, 2, 2}, {1, 2, 2, 3}, {2, 1, 3, 2}, {2, 2, 3, 3}})));
		System.out.println(Arrays.toString(solution(100, 97, new int[][] {{1, 1, 100, 97}})));
	}

}

/* init
 *   1  2  3  4  5  6
 *   7  8  9 10 11 12
 *  13 14 15 16 17 18
 *  19 20 21 22 23 24
 *  25 26 27 28 29 30
 *  31 32 33 34 35 36
 * */

// x1,y1,x2,y2
/* 2,2,5,4
 *   1  2  3  4  5  6
 *   7  8  9 10 11 12
 *  13 14 15 16 17 18
 *  19 20 21 22 23 24
 *  25 26 27 28 29 30
 *  31 32 33 34 35 36
 *
 * 변하는 얘들은 (2,2) ~ (2,4), (2,4) ~ (5,4), (5,4) ~ (5,2), (5,2) ~ (2,2)
 * 변하는 얘들은 (x1,y1) ~ (x1,y2), (x1,y2) ~ (x2,y2), (x2,y2) ~ (x2,y1), (x2,y1) ~ (x1,y1)
 *
 * */
