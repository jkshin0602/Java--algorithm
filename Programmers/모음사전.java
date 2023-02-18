package programmers;

public class 모음사전 {

	// A, E, I, O ,U 로만 만들 수 있는 5글자 이하의 단어
	// A, AA, ... , UUUUU
	// 주어진 단어가 몇번째 단어인지

	private static String[] dictionary = {"A", "E", "I", "O", "U"};
	private static int ans;

	public static int solution(String word) {
		ans = 0;
		go(word, 0, new StringBuilder());
		return ans;
	}

	private static void go(String word, int count, StringBuilder sb) {
		if (count == dictionary.length) {
			return;
		}
		for (int i = 0; i < 5; i++) {
			if (sb.toString().equals(word)) {
				return;
			}
			ans++;
			sb.append(dictionary[i]);
			go(word, count + 1, sb);
			if (sb.toString().equals(word)) {
				return;
			}
			sb.deleteCharAt(sb.length() - 1);
		}
	}

	public static void main(String[] args) {
		System.out.println(solution("A"));
		System.out.println(solution("AAAAE"));
		System.out.println(solution("AAAE"));
		System.out.println(solution("I"));
		System.out.println(solution("EIO"));
	}
}
