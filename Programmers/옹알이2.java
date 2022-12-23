package programmers;

public class 옹알이2 {

	private static final String[] keyword = {"aya", "ye", "woo", "ma"};

	public static int solution(String[] babbling) {
		int answer = 0;

		for (String babble : babbling) {
			babble = replaceKeyword(babble);

			if (babble.matches("^[0-9]*$") && isContinuity(babble)) {
				answer++;
			}
		}

		return answer;
	}

	private static String replaceKeyword(String babble) {
		for (int i = 0; i < keyword.length; i++) {
			babble = babble.replaceAll(keyword[i], String.valueOf(i));
		}
		return babble;
	}

	private static boolean isContinuity(String babble) {
		for (int i = 0; i < babble.length() - 1; i++) {
			if (babble.charAt(i) == babble.charAt(i + 1)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(solution(new String[] {"aya", "yee", "u", "maa"}));
		System.out.println(solution(new String[] {"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"}));
		System.out.println(solution(new String[] {"maayama"}));

	}
}
