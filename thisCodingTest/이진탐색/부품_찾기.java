package book.nadongbin.이진탐색;

import java.util.Arrays;

public class 부품_찾기 {

	public static String[] solution(int[] N, int[] M) {
		Arrays.sort(N);
		String[] ans = new String[M.length];
		for (int i = 0; i < M.length; i++) {
			ans[i] = binarySearch(N, M[i]);
		}

		return ans;
	}

	private static String binarySearch(int[] N, int target) {
		int left = 0;
		int right = N.length - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (N[mid] == target) {
				return "yes";
			} else if (N[mid] > target) {
				right = mid - 1;
			}else{
				left = mid + 1;
			}
		}
		return "no";
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new int[] {8, 3, 7, 9, 2}, new int[] {5, 7, 9})));
	}
}
