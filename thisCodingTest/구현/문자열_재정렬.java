package book.nadongbin.문제.구현;

import java.util.Arrays;

public class 문자열_재정렬 {

	//알파벳 대문자와 숫자(0~9)로만 구성된 문자열이 입력으로 주어진다.
	//모든 알파벳을 오름차순으로 정렬하여 출력 한 뒤, 모든 숫자를 더한 값을 이어서 출력

	public static String solution(String s) {
		StringBuilder sb = new StringBuilder();

		int sum = 0;
		for (int i = 0; i < s.length(); i++) {
			if ('0' <= s.charAt(i) && s.charAt(i) <= '9') {
				sum += s.charAt(i) - '0';
				continue;
			}

			sb.append(s.charAt(i));
		}

		char[] array = sb.toString().toCharArray();
		Arrays.sort(array);

		return String.valueOf(array) + sum;
	}

	public static void main(String[] args) {
		System.out.println(solution("K1KA5CB7"));
		System.out.println(solution("AJKDLSI412K4JSJ9D"));
	}
}
