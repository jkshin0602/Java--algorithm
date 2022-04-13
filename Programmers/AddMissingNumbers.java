package programmers;

public class AddMissingNumbers {

	public static int solution(int[] numbers) {
		boolean[] isCheck = new boolean[10];

		for (int i: numbers) {
			isCheck[i] = true;
		}
		int answer = 0;
		for (int i = 0; i < isCheck.length; i++) {
			if (!isCheck[i]) {
				answer += i;
			}
		}

		return answer == 0 ? -1 : answer;
	}
}
