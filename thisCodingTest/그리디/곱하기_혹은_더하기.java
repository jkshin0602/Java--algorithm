package book.nadongbin.문제.그리디;

public class 곱하기_혹은_더하기 {

	//각 자리가 숫자(0~9)로만 이루어진 문자열 S가 주어졌을 때, 왼쪽 부터 오른쪽으로 하나씩 모든 숫자를 확인
	//숫자 사이에 X 혹은 + 연산자를 넣어 결과적으로 만들어질 수 있는 가장 큰 수를 구한다.
	//연산자의 우선순위는 먼저 나오는 연산자가 우선순위가 높다.

	public static int solution(String s) {
		int result = 0;

		for (int i = 0; i < s.length(); i++) {
			int value = s.charAt(i) - '0';

			if (value <= 1 || result <= 1) {
				result += value;
				continue;
			}

			result *= value;
		}

		return result;
	}

	public static void main(String[] args) {
		System.out.println(solution("02984"));
		System.out.println(solution("567"));
	}
}
