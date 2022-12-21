package programmers;

import java.util.Arrays;

public class 과일장수 {

	// 사과점수 1 ~ k 점
	// 사과 m 개씩 담아서 포장
	// 최저 사과점수 x 상자에 담긴 사과의 개수 x 상자의 개수

	public static int solution(int k, int m, int[] score) {
		Arrays.sort(score);
		int maxBoxLength = score.length / m;
		int[] box = new int[maxBoxLength];
		int idx = 0;
		int min = 10;
		for (int i = score.length - 1; i >= m - 1; i -= m) {
			for (int j = i; j > i - m; j--) {
				min = Math.min(min, score[j]);
			}
			box[idx++] = min * m;
		}

		return Arrays.stream(box).sum();
	}

	public static void main(String[] args) {
		System.out.println(solution(3, 4, new int[] {1, 2, 3, 1, 2, 3, 1}));
		System.out.println(solution(4, 3, new int[] {4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2}));
	}

}
