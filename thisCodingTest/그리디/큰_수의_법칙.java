package book.nadongbin.그리디;

import java.util.Arrays;

public class 큰_수의_법칙 {

	public static int solution(int N, int M, int K, int[] nums) {
		Arrays.sort(nums);

		return M / K * nums[nums.length - 1] * K
			+ M % K * nums[nums.length - 2];

	}

	public static void main(String[] args) {
		System.out.println(solution(5, 8, 3,
			new int[] {2, 4, 5, 4, 6}));
		System.out.println(solution(5, 7, 2,
			new int[] {3, 4, 3, 4, 3}));
	}
}
