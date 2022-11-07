package programmers;

import java.util.Arrays;

public class 소수찾기 {

	private static boolean[] isPrime;

	public static int solution(int n) {
		isPrime = new boolean[n + 1];
		Arrays.fill(isPrime, true);

		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (isPrime[i]) {
				for (int j = i * i; j <= n; j += i) {
					isPrime[j] = false;
				}
			}
		}
		int answer = 0;
		for (int i = 2; i <= n; i++) {
			if (isPrime[i])
				answer++;
		}
		return answer;
	}

	public static void main(String[] args) {
		System.out.println(solution(1000000));
		System.out.println(solution(5));
	}

}
