package programmers;

import java.util.StringTokenizer;

public class JadenCase문자열만들기 {

	// 모든 단어의 첫 문자는 대문자
	// 그 외에 알파벳은 소문자

	public static String solution(String s) {
		StringTokenizer st = new StringTokenizer(s, " ", true);
		StringBuilder sb = new StringBuilder();

		while (st.hasMoreTokens()) {
			String str = st.nextToken();
			if (str.startsWith(" ")) {
				sb.append(str);
				continue;
			}

			if (isStartWithNumber(str)) {
				sb.append(str.charAt(0));
			} else if (isStartWithLowerAlpha(str)) {
				sb.append((char)(str.charAt(0) - 32));
			} else{
				sb.append(str.charAt(0));
			}

			sb.append(str.substring(1).toLowerCase());
		}

		return sb.toString();
	}

	private static boolean isStartWithLowerAlpha(String str) {
		return str.charAt(0) >= 'a' && str.charAt(0) <= 'z';
	}

	private static boolean isStartWithNumber(String str) {
		return str.charAt(0) >= '0' && str.charAt(0) <= '9';
	}

	public static void main(String[] args) {
		System.out.println(solution("3people  unFollowed me "));
		System.out.println(solution("for the last week"));
		System.out.println(solution("a aa"));
		System.out.println(solution("A Aa"));
	}
}
