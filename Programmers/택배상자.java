package programmers;

import java.util.Stack;

public class 택배상자 {

	public static int solution(int[] order) {
		int answer = 0;
		Stack<Integer> s = new Stack<>();

		int idx = 0;

		for (int i = 1; i <= order.length; i++) {
			boolean flag = false;
			//1. 꺼낸 택배상자가 순서에 맞을때
			if (i == order[idx]) {
				idx++;
				answer++;
				flag = true;
			}
			//2. 꺼낸 택배상자가 순서에 맞지 않지만, 보조 컨테이너에서 꺼낸 택배가 순서에 맞을 때 (맞으면 계속 꺼내준다)
			while (!s.isEmpty() && s.peek() == order[idx]) {
				s.pop();
				idx++;
				answer++;
				flag = true;
			}
			//3. 둘다 아닐 때는 보조 컨테이너에 넣는다
			if (!flag) {
				s.add(i);
			}
		}

		//4. 남은 상자들을 보조 컨테이너에서 빼준다
		while (!s.isEmpty() && s.peek() == order[idx]) {
			s.pop();
			idx++;
			answer++;
		}

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(solution(new int[] {4, 3, 1, 2, 5}));
		System.out.println(solution(new int[] {5, 4, 3, 2, 1}));
		System.out.println(solution(new int[] {3, 2, 1, 4, 5}));
	}

}
