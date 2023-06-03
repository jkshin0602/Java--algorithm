package book.nadongbin.문제.구현;

public class 문자열_압축 {

	//aabbaccc->2a2ba3c
	//1개 이상의 단위로 잘라서 압축
	//가장 짧게 압축 한 것의 길이

	public static int solution(String s) {

		int answer = s.length();

		for (int i = 1; i <= s.length() / 2; i++) {
			int level = 1;

			String str = s.substring(0, i);
			StringBuilder sb = new StringBuilder();

			for (int j = i; j <= s.length(); j += i) {
				String next;

				if (i + j > s.length()) {
					next = s.substring(j);
				} else {
					next = s.substring(j, i + j);
				}

				if (str.equals(next)) {
					level++;
				} else {
					if (level != 1) {
						sb.append(level);
					}
					sb.append(str);
					str = next;
					level = 1;
				}
			}

			sb.append(str);
			answer = Math.min(answer, sb.length());
		}

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(solution("aabbaccc"));
		System.out.println(solution("ababcdcdababcdcd"));
		System.out.println(solution("abcabcdede"));
		System.out.println(solution("abcabcabcabcdededededede"));
		System.out.println(solution("xababcdcdababcdcd"));
	}
}
