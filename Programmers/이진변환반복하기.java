package programmers;

import java.math.BigInteger;
import java.util.Arrays;

public class 이진변환반복하기 {

	public static int[] solution(String s) {
		StringBuilder sb;
		int zeroCount = 0;
		int binaryCount = 0;
		BigInteger bigInteger = new BigInteger(s);

		while ((bigInteger.compareTo(new BigInteger("1"))) > 0) {
			binaryCount++;
			sb = new StringBuilder();

			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == '1') {
					sb.append(s.charAt(i));
				} else {
					zeroCount++;
				}
			}

			bigInteger = new BigInteger(converter(String.valueOf(sb.length())));
			s = String.valueOf(bigInteger);
		}

		return new int[] {binaryCount, zeroCount};
	}

	private static String converter(String s) {
		StringBuilder sb = new StringBuilder();
		BigInteger bigInteger = new BigInteger(s);

		while ((bigInteger.compareTo(new BigInteger("1"))) > 0) {
			sb.append(bigInteger.remainder(new BigInteger("2")));
			bigInteger = bigInteger.divide(new BigInteger("2"));
		}
		sb.append(bigInteger);
		return sb.reverse().toString();
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution("110010101001")));
		System.out.println(Arrays.toString(solution("01110")));
		System.out.println(Arrays.toString(solution("1111111")));
	}

}
