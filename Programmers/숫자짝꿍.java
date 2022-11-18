package programmers;

public class 숫자짝꿍 {

	public static String solution(String X, String Y) {
		int[] countX = new int[10];
		int[] countY = new int[10];

		getNumberCount(X, countX);
		getNumberCount(Y, countY);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 10; i++) {
			if (isNotZeroAndEquals(countX, countY, i)) {
				sb.append(i);
				countX[i]--;
				countY[i]--;
				i = -1;
			}
		}

		if (sb.length() == 0) {
			return "-1";
		}
		if (sb.toString().matches("0*")) {
			return "0";
		}
		return sb.reverse().toString();
	}

	private static boolean isNotZeroAndEquals(int[] countX, int[] countY, int idx) {
		return countX[idx] != 0 && countY[idx] != 0 && (countX[idx] >= countY[idx] || countX[idx] <= countY[idx]);
	}

	private static void getNumberCount(String s, int[] count) {
		for (int i = 0; i < s.length(); i++) {
			count[s.charAt(i) - '0']++;
		}
	}

	public static void main(String[] args) {
		System.out.println(solution("100", "2345"));
		System.out.println(solution("100", "203045"));
		System.out.println(solution("100", "123450"));
		System.out.println(solution("12321", "42531"));
		System.out.println(solution("5525", "1255"));
	}

}
