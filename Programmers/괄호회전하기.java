package programmers;

import java.util.Stack;

public class 괄호회전하기 {

	public static int solution(String s) {

		int answer = 0;
		if (isProper(s)) {
			answer++;
		}

		for (int x = 1; x < s.length(); x++) {
			s = rotationBracket(s);
			if (isProper(s)) {
				answer++;
			}
		}

		return answer;
	}

	//괄호 회전하는 함수
	private static String rotationBracket(String s) {
		return s.substring(1) + s.charAt(0);
	}

	//올바른 괄호 문자열인지 검사하는 함수
	private static boolean isProper(String s) {
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '[' || s.charAt(i) == '(' || s.charAt(i) == '{') {
				stack.push(s.charAt(i));
			} else {
				if (!stack.isEmpty()) {
					switch (s.charAt(i)) {
						case ']':
							isProperBracket(stack, '[');
							break;
						case ')':
							isProperBracket(stack, '(');
							break;
						case '}':
							isProperBracket(stack, '{');
							break;
					}
				} else {
					stack.push(s.charAt(i));
				}
			}
		}

		return stack.isEmpty();
	}

	private static void isProperBracket(Stack<Character> stack, char bracket) {
		if (stack.peek() == bracket) {
			stack.pop();
		}
	}

	//1 <= s <= 1000
	//0 <= x<= s, x 칸 만큼 왼쪽으로 회전시켰을 때 s가 올바른 괄호 문자열이 되게 하는 x의 개수
	//왼쪽 회전
	// [](){} -> ](){}[ -> (){}[]

	public static void main(String[] args) {
		System.out.println(solution("[](){}") == 3);
		System.out.println(solution("}]()[{") == 2);
		System.out.println(solution("[)(]") == 0);
		System.out.println(solution("}}}") == 0);
	}
}
