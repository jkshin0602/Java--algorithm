package programmers;

import java.util.Arrays;

public class 소수만들기 {

	private static boolean[] isPrime;

	public static void findPrime(int n) {
		isPrime = new boolean[n + 1];
		Arrays.fill(isPrime, true);

		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (isPrime[i]) {
				for (int j = i * i; j <= n; j += i) {
					isPrime[j] = false;
				}
			}
		}
	}

	public static int solution(int[] nums) {
		findPrime(3000);
		int cnt = 0;
		for (int i = 0; i < nums.length - 2; i++) {
			for (int j = i + 1; j < nums.length - 1; j++) {
				if (i == j)
					continue;
				for (int k = j + 1; k < nums.length; k++) {
					if (i == k || j == k)
						continue;
					int sum = nums[i] + nums[j] + nums[k];
					if (isPrime[sum]) {
						cnt++;
					}
				}
			}
		}
		return cnt;
	}

	public static void main(String[] args) {
		System.out.println(solution(new int[] {1, 2, 3, 4}));
		System.out.println(solution(new int[] {1, 2, 7, 6, 4}));
	}
}
