package programmers;

import java.util.Stack;

public class CranePuppetGame {

	public static int solution(int[][] board, int[] moves) {

		Stack<Integer> basket = new Stack<>();
		int answer = 0;

		for (int i = 0; i < moves.length; i++) {
			int movePosition = moves[i] - 1;
			for (int j = 0; j < board.length; j++) {
				if (board[j][movePosition] != 0) {
					int dollNumber = board[j][movePosition];
					answer += pushBasket(basket, dollNumber);
					board[j][movePosition] = 0;
					break;
				}
			}
		}

		return answer;
	}

	public static int pushBasket(Stack<Integer> basket, int dollNumber) {

		if (!basket.empty()) {
			int peek = basket.peek();
			if (dollNumber == peek) {
				basket.pop();
				return 2;
			} else {
				basket.push(dollNumber);
			}
		} else {
			basket.push(dollNumber);
		}
		return 0;
	}
}
