package programmers;

import java.util.Arrays;

public class 행렬의곱셈 {

	// ans[0][0] = arr1[0][0] * arr2[0][0] + arr1[0][1] * arr2[1][0]
	// ans[0][1] = arr1[0][0] * arr2[0][1] + arr1[0][1] * arr2[1][1]

	public static int[][] solution(int[][] arr1, int[][] arr2) {

		int[][] answer = new int[arr1.length][arr2[0].length];

		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr2[0].length; j++) {
				for (int k = 0; k < arr2.length; k++) {
					answer[i][j] += arr1[i][k] * arr2[k][j];
				}
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(
			Arrays.deepToString(solution(new int[][] {{1, 4}, {3, 2}, {4, 1}}, new int[][] {{3, 3}, {3, 3}})));
		System.out.println(Arrays.deepToString(
			solution(new int[][] {{2, 3, 2}, {4, 2, 4}, {3, 1, 4}}, new int[][] {{5, 4, 3}, {2, 4, 1}, {3, 1, 1}})));
		System.out.println(Arrays.deepToString(
			solution(new int[][] {{2, 3, 2}, {4, 2, 4}, {3, 1, 4}}, new int[][] {{5, 4}, {2, 4}, {3, 1}})));

	}
}
