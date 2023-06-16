package book.nadongbin.문제.정렬;

import java.util.Arrays;

public class 안테나 {

	public static int solution(int N, int[] houses) {
		Arrays.sort(houses);

		return houses[(N - 1) / 2];
	}

	public static void main(String[] args) {
		System.out.println(solution(4, new int[] {5, 1, 7, 9}));
	}
}
