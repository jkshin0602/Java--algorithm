package programmers;

public class 푸드파이트대회 {

	public static String solution(int[] food) {
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < food.length; i++) {
			for (int j = 1; j < food[i]; j += 2) {
				sb.append(i);
			}

		}

		String answer = sb + "0";
		answer += sb.reverse();
		return answer;
	}

	public static void main(String[] args) {
		System.out.println(solution(new int[] {1, 3, 4, 6}));
		System.out.println(solution(new int[] {1, 7, 1, 2}));
	}
}
