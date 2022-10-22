package programmers;

public class 시저암호 {

	public static String solution(String s, int n) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c >= 'a' && c <= 'z') {
				c += n;
				if (c > 'z') {
					int a = c - 'z';
					c = (char)('a' - 1 + a);
				}
				sb.append(c);
			} else if (c >= 'A' && c <= 'Z') {
				c += n;
				if (c > 'Z') {
					int a = c - 'Z';
					c = (char)('A' - 1 + a);
				}
				sb.append(c);
			} else {
				sb.append(' ');
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(solution("AB", 1).equals("BC"));
		System.out.println(solution("z", 1).equals("a"));
		System.out.println(solution("a B z", 4).equals("e F d"));
	}
}


