package programmers;

public class 다음큰숫자 {

	//1. n의 다음 큰 숫자는 n보다 큰 자연수
	//2. n의 다음 큰 숫자와 n은 2진수로 변환했을 때의 1의 갯수가 같다.
	//3. n의 다음 큰 숫자는 조건 1, 2,를 만족하는 수 중 가장 작은 수
	// 78(1001110) 1 = 4개 0 3개
	// 83(1010011) 1 = 4개 0 3개

	public static int solution(int n) {
		int count = Integer.bitCount(n);

		return findNextBiggerNumber(count, n);
	}

	private static int findNextBiggerNumber(int count, int n) {
		while (true) {
			n++;
			int binaryCount = Integer.bitCount(n);

			if (binaryCount == count) {
				return n;
			}
		}
	}

	public static void main(String[] args) {
		System.out.println(solution(78));
		System.out.println(solution(15));
	}

}
