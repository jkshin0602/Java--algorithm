package programmers;

import java.util.Stack;

public class 괄호_변환 {

	public static String solution(String p) {
		return go(p);
	}

	private static String go(String p) {
		//1. 입력이 빈 문자열인 경우, 빈 문자열 반환
		if (p.equals("")) {
			return "";
		}

		StringBuilder sb = new StringBuilder();
		String[] tmp = splitString(p);
		String u = tmp[0];
		String v = tmp[1];

		//3. 문자열 u가 올바른 괄호 문자열이라면 문자열 v에 대해 1단계부터 다시 수행
		if (isBracket(u)) {
			//3-1. 수정한 결과 문자열을 u에 이어 붙인 후 반환
			sb.append(u).append(go(v));
		} else {    //4. 문자열 u가 올바른 괄호 문자열이 아니라면 아래 과정 수행
			//4-1. 빈 문자열에 첫 번째 문자로 '('를 붙임
			//4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙임
			//4-3. ')'를 다시 붙임
			//4-4. u의 첫번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙임
			sb.append('(').append(go(v)).append(')').append(removeAndBracketReverse(u));
		}

		//4-5. 생성된 문자열 반환
		return sb.toString();
	}

	//괄호의 앞뒤문자 제거 후, 남은 괄호들 뒤집어줌 (뒤집다 -> 문자열 뒤집기 x , ( -> ) , ) -> ( 으로 뒤집으라는 뜻
	private static String removeAndBracketReverse(String u) {
		u = u.substring(1);
		u = u.substring(0, u.length() - 1);
		if (u.equals("")) {
			return "";
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < u.length(); i++) {
			if (u.charAt(i) == '(') {
				sb.append(')');
			} else {
				sb.append('(');
			}
		}

		return sb.toString();
	}

	//올바른 괄호인지 확인 - Stack 사용
	private static boolean isBracket(String u) {
		Stack<Character> s = new Stack<>();

		for (int i = 0; i < u.length(); i++) {
			char c = u.charAt(i);

			if (c == '(') {
				s.push(c);
			} else {
				if (s.isEmpty()) {
					return false;
				}
				s.pop();
			}
		}

		return s.isEmpty();
	}

	//2. 문자열 w를 두 "균형 잡힌 괄호 문자열" u, v로 분리. 단 u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 하며, v는 빈 문자열이 될 수도 있다.
	private static String[] splitString(String p) {
		int open = 0;
		int close = 0;
		for (int i = 0; i < p.length(); i++) {
			if (p.charAt(i) == '(') {
				open++;
			} else {
				close++;
			}
			if (open == close) {
				String u = p.substring(0, i + 1);
				String v = "";
				if (p.length() >= i + 1) {
					v = p.substring(i + 1);
				}
				return new String[] {u, v};
			}
		}
		return new String[] {"", ""};
	}

	public static void main(String[] args) {
		System.out.println(solution("(()())()").equals("(()())()"));
		System.out.println(solution(")(").equals("()"));
		System.out.println(solution("()))((()").equals("()(())()"));
	}

}
