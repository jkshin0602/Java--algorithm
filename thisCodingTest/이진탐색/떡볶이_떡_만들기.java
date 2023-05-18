package book.nadongbin.이진탐색;

import java.util.Arrays;

public class 떡볶이_떡_만들기 {

	public static int solution(int[] N, int M) {
		Arrays.sort(N);

		return binarySearch(N, M);

	}

	private static int binarySearch(int[] N, int target) {
		int left = 1;
		int right = N[N.length - 1];
		int max = 0;
		while (left <= right) {
			int mid = (left + right) / 2;
			int total = 0;
			for (int i = 0; i < N.length; i++) {
				if (N[i] > mid) {
					total += N[i] - mid;
				}
			}

			// 떡의 양이 부족한 경우, 높이를 낮추면 떡의 양이 증가된다.
			if (total < target) {
				right = mid - 1;
			} else { //떡의 양이 충분한 경우, 덜 자른다.
				max = mid;
				left = mid + 1;
			}
		}

		return max;
	}

	public static void main(String[] args) {
		System.out.println(solution(new int[] {19, 15, 10, 17}, 6));
	}
}


