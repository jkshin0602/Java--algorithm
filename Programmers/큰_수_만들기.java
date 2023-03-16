package programmers;

import java.util.Stack;

public class 큰_수_만들기 {

	public static String solution(String number, int k) {

		Stack<Integer> s = new Stack<>();
		for (int i = 0; i < number.length(); i++) {
			int c = number.charAt(i) - '0';

			while (!s.isEmpty() && s.peek() < c && k > 0) {
				s.pop();
				k--;
			}
			s.push(c);
		}

		while (k > 0) {
			s.pop();
			k--;
		}

		return s.toString().substring(1, s.toString().length() - 1).replace(", ", "");
	}

	public static void main(String[] args) {
		System.out.println(solution("1924", 2));
		System.out.println(solution("1231234", 3));
		System.out.println(solution("4177252841", 4));
		System.out.println(solution("99", 1));
		System.out.println(solution("999", 1));
		System.out.println(solution("4321", 1));
	}
}
