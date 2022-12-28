package programmers;

import java.util.Stack;

public class 햄버거만들기 {

	// 1,2,3,1{빵,야채,고기,빵}
	public static int solution(int[] ingredient) {
		int answer = 0;
		Stack<Integer> s = new Stack<>();

		for (int value : ingredient) {
			s.push(value);

			if (s.size() >= 4) {
				if (isHamburger(s)) {
					makeHamburger(s);
					answer++;
				}
			}
		}

		return answer;
	}

	private static void makeHamburger(Stack<Integer> s) {
		for (int i = 0; i < 4; i++) {
			s.pop();
		}
	}

	private static boolean isHamburger(Stack<Integer> s) {
		return s.get(s.size() - 4) == 1
			&& s.get(s.size() - 3) == 2
			&& s.get(s.size() - 2) == 3
			&& s.get(s.size() - 1) == 1;
	}

	public static void main(String[] args) {
		System.out.println(solution(new int[] {2, 1, 1, 2, 3, 1, 2, 3, 1}));
		System.out.println(solution(new int[] {1, 3, 2, 1, 2, 1, 3, 1, 2}));
		System.out.println(solution(new int[] {1, 2, 1, 2, 3, 1, 3, 1, 2, 3, 1, 2, 3, 1}));
	}
}
