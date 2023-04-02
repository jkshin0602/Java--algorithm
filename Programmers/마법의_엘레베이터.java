package programmers;

public class 마법의_엘레베이터 {

	//절대값이 10^x 형태의 정수들이 적힌 버튼이 있다.(-1, 1, -10, 10, -100, 100, ...)
	//현재 층 수에 버튼에 적혀 있는 값을 더한 층으로 이동하게 된다.
	//엘레베이터가 위치해 있는 층과 버튼의 값을 더한 결과가 0보다 작으면 엘레빙터는 움직이지 않는다.

	//1. 10^x 을 만드는 최소의 방법
	// 1 <= x <= 8

	public static int solution(int storey) {
		int answer = 0;

		while (storey != 0) {
			int n = storey % 10;

			if (n >= 6 || (n == 5 && storey / 10 % 10 >= 5)) {
				storey += 10 - n;
				answer += 10 - n;
			} else {
				answer += n;
			}
			storey /= 10;
		}

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(solution(16));
		System.out.println(solution(2554));
		System.out.println(solution(95) == 6);
		System.out.println(solution(155) == 11);
		System.out.println(solution(75) == 8);
		System.out.println(solution(555) == 14);
		System.out.println(solution(545) == 14);
	}
}
