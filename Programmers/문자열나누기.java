package programmers;

public class 문자열나누기 {

	// 1. 첫 글자 x
	// 2. x의 갯수와, x가 아닌 다른 글자들이 나온 횟수를 세기
	// 3. 처음으로 두 횟수가 같아지는 순간 멈추고, 지금까지 읽은 문자열 분리
	// 4. 더이상 읽을 글자가 없으면 분리/종료

	public static int solution(String s) {
		char x = s.charAt(0);
		int answer = 0;
		int mainCount = 1;
		int subCount = 0;

		for (int i = 1; i < s.length(); i++) {
			if (x == ' ') {
				x = s.charAt(i);
				continue;
			}
			if (x == s.charAt(i)) {
				mainCount++;
			}else{
				subCount++;
			}
			if (mainCount == subCount) {
				answer++;
				x = ' ';
				mainCount = 1;
				subCount = 0;
			}
		}
		if (x != ' ') {
			answer++;
		}

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(solution("banana"));
		System.out.println(solution("abracadabra"));
		System.out.println(solution("aaabbaccccabba"));
	}
}
