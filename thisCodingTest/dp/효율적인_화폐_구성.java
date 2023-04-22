package book.nadongbin.dp;

import java.util.Arrays;

public class 효율적인_화폐_구성 {

	//D[i] = i원을 구성하는 최소한의 화폐 개수
	//D[i-k]를 만들 수 있는 경우 = min(D[i], D[i-k] + 1)
	//D[i-k]를 만들 수 없는 경우 = -1

	public static int solution(int[] N, int M) {
		int[] D = new int[10_001];
		Arrays.fill(D, 10001);

		D[0] = 0;
		for (int i = 0; i < N.length; i++) {
			for (int j = N[i]; j <= M; j++) {
				// (i - k)원을 만드는 방법이 존재하는 경우
				if (D[j - N[i]] != 10001) {
					D[j] = Math.min(D[j], D[j - N[i]] + 1);
				}
			}
		}

		if (D[M] == 10001) { // 최종적으로 M원을 만드는 방법이 없는 경우
			return -1;
		}
		return D[M];
	}

	public static void main(String[] args) {
		System.out.println(solution(new int[] {2, 3}, 15));
		System.out.println(solution(new int[] {3, 5, 7}, 4));
	}
}
