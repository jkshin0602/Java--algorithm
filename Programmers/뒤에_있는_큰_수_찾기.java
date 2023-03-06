package programmers;

import java.util.Arrays;
import java.util.Stack;

public class 뒤에_있는_큰_수_찾기 {

	//배열의 각 원소들에 대해 자신보다 뒤에 있는 숫자 중에서 자신보다 크면서 가장 가까이 있는 수를 큰 수
	//큰수가 존재하지 않으면 -1을 담음

	public static int[] solution(int[] numbers) {
		int[] answer = new int[numbers.length];
		Stack<Integer> s = new Stack<>();

		for (int i = 0; i < numbers.length; i++) {
			while (!s.isEmpty() && numbers[s.peek()] < numbers[i]) {
				answer[s.pop()] = numbers[i];
			}
			s.push(i);
		}
		while (!s.isEmpty()) {
			answer[s.pop()] = -1;
		}

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new int[] {2, 3, 3, 5})));
		System.out.println(Arrays.toString(solution(new int[] {9, 1, 5, 3, 6, 2})));
	}
}
