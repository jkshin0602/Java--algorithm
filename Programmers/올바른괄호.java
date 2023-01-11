package programmers;

import java.util.Stack;

public class 올바른괄호 {

	static boolean solution(String s) {
		Stack<Character> stack = new Stack<>();

		if (s.charAt(0) == ')') {
			return false;
		}
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(') {
				stack.push(c);
			} else {
				if (!stack.isEmpty()) {
					stack.pop();
				}
			}

		}

		if (stack.size() > 0) {
			return false;
		}

		return true;
	}

	public static void main(String[] args) {
		System.out.println(solution("()()"));
		System.out.println(solution("(())()"));
		System.out.println(solution(")()("));
		System.out.println(solution("(()("));
		System.out.println(solution(")"));

	}
}
