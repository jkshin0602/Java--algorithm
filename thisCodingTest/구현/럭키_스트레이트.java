package book.nadongbin.문제.구현;

public class 럭키_스트레이트 {

	//게임 내 점수가 특정 조건을 만족할 때 기술 사용 가능
	//현재 캐릭터의 점수가 N일때, 자릿수를 기준으로 점수 N을 반으로 나누어 왼쪽 부분의 각 자릿수 합과
	//오른쪽 부분의 각 자릿수의 합을 더한 값이 동일한 상황일 때 기술 사용 가능
	//자릿수는 항상 짝수

	public static String solution(int N) {
		String s = String.valueOf(N);
		int len = s.length() / 2;

		int a = 0;
		for (int i = 0; i < len; i++) {
			a += s.charAt(i) - '0';
		}

		int b = 0;
		for (int i = len; i < s.length(); i++) {
			b += s.charAt(i) - '0';
		}

		return a == b ? "LUCKY" : "READY";
	}

	public static void main(String[] args) {
		System.out.println(solution(123402));
		System.out.println(solution(7755));
		System.out.println(solution(99_999_999));
	}
}
