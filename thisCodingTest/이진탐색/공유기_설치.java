package book.nadongbin.문제.이진탐색;

import java.util.Arrays;

public class 공유기_설치 {

	//가장 인접한 두 공유기 사이의 거리를 최대로 하는 프로그램

	public static int solution(int N, int C, int[] maps) {
		Arrays.sort(maps);

		int left = 1;
		int right = maps[N - 1];
		int result = 0;

		while (left <= right) {
			int mid = (left + right) / 2;
			int value = maps[0];
			int count = 1;

			for (int i = 1; i < N; i++) {
				if (maps[i] >= value + mid) {
					value = maps[i];
					count++;
				}
			}

			if (count >= C) {
				left = mid + 1;
				result = mid;
			} else {
				right = mid - 1;
			}
		}

		return result;
	}

	public static void main(String[] args) {
		System.out.println(solution(5, 3, new int[] {1, 2, 8, 4, 9}));
	}

	// 1 2 4 8 9
	// 최대값 : 9
	// 최소값 : 1
	// 공유기 개수 : 3

}
