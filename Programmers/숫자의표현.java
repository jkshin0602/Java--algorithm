package programmers;

public class 숫자의표현 {

	public static int solution(int n) {
		int[] sum = new int[n + 1];
		sum[0] = 0;

		for (int i = 1; i <= n; i++) {
			sum[i] = sum[i - 1] + i;
		}

		int count = 0;
		int startIdx = 0;

		for (int i = 1; i <= n; i++) {
			int tmp = sum[i] - sum[startIdx];
			if (tmp == n) {
				count++;
				startIdx++;
				i = startIdx;
			} else if (tmp > n) {
				startIdx++;
				i = startIdx;
			}
		}

		return count;
	}

	public static void main(String[] args) {
		System.out.println(solution(15));

	}
}
