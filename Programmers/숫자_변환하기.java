package programmers;

public class 숫자_변환하기 {
	public static final int MAX_VALUE = Integer.MAX_VALUE;

	//자연수 x -> y 변환
	//가능한 연산
	//1. x + n
	//2. x * 2
	//3. x * 3
	//최소 연산 횟수 반환
	//x -> y 가 불가능할 시 -1

	//1 <= x <= y <= 1,000,000
	//1 <= n < y

	//D[i] = x로 i로 만드는 최소 연산 횟수
	//if(i/2 == 0 && x <= i/2) D[i/2] 할당
	//if(i/3 == 0 && x <= i/3) D[i/3] 할당
	//if(x <= i - n) D[i-n] 할당
	//D[i] = min(D[i/2], D[i/3], D[i-n]) + 1

	private static int[] D;

	public static int solution(int x, int y, int n) {
		D = new int[y + 1];

		for (int i = x + 1; i <= y; i++) {

			int a = i / 2 > 0 && i % 2 == 0 && x <= i / 2 ? D[i / 2] : MAX_VALUE;
			int b = i / 3 > 0 && i % 3 == 0 && x <= i / 3 ? D[i / 3] : MAX_VALUE;
			int c = x <= i - n ? D[i - n] : MAX_VALUE;
			int d = Math.min(a, Math.min(b, c));

			D[i] = d < MAX_VALUE ? d + 1 : MAX_VALUE;
		}

		return D[y] < MAX_VALUE ? D[y] : -1;
	}

	public static void main(String[] args) {
		System.out.println(solution(10, 40, 5));
		System.out.println(solution(10, 40, 30));
		System.out.println(solution(2, 5, 4));
		// System.out.println(solution(1, 1_000_000, 1));
	}
}
