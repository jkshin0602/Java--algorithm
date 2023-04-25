package book.nadongbin.dp;

public class 바닥공사 {

	//D[i] = 가로의길이가 i 일 때 덮을 수 있는 타일링 경우의 수
	//1x2, 2x1, 2x2 덮개
	//D[i] = D[i-1] + D[i-2] - 1

	public static int solution(int N) {
		int[] D = new int[1001];
		D[1] = 1;
		D[2] = 3;
		D[3] = 5;
		for (int i = 4; i <= N; i++) {
			D[i] = (D[i - 1] + 2 * D[i - 2]) % 796_796;
		}

		return D[N];
	}

	public static void main(String[] args) {
		System.out.println(solution(3));
		System.out.println(solution(100));
		System.out.println(solution(200));
	}
}
