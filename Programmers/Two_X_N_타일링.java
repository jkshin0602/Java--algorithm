package programmers;

public class Two_X_N_타일링 {

	//D[i] = 가로 길이갸 i 일때 타일 배치 경우의수
	//D[i] = D[i-1] + D[i-2]
	//D[i] = i-1번째에는 타일 세로 배치만 가능, i-2 번째에는 타일 가로 배치만 가능

	private static int[] D;

	public static int solution(int n) {
		D = new int[60_001];
		D[1] = 1;
		D[2] = 2;

		for (int i = 3; i <= n; i++) {
			D[i] = (D[i - 1] + D[i - 2]) % 1_000_000_007;
		}

		return D[n];
	}

	public static void main(String[] args) {
		System.out.println(solution(4));
	}

}
