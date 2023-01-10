package programmers;

import java.util.Stack;

public class 짝지어제거하기 {

	public static int solution(String s) {
		Stack<Character> stack = new Stack<>();
		int idx = 0;

		if (s.length() == 0) {
			return 0;
		}

		stack.push(s.charAt(idx++));
		while (idx < s.length()) {
			char c = s.charAt(idx++);

			if (!stack.isEmpty() && stack.peek() == c) {
				stack.pop();
			} else {
				stack.push(c);
			}

		}

		return stack.isEmpty() ? 1 : 0;
	}

	public static void main(String[] args) {
		// System.out.println(solution("baabaa"));
		// System.out.println(solution("cdcd"));
		// System.out.println(solution(""));
		// System.out.println(solution("a"));
		System.out.println(solution("aaaaa"));


	}
}
