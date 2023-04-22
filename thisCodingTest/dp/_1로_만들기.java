package book.nadongbin.dp;

public class _1로_만들기 {

	//D[x] = X를 1로 만드는 최소 연산
	//D[x] = min(d[x/5], d[x/3], d[x/2], d[x-1])

	private static int[] D;

	public static int solution(int x) {
		D = new int[30_001];
		D[1] = 1;
		D[2] = 1;
		D[3] = 1;
		D[4] = 2;
		D[5] = 1;

		for (int i = 6; i <= x; i++) {
			D[i] = D[i - 1] + 1;

			if (i % 2 == 0) {
				D[i] = Math.min(D[i], D[i / 2] + 1);
			}

			if (i % 3 == 0) {
				D[i] = Math.min(D[i], D[i / 3] + 1);
			}

			if (i % 5 == 0) {
				D[i] = Math.min(D[i], D[i / 5] + 1);
			}

		}

		return D[x];
	}

	public static void main(String[] args) {
		System.out.println(solution(26));
	}
}
