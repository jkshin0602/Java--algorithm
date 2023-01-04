package programmers;

public class 피보나치수 {

	public static int solution(int n) {
		int[] D = new int[n + 1];
		D[0] = 0;
		D[1] = 1;
		for (int i = 2; i <= n; i++) {
			D[i] = (D[i - 1] + D[i - 2]) % 1234567;
		}

		return D[n];
	}

	public static void main(String[] args) {
		System.out.println(solution(3));
		System.out.println(solution(5));
	}
}
